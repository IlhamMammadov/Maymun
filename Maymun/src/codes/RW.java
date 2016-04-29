/*
 * Decompiled with CFR 0_115.
 */
package codes;

import codes.History;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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

public class RW
extends JPanel {
    private JTextField rwAnswer;
    private JLabel rwReaction;
    private JLabel rwTest;
    private JLabel rwPoints;
    private JButton rwStart;
    private JButton rwOK;
    private ArrayList<String> Test;
    private Random r = new Random();
    private JLabel rwName;
    private String Name;
    private int Points;

    public void init(String name) {
        this.setBounds(100, 100, 450, 350);
        this.setLayout(null);
        this.readfile();
        this.Points = 0;
        if (History.MyModel.getValueAt(History.MyModel.getRowCount() - 1, 0) != null) {
            History.MyModel.insertRow(History.MyModel.getRowCount(), new Object[0]);
        }
        this.Name = name;
        this.rwName = new JLabel("Salam, " + this.Name + "!");
        this.rwName.setFont(new Font("Tahoma", 0, 16));
        this.rwName.setHorizontalAlignment(0);
        this.rwName.setBounds(235, 60, 157, 28);
        this.add(this.rwName);
        this.rwAnswer = new JTextField();
        this.rwAnswer.setFont(this.rwName.getFont());
        this.rwAnswer.setBounds(58, 193, 150, 20);
        this.add(this.rwAnswer);
        this.rwAnswer.setColumns(10);
        this.rwReaction = new JLabel("");
        this.rwReaction.setHorizontalAlignment(0);
        this.rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-icon.png")));
        this.rwReaction.setBounds(242, 95, 150, 140);
        this.add(this.rwReaction);
        this.rwTest = new JLabel(this.Test.get(0));
        this.rwTest.setHorizontalAlignment(0);
        this.rwTest.setFont(this.rwName.getFont());
        this.rwTest.setBounds(31, 144, 201, 38);
        this.add(this.rwTest);
        this.rwPoints = new JLabel("S\u0259nin xal\u0131n: " + this.Points);
        this.rwPoints.setHorizontalAlignment(0);
        this.rwPoints.setFont(this.rwName.getFont());
        this.rwPoints.setBounds(218, 235, 201, 38);
        this.add(this.rwPoints);
        this.rwStart = new JButton("");
        this.rwStart.setToolTipText("Altdak\u0131 yaz\u0131n\u0131 t\u0259krar yaz");
        this.rwStart.setIcon(new ImageIcon(RW.class.getResource("/resources/img/compose.png")));
        this.rwStart.setBounds(58, 60, 150, 73);
        this.add(this.rwStart);
        this.rwOK = new JButton("OK");
        this.rwOK.setBounds(58, 245, 150, 23);
        this.add(this.rwOK);
    }

    public void readfile() {
        try {
            InputStream in = RW.class.getResourceAsStream("/resources/txt/RWtest.txt");
            BufferedReader txt = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            Scanner s = new Scanner(txt);
            this.Test = new ArrayList();
            while (s.hasNextLine()) {
                this.Test.add(s.nextLine());
            }
            this.Test.set(0, this.Test.get(0).startsWith("\ufeff") ? this.Test.get(0).substring(1) : this.Test.get(0));
            s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
        History.MyModel.setValueAt("Oxu v\u0259 Yaz", History.MyModel.getRowCount() - 1, 1);
        History.MyModel.setValueAt(this.Points, History.MyModel.getRowCount() - 1, 2);
    }

    public RW(String name) {
        this.init(name);
        this.rwStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                RW.this.rwTest.setText((String)RW.this.Test.get(RW.this.r.nextInt(RW.this.Test.size())));
                RW.this.rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-icon.png")));
                RW.this.rwName.setText("Bir daha, " + RW.this.Name + "!");
                RW.this.rwAnswer.setText("");
            }
        });
        this.rwOK.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (RW.this.rwAnswer.getText().equals(new String(RW.this.rwTest.getText().getBytes("UTF-8")))) {
                        RW.this.rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
                        RW.this.rwName.setText("Af\u0259rin, " + RW.this.Name + "!");
                        RW rW = RW.this;
                        RW.access$8(rW, rW.Points + 1);
                        RW.this.rwPoints.setText("S\u0259nin xal\u0131n: " + RW.this.Points);
                        RW.this.record();
                        RW.this.rwAnswer.setText("");
                        RW.this.rwTest.setText((String)RW.this.Test.get(RW.this.r.nextInt(RW.this.Test.size())));
                        RW.this.playSound("yeah");
                    } else {
                        RW.this.rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
                        RW.this.rwName.setText("Olmad\u0131 ki, " + RW.this.Name + "!");
                        RW rW = RW.this;
                        RW.access$8(rW, rW.Points - 1);
                        RW.this.rwPoints.setText("S\u0259nin xal\u0131n: " + RW.this.Points);
                        RW.this.record();
                        RW.this.playSound("sad");
                    }
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.rwAnswer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (RW.this.rwAnswer.getText().equals(new String(RW.this.rwTest.getText().getBytes("UTF-8")))) {
                        RW.this.rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
                        RW.this.rwName.setText("Af\u0259rin, " + RW.this.Name + "!");
                        RW rW = RW.this;
                        RW.access$8(rW, rW.Points + 1);
                        RW.this.rwPoints.setText("S\u0259nin xal\u0131n: " + RW.this.Points);
                        RW.this.record();
                        RW.this.rwAnswer.setText("");
                        RW.this.rwTest.setText((String)RW.this.Test.get(RW.this.r.nextInt(RW.this.Test.size())));
                        RW.this.playSound("yeah");
                    } else {
                        RW.this.rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
                        RW.this.rwName.setText("Olmad\u0131 ki, " + RW.this.Name + "!");
                        RW rW = RW.this;
                        RW.access$8(rW, rW.Points - 1);
                        RW.this.rwPoints.setText("S\u0259nin xal\u0131n: " + RW.this.Points);
                        RW.this.record();
                        RW.this.playSound("sad");
                    }
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    static /* synthetic */ void access$8(RW rW, int n) {
        rW.Points = n;
    }

}

