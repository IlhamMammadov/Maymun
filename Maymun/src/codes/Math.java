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
        setLayout(null);
        init(name);
        mathStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                mQ = new MathQuestion();
                mathTest.setText(String.valueOf(Integer.toString(mQ.fn)) + " " + mQ.operation + " " + Integer.toString(mQ.sn) + " = ");
                mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-icon.png")));
                mathName.setText("Bir daha, " + Name + "!");
                mathAnswer.setText("");
            }
        });
        mathOK.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(mathAnswer.getText()) == mQ.answer) {
                        mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
                        mathName.setText("Af\u0259rin, " + Name + "!");
                        Math math = Math.this;
                        Points++;
                        mathPoints.setText("S\u0259nin xal\u0131n: " + Points);
                        record();
                        mathAnswer.setText("");
                        mQ = new MathQuestion();
                        mathTest.setText(String.valueOf(Integer.toString(mQ.fn)) + " " + mQ.operation + " " + Integer.toString(mQ.sn) + " = ");
                        playSound("yeah");
                    } else {
                        mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
                        mathName.setText("Olmad\u0131 ki, " + Name + "!");
                        Math math = Math.this;
                        Points--;
                        mathPoints.setText("S\u0259nin xal\u0131n: " + Points);
                        record();
                        playSound("sad");
                    }
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Riyaziyyat b\u00f6lm\u0259sind\u0259 ancaq \u0259d\u0259dl\u0259r yaz\u0131la bil\u0259r!");
                }
            }
        });
        mathAnswer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(mathAnswer.getText()) == mQ.answer) {
                        mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
                        mathName.setText("Af\u0259rin, " + Name + "!");
                        Math math = Math.this;
                        Points++;
                        mathPoints.setText("S\u0259nin xal\u0131n: " + Points);
                        record();
                        mathAnswer.setText("");
                        mQ = new MathQuestion();
                        mathTest.setText(String.valueOf(Integer.toString(mQ.fn)) + " " + mQ.operation + " " + Integer.toString(mQ.sn) + " = ");
                        playSound("yeah");
                    } else {
                        mathReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
                        mathName.setText("Olmad\u0131 ki, " + Name + "!");
                        Math math = Math.this;
                        Points--;
                        mathPoints.setText("S\u0259nin xal\u0131n: " + Points);
                        record();
                        playSound("sad");
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
            InputStream instr = getClass().getResourceAsStream("/resources/sounds/" + name + ".wav");
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
        History.MyModel.setValueAt(Name, History.MyModel.getRowCount() - 1, 0);
        History.MyModel.setValueAt("Hesab", History.MyModel.getRowCount() - 1, 1);
        History.MyModel.setValueAt(Points, History.MyModel.getRowCount() - 1, 2);
    }

    private void init(String name) {
        mQ = new MathQuestion();
        Points = 0;
        if (History.MyModel.getValueAt(History.MyModel.getRowCount() - 1, 0) != null) {
            History.MyModel.insertRow(History.MyModel.getRowCount(), new Object[0]);
        }
        setBounds(100, 100, 450, 350);
        setLayout(null);
        Name = name;
        mathName = new JLabel("Salam, " + Name + "!");
        mathName.setFont(new Font("Tahoma", 0, 16));
        mathName.setHorizontalAlignment(0);
        mathName.setBounds(235, 60, 157, 28);
        add(mathName);
        mathAnswer = new JTextField();
        mathAnswer.setBounds(164, 176, 43, 35);
        mathAnswer.setFont(mathName.getFont());
        add(mathAnswer);
        mathAnswer.setColumns(10);
        mathReaction = new JLabel("");
        mathReaction.setHorizontalAlignment(0);
        mathReaction.setIcon(new ImageIcon(Math.class.getResource("/resources/img/rsz_monkey-icon.png")));
        mathReaction.setBounds(242, 95, 150, 140);
        add(mathReaction);
        mathTest = new JLabel(String.valueOf(Integer.toString(mQ.fn)) + " " + mQ.operation + " " + Integer.toString(mQ.sn) + " = ");
        mathTest.setHorizontalAlignment(4);
        mathTest.setFont(mathName.getFont());
        mathTest.setBounds(58, 179, 96, 32);
        add(mathTest);
        mathPoints = new JLabel("S\u0259nin xal\u0131n: " + Points);
        mathPoints.setHorizontalAlignment(0);
        mathPoints.setFont(mathName.getFont());
        mathPoints.setBounds(218, 235, 201, 38);
        add(mathPoints);
        mathStart = new JButton("");
        mathStart.setToolTipText("Altdak\u0131 misal\u0131n cavab\u0131n\u0131 yaz");
        mathStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                mQ = new MathQuestion();
                mathTest.setText(String.valueOf(Integer.toString(mQ.fn)) + " " + mQ.operation + " " + Integer.toString(mQ.sn) + " = ");
            }
        });
        mathStart.setIcon(new ImageIcon(Math.class.getResource("/resources/img/calculator.png")));
        mathStart.setBounds(58, 60, 150, 73);
        add(mathStart);
        mathOK = new JButton("OK");
        mathOK.setBounds(58, 245, 150, 23);
        add(mathOK);
    }


}

