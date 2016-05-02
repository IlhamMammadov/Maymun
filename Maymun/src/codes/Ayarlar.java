package codes;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Ayarlar
extends JPanel {
    public static int addUp;
    public static int min1Up;
    public static int min2Up;
    public static int mulUp;
    public static int div1Up;
    public static int div2Up;
    private static int defaddUp;
    private static int defmin1Up;
    private static int defmin2Up;
    private static int defmulUp;
    private static int defdiv1Up;
    private static int defdiv2Up;
    private JTextField addText;
    private JTextField min1Text;
    private JTextField min2Text;
    private JTextField mulText;
    private JTextField div1Text;
    private JTextField div2Text;
    private JButton ayarOrig;
    private JButton ayarOk;
    private JList<String> list; 
    private JScrollPane scrollPane;
    private JTextField ayarAddToText;
    private JButton ayarAddButton;
    private JButton ayarSelDel;
    private DefaultListModel<String> model;
    private ArrayList<String> Test;

    static {
        defaddUp = 10;
        defmin1Up = 10;
        defmin2Up = 10;
        defmulUp = 5;
        defdiv1Up = 5;
        defdiv2Up = 5;
    }

    private void init() {
        setBounds(100, 100, 450, 350);
        setLayout(null);
        JSeparator separator = new JSeparator();
        separator.setBounds(22, 34, 400, 2);
        add(separator);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(22, 125, 400, 2);
        add(separator_1);
        JLabel lblRiyaziyyat = new JLabel("Riyaziyyat:");
        lblRiyaziyyat.setFont(new Font("Tahoma", 0, 14));
        lblRiyaziyyat.setBounds(22, 11, 92, 25);
        add(lblRiyaziyyat);
        JLabel lblToplamaMax = new JLabel("Toplanan max:");
        lblToplamaMax.setBounds(32, 47, 92, 14);
        add(lblToplamaMax);
        JLabel lblxmaMax = new JLabel("\u00c7\u0131xar\u0131lan max:");
        lblxmaMax.setBounds(32, 72, 92, 14);
        add(lblxmaMax);
        
        addText = new JTextField();
        addText.setBounds(124, 44, 86, 20);
        add(addText);
        addText.setColumns(10);
        
        min1Text = new JTextField();
        min1Text.setColumns(10);
        min1Text.setBounds(124, 69, 86, 20);
        add(min1Text);
        
        min2Text = new JTextField();
        min2Text.setColumns(10);
        min2Text.setBounds(124, 94, 86, 20);
        add(min2Text);
        
        JLabel lblVurmaMax = new JLabel("Vuran max:");
        lblVurmaMax.setBounds(234, 47, 89, 14);
        add(lblVurmaMax);
        
        mulText = new JTextField();
        mulText.setColumns(10);
        mulText.setBounds(323, 41, 86, 20);
        add(mulText);
        
        JLabel lblBlnMax = new JLabel("Qism\u0259t max:");
        lblBlnMax.setBounds(234, 75, 89, 14);
        add(lblBlnMax);
        
        div1Text = new JTextField();
        div1Text.setColumns(10);
        div1Text.setBounds(323, 69, 86, 20);
        add(div1Text);
        
        div2Text = new JTextField();
        div2Text.setColumns(10);
        div2Text.setBounds(323, 94, 86, 20);
        add(div2Text);
        
        JLabel lblxanMax = new JLabel("\u00c7\u0131xan max:");
        lblxanMax.setBounds(32, 97, 92, 14);
        add(lblxanMax);
        
        JLabel lblBlnMax_1 = new JLabel("B\u00f6l\u0259n max:");
        lblBlnMax_1.setBounds(234, 100, 89, 14);
        add(lblBlnMax_1);
        
        ayarOk = new JButton("Ok");
        ayarOk.setBounds(320, 310, 89, 23);
        add(ayarOk);
        
        ayarOrig = new JButton("Default");
        ayarOrig.setBounds(221, 310, 89, 23);
        add(ayarOrig);
        
        addText.setText(Integer.toString(defaddUp));
        min1Text.setText(Integer.toString(defmin1Up));
        min2Text.setText(Integer.toString(defmin2Up));
        mulText.setText(Integer.toString(defmulUp));
        div1Text.setText(Integer.toString(defdiv1Up));
        div2Text.setText(Integer.toString(defdiv2Up));
        
        JLabel lblOxuVYaz = new JLabel("Oxu v\u0259 Yaz:");
        lblOxuVYaz.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblOxuVYaz.setBounds(22, 126, 92, 25);
        add(lblOxuVYaz);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 152, 189, 139);
        add(scrollPane);
        
        model = new DefaultListModel<String>();
        list = new JList<String>();
        list.setModel(model);
        scrollPane.setViewportView(list);
        
        ayarSelDel = new JButton("<< Se\u00E7il\u0259nl\u0259ri sil");
        ayarSelDel.setHorizontalAlignment(SwingConstants.LEFT);
        ayarSelDel.setBounds(234, 150, 175, 23);
        add(ayarSelDel);
        
        ayarAddToText = new JTextField();
        ayarAddToText.setBounds(234, 186, 175, 32);
        add(ayarAddToText);
        ayarAddToText.setColumns(10);
        
        ayarAddButton = new JButton("Yuxar\u0131dak\u0131n\u0131 \u0259lav\u0259 et");
        ayarAddButton.setBounds(234, 229, 175, 23);
        add(ayarAddButton);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(22, 302, 400, 2);
        add(separator_2);
        

        displayFile();
        
        addUp = defaddUp;
        min1Up = defmin1Up;
        min2Up = defmin2Up;
        mulUp = defmulUp;
        div1Up = defdiv1Up;
        div2Up = defdiv2Up;
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
            txt.close();
            in.close();
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
            txt.close();
            in.close();
            file.close();
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
    
    private void writeFile(){
    	
    	try {
    		//current code location MyClass.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
    		FileOutputStream fos = new FileOutputStream(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/Oxu_və_Yaz.txt");
    		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
    		BufferedWriter bw = new BufferedWriter(osw);
    		Writer out = bw;

			for(int i=0; i< model.getSize();i++){
				out.write(model.getElementAt(i).toString()+ "\n");
			}

			out.close();
			bw.close();
			osw.close();
			fos.close();

    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    private void displayDefFile(){
    	readDefFile();
    	model.removeAllElements();
    	for(String s:Test){
    		model.addElement(s);
    	}

    }
    
    private void displayNewFile(){
    	readNewFile();
    	model.removeAllElements();
    	for(String s:Test){
    		model.addElement(s);
    	}
    }
    
    private void displayFile(){

    	try {
    		File f = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/Oxu_və_Yaz.txt");
			if(f.exists() && f.length()>0)
				displayNewFile();
			else
				displayDefFile();
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public Ayarlar(final CardLayout cards) {
        init();
        ayarOrig.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                addText.setText(Integer.toString(defaddUp));
                min1Text.setText(Integer.toString(defmin1Up));
                min2Text.setText(Integer.toString(defmin2Up));
                mulText.setText(Integer.toString(defmulUp));
                div1Text.setText(Integer.toString(defdiv1Up));
                div2Text.setText(Integer.toString(defdiv2Up));
                Ayarlar.addUp = defaddUp;
                Ayarlar.min1Up = defmin1Up;
                Ayarlar.min2Up = defmin2Up;
                Ayarlar.mulUp = defmulUp;
                Ayarlar.div1Up = defdiv1Up;
                Ayarlar.div2Up = defdiv2Up;
                displayDefFile();
                
                //remove separate file;
                try {
            		File f = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/Oxu_və_Yaz.txt");
        			f.delete();
        			
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
            }
        });
        
        ayarOk.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Ayarlar.addUp = Integer.parseInt(addText.getText());
                    Ayarlar.min1Up = Integer.parseInt(min1Text.getText());
                    Ayarlar.min2Up = Integer.parseInt(min2Text.getText());
                    Ayarlar.mulUp = Integer.parseInt(mulText.getText());
                    Ayarlar.div1Up = Integer.parseInt(div1Text.getText());
                    Ayarlar.div2Up = Integer.parseInt(div2Text.getText());
                }
                catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Riyaziyyat b\u00f6lm\u0259sind\u0259 ancaq \u0259d\u0259dl\u0259r yaz\u0131la bil\u0259r!");
                }
                cards.show(getParent(), "Home");
            }
        });
        
        ayarSelDel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if(list.getSelectedIndices().length > 0){	
        			int[] tmp = list.getSelectedIndices();
	        		int[] selected = list.getSelectedIndices();
	        		
	        		for(int i=tmp.length-1; i >=0;i--){
	        			selected = list.getSelectedIndices();
	        			model.removeElementAt(selected[i]);
	        		}
	        		writeFile();
        		}
        	}
        });
        
        
        ayarAddButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		model.addElement(ayarAddToText.getText());
        		writeFile();
        	}
        });
        
    }
}

