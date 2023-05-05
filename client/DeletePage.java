package client;

import core.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeletePage extends JPanel {
    private Mainframe mainframe;
    private JButton back;
    private JButton delete;
    private ServerConnector sc;
    private final Object[] headers = {"ID", "NAME", "DESCRIPTION", "PRICE"};
    private JLabel label;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextField textField;

    public DeletePage(Mainframe mainframe, ServerConnector sc){
        this.sc = sc;
        this.mainframe = mainframe;
        setSize(500, 700);
        setLayout(null);

        label = new JLabel("MENU");
        label.setSize(100,25);
        label.setLocation(240,25);
        add(label);

        table = new JTable();
        table.setFont(new Font("Verdana", Font.PLAIN,12));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,300);
        scrollPane.setLocation(100,100);
        add(scrollPane);

        back = new JButton("Back");
        back.setSize(200,100);
        back.setLocation(50,550);
        back.addActionListener(e -> {
            mainframe.getDeletePage().setVisible(false);
            mainframe.getMainPage().setVisible(true);
        });add(back);

        textField = new JTextField();
        textField.setSize(350,50);
        textField.setLocation(75,450);
        add(textField);

        delete = new JButton("Delete");
        delete.setSize(200,100);
        delete.setLocation(250,550);
        delete.addActionListener(e -> {
            Long id = Long.parseLong(textField.getText());
            sc.deleteItem(id);
            textField.setText("");
        });add(delete);
    }

    public void generateTable(ArrayList<Item> items) {
        Object[][] data = new Object[items.size()][4];
        for(int i = 0; i < items.size(); i++) {
            data[i][0] = items.get(i).getId();
            data[i][1] = items.get(i).getName();
            data[i][2] = items.get(i).getDescription();
            data[i][3] = items.get(i).getPrice();

        }
        DefaultTableModel model = new DefaultTableModel(data, headers);
        table.setModel(model);
    }
}
