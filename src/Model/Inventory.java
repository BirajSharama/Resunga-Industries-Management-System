package Model;

public class Inventory {
    private int id;
    private String name;
    private int quantity;
    private String supplier;

    public Inventory(int id, String name, int quantity, String supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getSupplier() { return supplier; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
