package view;

import javax.swing.*;
import main.MainFrame;

public class LoginPanel extends JPanel {

    public LoginPanel(MainFrame frame) {
        setLayout(null);

        JLabel title = new JLabel("Login");
        title.setBounds(360, 50, 100, 30);

        JLabel user = new JLabel("Username");
        user.setBounds(260, 120, 100, 25);

        JTextField userField = new JTextField();
        userField.setBounds(360, 120, 180, 25);

        JLabel pass = new JLabel("Password");
        pass.setBounds(260, 160, 100, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(360, 160, 180, 25);

        JButton login = new JButton("Login");
        login.setBounds(360, 210, 180, 30);

        login.addActionListener(e -> {
            if (userField.getText().equals("admin")) {
                frame.showPage("ADMIN");
            } else {
                frame.showPage("USER");
            }
        });

        add(title);
        add(user);
        add(userField);
        add(pass);
        add(passField);
        add(login);
    }
}