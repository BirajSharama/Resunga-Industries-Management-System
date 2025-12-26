package view;

import javax.swing.*;
import main.MainFrame;

public class AddItemPanel extends JPanel {

    public AddItemPanel(MainFrame frame) {
        setLayout(null);

        JLabel name = new JLabel("Item Name");
        name.setBounds(250, 100, 100, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(350, 100, 200, 25);

        JLabel type = new JLabel("Type");
        type.setBounds(250, 140, 100, 25);

        JTextField typeField = new JTextField();
        typeField.setBounds(350, 140, 200, 25);

        JLabel qty = new JLabel("Quantity");
        qty.setBounds(250, 180, 100, 25);

        JTextField qtyField = new JTextField();
        qtyField.setBounds(350, 180, 200, 25);

        JButton save = new JButton("Save");
        save.setBounds(350, 230, 95, 30);

        JButton back = new JButton("Back");
        back.setBounds(455, 230, 95, 30);

        save.addActionListener(e -> {
            try {
                String itemName = nameField.getText().trim();
                String itemType = typeField.getText().trim();
                String qtyText = qtyField.getText().trim();
                
                if (itemName.isEmpty() || itemType.isEmpty() || qtyText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required!");
                    return;
                }
                
                int quantity = Integer.parseInt(qtyText);
                if (quantity < 0) {
                    JOptionPane.showMessageDialog(this, "Quantity cannot be negative!");
                    return;
                }
                
                frame.controller.addItem(itemName, itemType, quantity);
                JOptionPane.showMessageDialog(this, "Item Added Successfully!");
                
                // Clear fields
                nameField.setText("");
                typeField.setText("");
                qtyField.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Quantity must be a valid number!");
            }
        });

        back.addActionListener(e -> {
            frame.showPage("ADMIN");
        });

        add(name);
        add(nameField);
        add(type);
        add(typeField);
        add(qty);
        add(qtyField);
        add(save);
        add(back);
    }
}