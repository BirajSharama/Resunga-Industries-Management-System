package Model;

import java.io.*;
import java.util.*;

public class InventoryFileDAO {

    private static final String FILE = "inventory.txt";

    public static List<Inventory> loadInventory() {
        List<Inventory> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new Inventory(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        d[3]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void saveInventory(List<Inventory> list) {
        try (FileWriter fw = new FileWriter(FILE)) {
            for (Inventory i : list) {
                fw.write(i.getId() + "," + i.getName() + "," +
                         i.getQuantity() + "," + i.getSupplier() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
