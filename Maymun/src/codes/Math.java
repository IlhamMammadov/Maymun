/*
 * Decompiled with CFR 0_115.
 */
package codes;

import codes.History;
import codes.MathQuestion;
import codes.RW;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Math
extends JPanel {
    private JTextField mathAnswer;
    private JLabel mathReaction;
    private JLabel mathTest;
    private JLabel mathPoints;
    private JLabel mathName;
    private JButton mathStart;
    private JButton mathOK;
    private String Name;
    private MathQuestion mQ;
    private int Points;

    public Math(String name) {
        this.setLayout(null);
        this.init(name);
        this.mathStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Math.access$0(Math.this, new MathQuestion());
                Math.this.mathTest.setText(String.valueOf(Integer.toString(Math.access$2((Math)Math.this).fn)) + " " + Math.access$2((Math)Math.this).operation + " " + Integer.toString(Math.access$2((Math)Math.this).sn) + " = ");
                Math.this.mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-icon.png")));
                Math.this.mathName.setText("Bir daha, " + Math.this.Name + "!");
                Math.this.mathAnswer.setText("");
            }
        });
        this.mathOK.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(Math.this.mathAnswer.getText()) == Math.access$2((Math)Math.this).answer) {
                        Math.this.mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
                        Math.this.mathName.setText("Af\u0259rin, " + Math.this.Name + "!");
                        Math math = Math.this;
                        Math.access$8(math, math.Points + 1);
                        Math.this.mathPoints.setText("S\u0259nin xal\u0131n: " + Math.this.Points);
                        Math.this.record();
                        Math.this.mathAnswer.setText("");
                        Math.access$0(Math.this, new MathQuestion());
                        Math.this.mathTest.setText(String.valueOf(Integer.toString(Math.access$2((Math)Math.this).fn)) + " " + Math.access$2((Math)Math.this).operation + " " + Integer.toString(Math.access$2((Math)Math.this).sn) + " = ");
                        Math.this.playSound("yeah");
                    } else {
                        Math.this.mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
                        Math.this.mathName.setText("Olmad\u0131 ki, " + Math.this.Name + "!");
                        Math math = Math.this;
                        Math.access$8(math, math.Points - 1);
                        Math.this.mathPoints.setText("S\u0259nin xal\u0131n: " + Math.this.Points);
                        Math.this.record();
                        Math.this.playSound("sad");
                    }
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Riyaziyyat b\u00f6lm\u0259sind\u0259 ancaq \u0259d\u0259dl\u0259r yaz\u0131la bil\u0259r!");
                }
            }
        });
        this.mathAnswer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(Math.this.mathAnswer.getText()) == Math.access$2((Math)Math.this).answer) {
                        Math.this.mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
                        Math.this.mathName.setText("Af\u0259rin, " + Math.this.Name + "!");
                        Math math = Math.this;
                        Math.access$8(math, math.Points + 1);
                        Math.this.mathPoints.setText("S\u0259nin xal\u0131n: " + Math.this.Points);
                        Math.this.record();
                        Math.this.mathAnswer.setText("");
                        Math.access$0(Math.this, new MathQuestion());
                        Math.this.mathTest.setText(String.valueOf(Integer.toString(Math.access$2((Math)Math.this).fn)) + " " + Math.access$2((Math)Math.this).operation + " " + Integer.toString(Math.access$2((Math)Math.this).sn) + " = ");
                        Math.this.playSound("yeah");
                    } else {
                        Math.this.mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
                        Math.this.mathName.setText("Olmad\u0131 ki, " + Math.this.Name + "!");
                        Math math = Math.this;
                        Math.access$8(math, math.Points - 1);
                        Math.this.mathPoints.setText("S\u0259nin xal\u0131n: " + Math.this.Points);
                        Math.this.record();
                        Math.this.playSound("sad");
                    }
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Riyaziyyat b\u00f6lm\u0259sind\u0259 ancaq \u0259d\u0259dl\u0259r yaz\u0131la bil\u0259r!");
                    e1.printStackTrace();
                }
            }
        });
    }

    public void playSound(String name) {
        try {
            InputStream instr = this.getClass().getResourceAsStream("/resources/sounds/" + name + ".wav");
            AudioStream astr = new AudioStream(instr);
            AudioPlayer.player.stop();
            AudioPlayer.player.start(astr);
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sound error");
        }
    }

    public void record() {
        History.MyModel.setValueAt(this.Name, History.MyModel.getRowCount() - 1, 0);
        History.MyModel.setValueAt("Hesab", History.MyModel.getRowCount() - 1, 1);
        History.MyModel.setValueAt(this.Points, History.MyModel.getRowCount() - 1, 2);
    }

    private void init(String name) {
        this.mQ = new MathQuestion();
        this.Points = 0;
        if (History.MyModel.getValueAt(History.MyModel.getRowCount() - 1, 0) != null) {
            History.MyModel.insertRow(History.MyModel.getRowCount(), new Object[0]);
        }
        this.setBounds(100, 100, 450, 350);
        this.setLayout(null);
        this.Name = name;
        this.mathName = new JLabel("Salam, " + this.Name + "!");
        this.mathName.setFont(new Font("Tahoma", 0, 16));
        this.mathName.setHorizontalAlignment(0);
        this.mathName.setBounds(235, 60, 157, 28);
        this.add(this.mathName);
        this.mathAnswer = new JTextField();
        this.mathAnswer.setBounds(164, 176, 43, 35);
        this.mathAnswer.setFont(this.mathName.getFont());
        this.add(this.mathAnswer);
        this.mathAnswer.setColumns(10);
        this.mathReaction = new JLabel("");
        this.mathReaction.setHorizontalAlignment(0);
        this.mathReaction.setIcon(new ImageIcon(Math.class.getResource("/resources/img/rsz_monkey-icon.png")));
        this.mathReaction.setBounds(242, 95, 150, 140);
        this.add(this.mathReaction);
        this.mathTest = new JLabel(String.valueOf(Integer.toString(this.mQ.fn)) + " " + this.mQ.operation + " " + Integer.toString(this.mQ.sn) + " = ");
        this.mathTest.setHorizontalAlignment(4);
        this.mathTest.setFont(this.mathName.getFont());
        this.mathTest.setBounds(58, 179, 96, 32);
        this.add(this.mathTest);
        this.mathPoints = new JLabel("S\u0259nin xal\u0131n: " + this.Points);
        this.mathPoints.setHorizontalAlignment(0);
        this.mathPoints.setFont(this.mathName.getFont());
        this.mathPoints.setBounds(218, 235, 201, 38);
        this.add(this.mathPoints);
        this.mathStart = new JButton("");
        this.mathStart.setToolTipText("Altdak\u0131 misal\u0131n cavab\u0131n\u0131 yaz");
        this.mathStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Math.access$0(Math.this, new MathQuestion());
                Math.this.mathTest.setText(String.valueOf(Integer.toString(Math.access$2((Math)Math.this).fn)) + " " + Math.access$2((Math)Math.this).operation + " " + Integer.toString(Math.access$2((Math)Math.this).sn) + " = ");
            }
        });
        this.mathStart.setIcon(new ImageIcon(Math.class.getResource("/resources/img/calculator.png")));
        this.mathStart.setBounds(58, 60, 150, 73);
        this.add(this.mathStart);
        this.mathOK = new JButton("OK");
        this.mathOK.setBounds(58, 245, 150, 23);
        this.add(this.mathOK);
    }

    static /* synthetic */ void access$0(Math math, MathQuestion mathQuestion) {
        math.mQ = mathQuestion;
    }

    static /* synthetic */ MathQuestion access$2(Math math) {
        return math.mQ;
    }

    static /* synthetic */ void access$8(Math math, int n) {
        math.Points = n;
    }

}

