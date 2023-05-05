package client;

import core.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPage extends JPanel {
    Mainframe mainframe;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JLabel label;
    private ServerConnector sc;
    JButton add;
    JButton back;

    public AddPage(Mainframe mainframe, ServerConnector sc) {
        this.mainframe = mainframe;
        this.sc = sc;
        setSize(500, 700);
        setLayout(null);

        label = new JLabel("Name:");
        label.setSize(100,100);
        label.setLocation(50,75);
        add(label);

        textField1 = new JTextField();
        textField1.setSize(350,50);
        textField1.setLocation(100,100);
        add(textField1);

        label = new JLabel("Price:");
        label.setSize(100,100);
        label.setLocation(50,175);
        add(label);

        textField2 = new JTextField();
        textField2.setSize(350,50);
        textField2.setLocation(100,200);
        add(textField2);

        label = new JLabel("Description:");
        label.setSize(100,100);
        label.setLocation(50,275);
        add(label);

        textField3 = new JTextField();
        textField3.setSize(350,50);
        textField3.setLocation(100,300);
        add(textField3);

        add = new JButton("Add");
        add.setSize(150,50);
        add.setLocation(50,400);
        add.addActionListener(e -> {
            if(textField1.getText() != "" && textField2.getText() != ""  && textField3.getText() != ""){
                String name = textField1.getText();
                int price = Integer.parseInt(textField2.getText());
                String description = textField3.getText();
                Item item = new Item(null,name, description, price);
                sc.addItem(item);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });add(add);

        back = new JButton("Back");
        back.setSize(150,50);
        back.setLocation(250,400);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.getAddPage().setVisible(false);
                mainframe.getAdminFirstPage().setVisible(true);
            }
        });add(back);

    }

}

