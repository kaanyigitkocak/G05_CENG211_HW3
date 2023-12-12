package PresentationLayer;

import java.util.ArrayList;

import BusinessLayer.Item;
import BusinessLayer.Library;
import DataAccessLayer.FileIO;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        
    	ArrayList<Item> items = FileIO.readItems();
    	Library library = new Library(items);
    	library.printAllItems();   	
    }
}
