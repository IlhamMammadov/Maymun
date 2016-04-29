/*
 * Decompiled with CFR 0_115.
 */
package codes;

import codes.Animal;
import codes.Ayarlar;
import codes.History;
import codes.Math;
import codes.RW;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Maymun
extends JFrame {
    private JPanel home;
    private JPanel main;
    private JTextField nameField;
    private Ayarlar ayar;
    private History hist;
    private Math math;
    private Animal anim;
    private RW rw;
    private CardLayout cardlayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    Maymun frame = new Maymun();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Maymun() {
        this.setTitle("Maymun");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Maymun.class.getResource("/resources/img/Monkey 256.png")));
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 450, 400);
        this.main = new JPanel();
        this.main.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setContentPane(this.main);
        this.main.setLayout(new CardLayout(0, 0));
        this.home = new JPanel();
        this.home.setLayout(null);
        this.main.add((Component)this.home, "Home");
        this.cardlayout = (CardLayout)this.main.getLayout();
        this.cardlayout.show(this.main, "Home");
        this.ayar = new Ayarlar(this.cardlayout);
        this.main.add((Component)this.ayar, "Ayarlar");
        this.hist = new History(this.cardlayout);
        this.main.add((Component)this.hist, "History");
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu mnNewMenu = new JMenu("Menyu");
        menuBar.add(mnNewMenu);
        JMenuItem mntmExit = new JMenuItem("\u00c7\u0131x");
        mntmExit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        JMenuItem mntmStart = new JMenuItem("Ba\u015fla");
        mntmStart.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Maymun.this.cardlayout.show(Maymun.this.main, "Home");
                Maymun.this.nameField.setText("");
            }
        });
        mnNewMenu.add(mntmStart);
        mnNewMenu.add(mntmExit);
        JMenu mnAyarla = new JMenu("Ayarla");
        menuBar.add(mnAyarla);
        JMenuItem mntmAyarlar = new JMenuItem("Ayarlar");
        mntmAyarlar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Maymun.this.cardlayout.show(Maymun.this.main, "Ayarlar");
            }
        });
        mnAyarla.add(mntmAyarlar);
        JMenu mnTarix = new JMenu("Tarix\u00e7\u0259");
        menuBar.add(mnTarix);
        JMenuItem mntmRekordlar = new JMenuItem("Rekordlar");
        mntmRekordlar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Maymun.this.cardlayout.show(Maymun.this.main, "History");
            }
        });
        mnTarix.add(mntmRekordlar);
        JLabel lblName = new JLabel("Ad\u0131n n\u0259dir?:");
        lblName.setFont(new Font("Tahoma", 0, 16));
        lblName.setBounds(123, 169, 88, 20);
        this.home.add(lblName);
        this.nameField = new JTextField();
        this.nameField.setBounds(216, 169, 86, 20);
        this.home.add(this.nameField);
        this.nameField.setColumns(10);
        JButton mathB = new JButton("");
        mathB.setToolTipText("Hesabla");
        mathB.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Maymun.this.nameField.getText().equals("")) {
                    Maymun.access$3(Maymun.this, new Math("Maymun"));
                } else {
                    Maymun.access$3(Maymun.this, new Math(Maymun.this.nameField.getText()));
                }
                Maymun.this.main.add((Component)Maymun.this.math, "Math");
                Maymun.this.cardlayout.show(Maymun.this.main, "Math");
            }
        });
        mathB.setIcon(new ImageIcon(Maymun.class.getResource("/resources/img/calculator.png")));
        mathB.setBounds(168, 220, 97, 73);
        this.home.add(mathB);
        JButton rwB = new JButton("");
        rwB.setToolTipText("Oxu v\u0259 Yaz");
        rwB.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Maymun.this.nameField.getText().equals("")) {
                    Maymun.access$5(Maymun.this, new RW("Maymun"));
                } else {
                    Maymun.access$5(Maymun.this, new RW(Maymun.this.nameField.getText()));
                }
                Maymun.this.main.add((Component)Maymun.this.rw, "RW");
                Maymun.this.cardlayout.show(Maymun.this.main, "RW");
            }
        });
        rwB.setIcon(new ImageIcon(Maymun.class.getResource("/resources/img/compose.png")));
        rwB.setBounds(37, 220, 97, 73);
        this.home.add(rwB);
        JButton animal = new JButton("");
        animal.setToolTipText("Heyvanlar\u0131 tan\u0131");
        animal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (Maymun.this.nameField.getText().equals("")) {
                    Maymun.access$7(Maymun.this, new Animal("Maymun"));
                } else {
                    Maymun.access$7(Maymun.this, new Animal(Maymun.this.nameField.getText()));
                }
                Maymun.this.main.add((Component)Maymun.this.anim, "Animal");
                Maymun.this.cardlayout.show(Maymun.this.main, "Animal");
            }
        });
        animal.setIcon(new ImageIcon(Maymun.class.getResource("/resources/img/cat.png")));
        animal.setBounds(296, 220, 97, 73);
        this.home.add(animal);
        JLabel lblNewLabel = new JLabel("Maymun");
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Tahoma", 0, 18));
        lblNewLabel.setBounds(177, 11, 67, 22);
        this.home.add(lblNewLabel);
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Maymun.class.getResource("/resources/img/Monkey 128.png")));
        label.setBounds(150, 25, 128, 128);
        this.home.add(label);
    }

    static /* synthetic */ void access$3(Maymun maymun, Math math) {
        maymun.math = math;
    }

    static /* synthetic */ void access$5(Maymun maymun, RW rW) {
        maymun.rw = rW;
    }

    static /* synthetic */ void access$7(Maymun maymun, Animal animal) {
        maymun.anim = animal;
    }

}

