
package codes;

import codes.History;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Animal
extends JPanel {
    private JLabel meymun;
    private JLabel animTest;
    private JLabel animName;
    private JLabel animPoints;
    private JLabel animName1;
    private JLabel animPoints1;
    private JButton animB1;
    private JButton animB2;
    private String bear = "/resources/img/animals/bear.png";
    private String camel = "/resources/img/animals/camel.png";
    private String cat = "/resources/img/animals/cat.png";
    private String cock = "/resources/img/animals/cock.png";
    private String cow = "/resources/img/animals/cow.png";
    private String dog = "/resources/img/animals/dog.png";
    private String donkey = "/resources/img/animals/donkey.png";
    private String eagle = "/resources/img/animals/eagle.png";
    private String elephant = "/resources/img/animals/elephant.png";
    private String fox = "/resources/img/animals/fox.png";
    private String hen = "/resources/img/animals/hen.png";
    private String horse = "/resources/img/animals/horse.png";
    private String lion = "/resources/img/animals/lion.png";
    private String mouse = "/resources/img/animals/mouse.png";
    private String pig = "/resources/img/animals/pig.png";
    private String rabbit = "/resources/img/animals/rabbit.png";
    private String sparrow = "/resources/img/animals/sparrow.png";
    private String squirrel = "/resources/img/animals/squirrel.png";
    private String swallow = "/resources/img/animals/swallow.png";
    private String tiger = "/resources/img/animals/tiger.png";
    private String wolf = "/resources/img/animals/wolf.png";
    private String[] animals = new String[]{this.bear, this.camel, this.cat, this.cock, this.cow, this.dog, this.donkey, this.eagle, this.elephant, this.fox, this.hen, this.horse, this.lion, this.mouse, this.pig, this.rabbit, this.sparrow, this.squirrel, this.swallow, this.tiger, this.wolf};
    private String[] animQ = new String[]{"Ay\u0131 hans\u0131d\u0131r?", "D\u0259v\u0259 hans\u0131d\u0131r?", "Pi\u015fik hans\u0131d\u0131r?", "Xoruz hans\u0131d\u0131r?", "\u0130n\u0259k hans\u0131d\u0131r?", "\u0130t hans\u0131d\u0131r?", "E\u015f\u015f\u0259k hans\u0131d\u0131r?", "Qartal hans\u0131d\u0131r?", "Fil hans\u0131d\u0131r?", "T\u00fclk\u00fc hans\u0131d\u0131r?", "Toyuq hans\u0131d\u0131r?", "At hans\u0131d\u0131r?", "\u015eir hans\u0131d\u0131r?", "Si\u00e7an hans\u0131d\u0131r?", "Donuz hans\u0131d\u0131r?", "Dov\u015fan hans\u0131d\u0131r?", "S\u0259r\u00e7\u0259 hans\u0131d\u0131r?", "D\u0259l\u0259 hans\u0131d\u0131r?", "Qaranqu\u015f hans\u0131d\u0131r?", "P\u0259l\u0259ng hans\u0131d\u0131r?", "Canavar hans\u0131d\u0131r?"};
    private int correctA;
    private int Points;
    private String Name;

    private void init(String name) {
        this.setBounds(100, 100, 450, 350);
        this.setLayout(null);
        this.Points = 0;
        if (History.MyModel.getValueAt(History.MyModel.getRowCount() - 1, 0) != null) {
            History.MyModel.insertRow(History.MyModel.getRowCount(), new Object[0]);
        }
        this.Name = name;
        this.meymun = new JLabel("");
        this.meymun.setIcon(new ImageIcon(Animal.class.getResource("/resources/img/rsz_monkey-icon.png")));
        this.meymun.setBounds(140, 11, 150, 140);
        this.add(this.meymun);
        this.animTest = new JLabel("");
        this.animTest.setForeground(Color.BLACK);
        this.animTest.setFont(new Font("Tahoma", 0, 17));
        this.animTest.setHorizontalAlignment(0);
        this.animTest.setBounds(104, 152, 237, 32);
        this.add(this.animTest);
        this.animName = new JLabel("Salam,");
        this.animName.setHorizontalAlignment(0);
        this.animName.setFont(new Font("Tahoma", 0, 16));
        this.animName.setBounds(10, 59, 120, 25);
        this.add(this.animName);
        this.animPoints = new JLabel("S\u0259nin xal\u0131n:");
        this.animPoints.setHorizontalAlignment(0);
        this.animPoints.setFont(new Font("Tahoma", 0, 16));
        this.animPoints.setBounds(313, 59, 127, 25);
        this.add(this.animPoints);
        this.animB1 = new JButton("");
        this.animB1.setBounds(8, 195, 205, 144);
        this.add(this.animB1);
        this.animB2 = new JButton("");
        this.animB2.setBounds(220, 195, 205, 144);
        this.add(this.animB2);
        this.animName1 = new JLabel(String.valueOf(this.Name) + "!");
        this.animName1.setHorizontalAlignment(0);
        this.animName1.setFont(new Font("Tahoma", 0, 16));
        this.animName1.setBounds(10, 95, 120, 32);
        this.add(this.animName1);
        this.animPoints1 = new JLabel(Integer.toString(this.Points));
        this.animPoints1.setFont(new Font("Tahoma", 0, 16));
        this.animPoints1.setHorizontalAlignment(0);
        this.animPoints1.setBounds(313, 84, 112, 43);
        this.add(this.animPoints1);
    }

    private void generateQ() {
        Random r = new Random();
        int index = r.nextInt(this.animals.length);
        this.animTest.setText(this.animQ[index]);
        switch (r.nextInt(2)) {
            case 0: {
                this.correctA = 0;
                this.animB1.setIcon(new ImageIcon(Animal.class.getResource(this.animals[index])));
                String secA = this.animals[r.nextInt(this.animals.length)];
                while (secA.equals(this.animals[index])) {
                    secA = this.animals[r.nextInt(this.animals.length)];
                }
                this.animB2.setIcon(new ImageIcon(Animal.class.getResource(secA)));
                break;
            }
            case 1: {
                this.correctA = 1;
                this.animB2.setIcon(new ImageIcon(Animal.class.getResource(this.animals[index])));
                String secA = this.animals[r.nextInt(this.animals.length)];
                while (secA.equals(this.animals[index])) {
                    secA = this.animals[r.nextInt(this.animals.length)];
                }
                this.animB1.setIcon(new ImageIcon(Animal.class.getResource(secA)));
            }
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
        History.MyModel.setValueAt("Heyvanlar\u0131 tan\u0131", History.MyModel.getRowCount() - 1, 1);
        History.MyModel.setValueAt(this.Points, History.MyModel.getRowCount() - 1, 2);
    }

    public Animal(String name) {
        this.init(name);
        this.generateQ();
        this.animB1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (Animal.this.correctA == 0) {
                    Animal.this.meymun.setIcon(new ImageIcon(Animal.class.getResource("/resources/img/rsz_monkey-happy.png")));
                    Animal animal = Animal.this;
                    Animal.access$3(animal, animal.Points + 1);
                    Animal.this.animPoints1.setText(Integer.toString(Animal.this.Points));
                    Animal.this.record();
                    Animal.this.animName.setText("Af\u0259rin,");
                    Animal.this.playSound("yeah");
                    Animal.this.generateQ();
                } else {
                    Animal.this.meymun.setIcon(new ImageIcon(Animal.class.getResource("/resources/img/rsz_monkey-sad.png")));
                    Animal animal = Animal.this;
                    Animal.access$3(animal, animal.Points - 1);
                    Animal.this.animPoints1.setText(Integer.toString(Animal.this.Points));
                    Animal.this.record();
                    Animal.this.animName.setText("Olmad\u0131 ki,");
                    Animal.this.playSound("sad");
                    Animal.this.generateQ();
                }
            }
        });
        this.animB2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (Animal.this.correctA == 1) {
                    Animal.this.meymun.setIcon(new ImageIcon(Animal.class.getResource("/resources/img/rsz_monkey-happy.png")));
                    Animal animal = Animal.this;
                    Animal.access$3(animal, animal.Points + 1);
                    Animal.this.animPoints1.setText(Integer.toString(Animal.this.Points));
                    Animal.this.record();
                    Animal.this.animName.setText("Af\u0259rin,");
                    Animal.this.playSound("yeah");
                    Animal.this.generateQ();
                } else {
                    Animal.this.meymun.setIcon(new ImageIcon(Animal.class.getResource("/resources/img/rsz_monkey-sad.png")));
                    Animal animal = Animal.this;
                    Animal.access$3(animal, animal.Points - 1);
                    Animal.this.animPoints1.setText(Integer.toString(Animal.this.Points));
                    Animal.this.record();
                    Animal.this.animName.setText("Olmad\u0131 ki,");
                    Animal.this.playSound("sad");
                    Animal.this.generateQ();
                }
            }
        });
    }

    static /* synthetic */ void access$3(Animal animal, int n) {
        animal.Points = n;
    }

}

