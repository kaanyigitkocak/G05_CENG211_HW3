package BusinessLayer;

import java.time.LocalDate;

public class Book extends Item {
    private String author;
    private String publisher;

    public Book(int itemNumber, String title, Priority priority, String itemType, LocalDate startBorrow, LocalDate endBorrow, String author, String publisher, String customerType) {
        super(itemNumber, title, priority, itemType, startBorrow, endBorrow, customerType);
        this.author = author;
        this.publisher = publisher;
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


}
