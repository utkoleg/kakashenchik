package client;

import core.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientFirstPage extends JPanel {
    private Mainframe mainframe;
    private JButton menu;
    private JButton basket;
    private JButton back;
    private final ServerConnector sc;

    public ClientFirstPage(Mainframe mainframe, ServerConnector sc){
        this.mainframe = mainframe;
        this.sc = sc;
        setSize(500, 700);
        setLayout(null);

        menu = new JButton("Menu");
        menu.setSize(350,150);
        menu.setLocation(75,150);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Item> items = sc.listItems();
                mainframe.getMenuPage().setVisible(true);
                mainframe.getClientFirstPage().setVisible(false);
                mainframe.getMenuPage().generateTable(items);
            }
        });add(menu);

        back = new JButton("Back");
        back.setSize(350,150);
        back.setLocation(75,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.getMainPage().setVisible(true);
                mainframe.getClientFirstPage().setVisible(false);
            }
        });add(back);

    }
}
