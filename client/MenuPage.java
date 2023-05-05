package client;

import core.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuPage extends JPanel {
    private Mainframe mainframe;
    private JLabel label;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton back;
    private final ServerConnector sc;
    private final Object[] headers = {"ID", "NAME", "DESCRIPTION", "PRICE"};

    public MenuPage(Mainframe mainframe, ServerConnector sc){
        this.mainframe = mainframe;
        this.sc = sc;
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
        scrollPane.setSize(300,350);
        scrollPane.setLocation(100,100);
        add(scrollPane);

        back = new JButton("Back");
        back.setSize(300,100);
        back.setLocation(100,500);
        back.addActionListener(e -> {
            mainframe.getMenuPage().setVisible(false);
            mainframe.getMainPage().setVisible(true);
        });add(back);

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
