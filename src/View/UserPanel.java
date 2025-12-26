package view;

import javax.swing.*;
import main.MainFrame;

public class UserPanel extends JPanel {

    public UserPanel(MainFrame frame) {
        setLayout(null);

        JLabel label = new JLabel("User Dashboard");
        label.setBounds(330, 60, 200, 30);

        JButton view = new JButton("View Inventory");
        view.setBounds(300, 150, 200, 35);

        JButton back = new JButton("Logout");
        back.setBounds(300, 200, 200, 35);

        view.addActionListener(e -> frame.showPage("VIEW"));
        back.addActionListener(e -> frame.showPage("LOGIN"));

        add(label);
        add(view);
        add(back);
    }
}