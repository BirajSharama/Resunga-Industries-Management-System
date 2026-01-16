package Controller;

import Model.User;
import Model.UserFileDAO;
import View.Employee;
import View.Login;
import View.MainFrame;
import javax.swing.JOptionPane;

public class LoginController {

    private Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void login() {
        String email = view.getEmail();
        String password = view.getPassword();

        // ADMIN
        if (email.equals("admin@gmail.com") && password.equals("admin123")) {
            view.dispose();
            new MainFrame().setVisible(true);
            return;
        }

        // EMPLOYEE
        for (User u : UserFileDAO.loadUsers()) {
            if (u.getEmail().equals(email) &&
                u.getPassword().equals(password)) {
                view.dispose();
                new Employee().setVisible(true);
                return;
            }
        }

        JOptionPane.showMessageDialog(view, "Invalid Login");
    }
}
