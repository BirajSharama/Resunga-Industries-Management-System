package controller;

import java.util.ArrayList;
import model.Item;

public class InventoryController {

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String name, String type, int qty) {
        items.add(new Item(name, type, qty));
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}