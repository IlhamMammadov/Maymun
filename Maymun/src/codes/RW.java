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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
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
    private int rwTestId;
    private JLabel rwTest;
    private JLabel rwPoints;
    private JButton rwStart;
    private JButton rwOK;
    static ArrayList<String> Test;
    private Random r = new Random();
    private JLabel rwName;
    private String Name;
    private int Points;


    public void init(String name) {
        setBounds(100, 100, 450, 350);
        setLayout(null);
        readfile();
        Points = 0;
        if (History.MyModel.getValueAt(History.MyModel.getRowCount() - 1, 0) != null) {
            History.MyModel.insertRow(History.MyModel.getRowCount(), new Object[0]);
        }
        Name = name;
        rwName = new JLabel("Salam, " + Name + "!");
        rwName.setFont(new Font("Tahoma", 0, 16));
        rwName.setHorizontalAlignment(0);
        rwName.setBounds(235, 60, 157, 28);
        add(rwName);
        rwAnswer = new JTextField();
        rwAnswer.setFont(rwName.getFont());
        rwAnswer.setBounds(58, 193, 150, 20);
        add(rwAnswer);
        rwAnswer.setColumns(10);
        rwReaction = new JLabel("");
        rwReaction.setHorizontalAlignment(0);
        rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-icon.png")));
        rwReaction.setBounds(242, 95, 150, 140);
        add(rwReaction);
        rwTest = new JLabel(Test.get(0));
        rwTest.setHorizontalAlignment(0);
        rwTest.setFont(rwName.getFont());
        rwTest.setBounds(31, 144, 201, 38);
        add(rwTest);
        rwPoints = new JLabel("S\u0259nin xal\u0131n: " + Points);
        rwPoints.setHorizontalAlignment(0);
        rwPoints.setFont(rwName.getFont());
        rwPoints.setBounds(218, 235, 201, 38);
        add(rwPoints);
        rwStart = new JButton("");
        rwStart.setToolTipText("Altdak\u0131 yaz\u0131n\u0131 t\u0259krar yaz");
        rwStart.setIcon(new ImageIcon(RW.class.getResource("/resources/img/compose.png")));
        rwStart.setBounds(58, 60, 150, 73);
        add(rwStart);
        rwOK = new JButton("OK");
        rwOK.setBounds(58, 245, 150, 23);
        add(rwOK);
    }

    public void readfile() {
    	try {
    		File f = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/Oxu_və_Yaz.txt");
			if(f.exists() && f.length()>0)
				readNewFile();
			else
				readDefFile();
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void readDefFile() {
        try {
            InputStream in = getClass().getResourceAsStream("/resources/txt/RWtest.txt");
            BufferedReader txt = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            Scanner s = new Scanner(txt);
            Test = new ArrayList<String>();
            while (s.hasNextLine()) {
            	Test.add(s.nextLine());
            }
            Test.set(0, Test.get(0).startsWith("\ufeff") ? Test.get(0).substring(1) : Test.get(0));
            s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void readNewFile() {
        try {
            FileInputStream file = new FileInputStream(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath().substring(1) + "/Oxu_və_Yaz.txt");
        	InputStreamReader in = new InputStreamReader(file,"UTF-8");
            BufferedReader txt = new BufferedReader(in);
            Scanner s = new Scanner(txt);
            Test = new ArrayList<String>();
            
            String line;
            while (s.hasNextLine()) {
            	line = s.nextLine();
            	Test.add(line);
            }
            Test.set(0, Test.get(0).startsWith("\ufeff") ? Test.get(0).substring(1) : Test.get(0));
            s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
				JOptionPane.showMessageDialog(null, getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/Oxu_və_Yaz.txt"
						+ " faylı yoxdur!");
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
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
        History.MyModel.setValueAt("Oxu v\u0259 Yaz", History.MyModel.getRowCount() - 1, 1);
        History.MyModel.setValueAt(Points, History.MyModel.getRowCount() - 1, 2);
    }

    private void generateQ(){
    	
    	rwTestId = r.nextInt(Test.size());
    	rwTest.setText(Test.get(rwTestId));
    }
    private boolean checkA(){
    	try {
			if(Test.get(rwTestId).equals(rwAnswer.getText()))
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    private void correctA(){
    	
    	rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-happy.png")));
        rwName.setText("Af\u0259rin, " + Name + "!");
        Points++;
        rwPoints.setText("S\u0259nin xal\u0131n: " + Points);
        record();
        rwAnswer.setText("");
        generateQ();
        playSound("yeah");
    }
    
    private void wrongA(){
    	
        rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-sad.png")));
        rwName.setText("Olmad\u0131 ki, " + Name + "!");
        Points--;
        rwPoints.setText("S\u0259nin xal\u0131n: " + Points);
        record();
        playSound("sad");
        
    }
    public RW(String name) {
        init(name);
        rwStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	generateQ();
                rwReaction.setIcon(new ImageIcon(RW.class.getResource("/resources/img/rsz_monkey-icon.png")));
                rwName.setText("Bir daha, " + Name + "!");
                rwAnswer.setText("");
            }
        });
        rwOK.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (checkA()) 
                    	correctA();
                    else 
                    	wrongA();
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        rwAnswer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (checkA())                        
                    	correctA();
                    else
                    	wrongA();
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }


}

