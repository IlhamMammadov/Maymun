/*
 * Decompiled with CFR 0_115.
 */
package codes;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

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
    private Container prevContainer;

    static {
        defaddUp = 100;
        defmin1Up = 100;
        defmin2Up = 100;
        defmulUp = 10;
        defdiv1Up = 10;
        defdiv2Up = 10;
    }

    private void init() {
        this.setBounds(100, 100, 450, 350);
        this.setLayout(null);
        JSeparator separator = new JSeparator();
        separator.setBounds(21, 58, 400, 2);
        this.add(separator);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(21, 149, 400, 2);
        this.add(separator_1);
        JLabel lblRiyaziyyat = new JLabel("Riyaziyyat:");
        lblRiyaziyyat.setFont(new Font("Tahoma", 0, 14));
        lblRiyaziyyat.setBounds(21, 35, 92, 25);
        this.add(lblRiyaziyyat);
        JLabel lblToplamaMax = new JLabel("Toplanan max:");
        lblToplamaMax.setBounds(31, 71, 92, 14);
        this.add(lblToplamaMax);
        JLabel lblxmaMax = new JLabel("\u00c7\u0131xar\u0131lan max:");
        lblxmaMax.setBounds(31, 96, 92, 14);
        this.add(lblxmaMax);
        this.addText = new JTextField();
        this.addText.setBounds(123, 68, 86, 20);
        this.add(this.addText);
        this.addText.setColumns(10);
        this.min1Text = new JTextField();
        this.min1Text.setColumns(10);
        this.min1Text.setBounds(123, 93, 86, 20);
        this.add(this.min1Text);
        this.min2Text = new JTextField();
        this.min2Text.setColumns(10);
        this.min2Text.setBounds(123, 118, 86, 20);
        this.add(this.min2Text);
        JLabel lblVurmaMax = new JLabel("Vuran max:");
        lblVurmaMax.setBounds(233, 71, 89, 14);
        this.add(lblVurmaMax);
        this.mulText = new JTextField();
        this.mulText.setColumns(10);
        this.mulText.setBounds(322, 65, 86, 20);
        this.add(this.mulText);
        JLabel lblBlnMax = new JLabel("Qism\u0259t max:");
        lblBlnMax.setBounds(233, 99, 89, 14);
        this.add(lblBlnMax);
        this.div1Text = new JTextField();
        this.div1Text.setColumns(10);
        this.div1Text.setBounds(322, 93, 86, 20);
        this.add(this.div1Text);
        this.div2Text = new JTextField();
        this.div2Text.setColumns(10);
        this.div2Text.setBounds(322, 118, 86, 20);
        this.add(this.div2Text);
        JLabel lblxanMax = new JLabel("\u00c7\u0131xan max:");
        lblxanMax.setBounds(31, 121, 92, 14);
        this.add(lblxanMax);
        JLabel lblBlnMax_1 = new JLabel("B\u00f6l\u0259n max:");
        lblBlnMax_1.setBounds(233, 124, 89, 14);
        this.add(lblBlnMax_1);
        this.ayarOk = new JButton("Ok");
        this.ayarOk.setBounds(332, 301, 89, 23);
        this.add(this.ayarOk);
        this.ayarOrig = new JButton("Original");
        this.ayarOrig.setBounds(233, 301, 89, 23);
        this.add(this.ayarOrig);
        this.addText.setText(Integer.toString(defaddUp));
        this.min1Text.setText(Integer.toString(defmin1Up));
        this.min2Text.setText(Integer.toString(defmin2Up));
        this.mulText.setText(Integer.toString(defmulUp));
        this.div1Text.setText(Integer.toString(defdiv1Up));
        this.div2Text.setText(Integer.toString(defdiv2Up));
        addUp = defaddUp;
        min1Up = defmin1Up;
        min2Up = defmin2Up;
        mulUp = defmulUp;
        div1Up = defdiv1Up;
        div2Up = defdiv2Up;
    }

    public Ayarlar(final CardLayout cards) {
        this.init();
        this.ayarOrig.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Ayarlar.this.addText.setText(Integer.toString(defaddUp));
                Ayarlar.this.min1Text.setText(Integer.toString(defmin1Up));
                Ayarlar.this.min2Text.setText(Integer.toString(defmin2Up));
                Ayarlar.this.mulText.setText(Integer.toString(defmulUp));
                Ayarlar.this.div1Text.setText(Integer.toString(defdiv1Up));
                Ayarlar.this.div2Text.setText(Integer.toString(defdiv2Up));
                Ayarlar.addUp = defaddUp;
                Ayarlar.min1Up = defmin1Up;
                Ayarlar.min2Up = defmin2Up;
                Ayarlar.mulUp = defmulUp;
                Ayarlar.div1Up = defdiv1Up;
                Ayarlar.div2Up = defdiv2Up;
            }
        });
        this.ayarOk.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Ayarlar.addUp = Integer.parseInt(Ayarlar.this.addText.getText());
                    Ayarlar.min1Up = Integer.parseInt(Ayarlar.this.min1Text.getText());
                    Ayarlar.min2Up = Integer.parseInt(Ayarlar.this.min2Text.getText());
                    Ayarlar.mulUp = Integer.parseInt(Ayarlar.this.mulText.getText());
                    Ayarlar.div1Up = Integer.parseInt(Ayarlar.this.div1Text.getText());
                    Ayarlar.div2Up = Integer.parseInt(Ayarlar.this.div2Text.getText());
                }
                catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Riyaziyyat b\u00f6lm\u0259sind\u0259 ancaq \u0259d\u0259dl\u0259r yaz\u0131la bil\u0259r!");
                }
                cards.show(Ayarlar.this.getParent(), "Home");
            }
        });
    }

}

