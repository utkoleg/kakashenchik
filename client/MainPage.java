package client;

import javax.swing.*;

public class MainPage extends JPanel {
    private Mainframe mainframe;
    private JButton client;
    private JButton admin;
    private ServerConnector sc;

    public MainPage(Mainframe mainframe, ServerConnector sc) {
        this.mainframe = mainframe;
        this.sc = sc;

        setSize(500, 700);
        setLayout(null);

        client = new JButton("Client");
        client.setSize(350, 150);
        client.setLocation(75, 150);
        client.addActionListener(e -> {
            mainframe.getClientFirstPage().setVisible(true);
            mainframe.getMainPage().setVisible(false);
        });
        add(client);

        admin = new JButton("Admin");
        admin.setSize(350, 150);
        admin.setLocation(75, 350);
        admin.addActionListener(e -> {
            mainframe.getMainPage().setVisible(false);
            mainframe.getAdminFirstPage().setVisible(true);
        });
        add(admin);
    }
}
