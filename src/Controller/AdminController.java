package Controller;

import Model.Inventory;
import Model.InventoryFileDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AdminController {

    private static List<Inventory> inventory;

    public static void load(JTable table) {
        inventory = InventoryFileDAO.loadInventory();
        refresh(table);
    }

    public static void add(String name, int qty, String supplier, JTable table) {
        inventory.add(new Inventory(
                inventory.size() + 1,
                name, qty, supplier
        ));
        InventoryFileDAO.saveInventory(inventory);
        refresh(table);
    }

    public static void delete(int row, JTable table) {
        if (row >= 0) {
            inventory.remove(row);
            InventoryFileDAO.saveInventory(inventory);
            refresh(table);
        }
    }

    private static void refresh(JTable table) {
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        m.setRowCount(0);
        for (Inventory i : inventory) {
            m.addRow(new Object[]{
                i.getId(), i.getName(),
                i.getQuantity(), i.getSupplier()
            });
        }
    }
}
