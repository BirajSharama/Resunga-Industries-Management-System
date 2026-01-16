package Controller;

import Model.Inventory;
import Model.InventoryFileDAO;

import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EmployeeController {

    private static List<Inventory> inventoryList;

    // Load inventory for employee view
    public static void loadInventory(JTable table) {
        inventoryList = InventoryFileDAO.loadInventory();
        refreshTable(table);
    }

    // Sell inventory (reduce quantity by 1)
    public static void sell(JTable table) {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select an item to sell");
            return;
        }

        Inventory item = inventoryList.get(row);

        if (item.getQuantity() <= 0) {
            JOptionPane.showMessageDialog(null, "Out of Stock");
            return;
        }

        item.setQuantity(item.getQuantity() - 1);

        InventoryFileDAO.saveInventory(inventoryList);
        refreshTable(table);
    }

    // Sort inventory by quantity (ascending)
    public static void sortByQuantity(JTable table) {
        inventoryList.sort((a, b) -> Integer.compare(a.getQuantity(), b.getQuantity()));
        refreshTable(table);
    }

    // Refresh JTable
    private static void refreshTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Inventory i : inventoryList) {
            model.addRow(new Object[]{
                i.getId(),
                i.getName(),
                i.getQuantity(),
                i.getSupplier()
            });
        }
    }
}
