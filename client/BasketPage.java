package client;

import javax.swing.*;

public class BasketPage extends JPanel {
    private Mainframe mainframe;
    private JLabel label;
    private JTable table;

    public BasketPage(Mainframe mainframe, ServerConnector sc){
        this.mainframe = mainframe;
        setSize(500, 500);
        setLayout(null);
    }
}
