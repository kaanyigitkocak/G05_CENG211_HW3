package BusinessLayer;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items;

    public Library(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void searchAndPrint(String title, String itemType) {
        boolean found = false;
        for (Item item : items) {
            if (item.searchByTitleAndType(title, itemType)) {
                item.printDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item with title '" + title + "' and type '" + itemType + "' does not exist.");
        }
    }
    public void printAllItems() {
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        for (Item item : items) {
            item.printDetails();
        }
    }
}