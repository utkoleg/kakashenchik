package client;

import core.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminFirstPage extends JPanel {
    private Mainframe mainframe;
    private JButton add;
    private JButton delete;
    private JButton back;
    private JButton menu;
    private final ServerConnector sc;

    public AdminFirstPage(Mainframe mainframe, ServerConnector sc){
        this.sc = sc;
        this.mainframe = mainframe;
        setSize(500, 700);
        setLayout(null);

        add = new JButton("Add");
        add.setSize(300,150);
        add.setLocation(100,75);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.getAddPage().setVisible(true);
                mainframe.getAdminFirstPage().setVisible(false);
            }
        });add(add);

        delete = new JButton("Delete");
        delete.setSize(300,150);
        delete.setLocation(100,275);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Item> items = sc.listItems();
                mainframe.getDeletePage().setVisible(true);
                mainframe.getAdminFirstPage().setVisible(false);
                mainframe.getDeletePage().generateTable(items);
            }
        });add(delete);

        back = new JButton("Back");
        back.setSize(300,150);
        back.setLocation(100,475);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.getMainPage().setVisible(true);
                mainframe.getAdminFirstPage().setVisible(false);
            }
        });add(back);
    }
}
