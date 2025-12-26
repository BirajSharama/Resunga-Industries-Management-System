package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.MainFrame;

public class ViewItemPanel extends JPanel {

    DefaultTableModel model;

    public ViewItemPanel(MainFrame frame) {
        setLayout(null);

        model = new DefaultTableModel(
            new String[]{"Name", "Type", "Quantity"}, 0
        );

        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150, 80, 500, 250);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(300, 350, 120, 30);

        JButton back = new JButton("Back");
        back.setBounds(430, 350, 120, 30);

        refresh.addActionListener(e -> {
            model.setRowCount(0);
            frame.controller.getItems().forEach(item ->
                model.addRow(new Object[]{
                    item.getName(), 
                    item.getType(), 
                    item.getQuantity()
                })
            );
        });

        back.addActionListener(e -> {
            if (frame.controller.getItems().isEmpty()) {
                // If no items, check which panel to go back to
                // This is a simple logic - you might want to track user type
                frame.showPage("ADMIN");
            } else {
                frame.showPage("ADMIN");
            }
        });

        add(sp);
        add(refresh);
        add(back);
    }
}