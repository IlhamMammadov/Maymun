package codes;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class History
extends JPanel {
    private JTable table;
    private JScrollPane scrollPane;
    private JButton histOk;
    private JButton histClear;
    public static DefaultTableModel MyModel = new DefaultTableModel(new Object[0][], new String[]{"Ad", "Oyun", "Xal"}){
        private static final long serialVersionUID = 1;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void init() {
        this.setBounds(100, 100, 450, 350);
        this.setLayout(null);
        this.histOk = new JButton("Ok");
        this.histOk.setBounds(323, 301, 89, 23);
        this.add(this.histOk);
        this.histClear = new JButton("T\u0259mizl\u0259");
        this.histClear.setBounds(224, 301, 89, 23);
        this.add(this.histClear);
        this.table = new JTable();
        this.table.setFillsViewportHeight(true);
        this.table.setCellSelectionEnabled(true);
        this.table.setColumnSelectionAllowed(true);
        this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        this.table.setModel(MyModel);
        MyModel.addRow(new Object[]{"Maymun", "Ham\u0131s\u0131", "100"});
        this.scrollPane = new JScrollPane(this.table);
        this.scrollPane.setBounds(34, 42, 378, 224);
        this.add((Component)this.scrollPane, "Center");
    }

    public History(final CardLayout cards) {
        this.init();
        this.histClear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                while (History.MyModel.getRowCount() != 0) {
                    History.MyModel.removeRow(0);
                }
            }
        });
        this.histOk.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                cards.show(History.this.getParent(), "Home");
            }
        });
    }

}

