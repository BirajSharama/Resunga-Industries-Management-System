package main;

import java.awt.CardLayout;
import javax.swing.*;
import controller.InventoryController;
import view.*;

public class MainFrame extends JFrame {

    public CardLayout layout = new CardLayout();
    public JPanel container = new JPanel(layout);
    public InventoryController controller = new InventoryController();

    public MainFrame() {

        container.add(new LoginPanel(this), "LOGIN");
        container.add(new AdminPanel(this), "ADMIN");
        container.add(new UserPanel(this), "USER");
        container.add(new AddItemPanel(this), "ADD");
        container.add(new ViewItemPanel(this), "VIEW");

        add(container);

        setTitle("Inventory Management System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        layout.show(container, "LOGIN");
    }

    public void showPage(String name) {
        layout.show(container, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}