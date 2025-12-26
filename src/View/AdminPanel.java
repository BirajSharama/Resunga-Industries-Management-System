package view;

import javax.swing.*;
import main.MainFrame;

public class AdminPanel extends JPanel {

    public AdminPanel(MainFrame frame) {
        setLayout(null);

        JLabel label = new JLabel("Admin Dashboard");
        label.setBounds(320, 40, 200, 30);

        JButton add = new JButton("Add Item");
        add.setBounds(300, 120, 200, 35);

        JButton view = new JButton("View Items");
        view.setBounds(300, 170, 200, 35);

        JButton back = new JButton("Logout");
        back.setBounds(300, 220, 200, 35);

        add.addActionListener(e -> frame.showPage("ADD"));
        view.addActionListener(e -> frame.showPage("VIEW"));
        back.addActionListener(e -> frame.showPage("LOGIN"));

        add(label);
        add(add);
        add(view);
        add(back);
    }
}