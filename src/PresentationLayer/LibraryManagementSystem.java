package PresentationLayer;

import java.time.LocalDate;
import BusinessLayer.Library;
import BusinessLayer.Book;
import BusinessLayer.Magazine;
import BusinessLayer.Priority;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        String filePath = "files/items.csv"; // Replace this with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String cleanedItemNumber = data[0].replaceAll("[^\\p{Print}]", "").trim();

                int itemNumber = Integer.parseInt(cleanedItemNumber);
                String title = data[1];
                Priority priority = Priority.valueOf(data[2].toUpperCase(Locale.ROOT).replace(' ', '_'));
                String itemType = data[3];
                LocalDate startBorrow = LocalDate.parse(data[7], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate endBorrow = LocalDate.parse(data[8], DateTimeFormatter.ofPattern("dd/MM/yyyy"));


                if (itemType.equalsIgnoreCase("book")) {
                    String author = data[4];
                    String publisher = data[5];
                    String customerType = data[6];

                    Book book = new Book(itemNumber, title, priority, itemType,startBorrow, endBorrow, author, publisher, customerType);
                    library.addItem(book);
                } else if (itemType.equalsIgnoreCase("magazine")) {
                    String genre = data[4];
                    String producer = data[5];
                    String customerType = data[6];

                    Magazine magazine = new Magazine(itemNumber, title, priority, itemType, startBorrow, endBorrow, genre, producer, customerType);
                    library.addItem(magazine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        library.printAllItems();
        library.searchAndPrint("History of Art", "book");
        library.searchAndPrint("Space Exploration", "magazine");
    }
}
