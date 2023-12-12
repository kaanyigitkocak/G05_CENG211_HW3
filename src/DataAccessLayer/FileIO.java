package DataAccessLayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import BusinessLayer.Member;
import BusinessLayer.Book;
import BusinessLayer.General;
import BusinessLayer.Item;
import BusinessLayer.Magazine;
import BusinessLayer.Priority;
import BusinessLayer.Student;

public class FileIO {

	private final static String filePath = "files/items.csv";
	public static ArrayList<Item> readItems() {
		
		ArrayList<Item> items = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                int itemNumber = Integer.parseInt(data[0].replaceAll("[^\\p{Print}]", "").trim());
                String title = data[1];
                Priority priority = Priority.valueOf(data[2].toUpperCase(Locale.ROOT).replace(' ', '_'));
                String itemType = data[3];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date startBorrow = (Date) dateFormat.parse(data[7]);
                Date endBorrow = (Date) dateFormat.parse(data[8]);
                Member customerType;
                switch (data[6]) {
                    case "general":
                        customerType = new General(startBorrow, endBorrow);
                        break;
                    case "studentWScholar":
                        customerType = new Student(startBorrow, endBorrow, true);
                        break;
                    case "studentWOScholar":
                        customerType = new Student(startBorrow, endBorrow, false);
                        break;
                    default:
                        throw new RuntimeException("Member couldn't created. "
                        		+ "There is an error on Member's type while reading the file.");
                }
                if (itemType.equalsIgnoreCase("book")) {
                    String author = data[4];
                    String publisher = data[5];
                    Book book = new Book(itemNumber, title, priority, itemType,startBorrow, endBorrow, author, publisher, customerType);
                    items.add(book);
                } else if (itemType.equalsIgnoreCase("magazine")) {
                    String genre = data[4];
                    String producer = data[5];
                    Magazine magazine = new Magazine(itemNumber, title, priority, itemType, startBorrow, endBorrow, genre, producer, customerType);
                    items.add(magazine);
                }   
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
		return items; 
		
	}
}
