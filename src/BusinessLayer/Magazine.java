package BusinessLayer;

import java.time.LocalDate;

public class Magazine extends Item {
    private String genre;
    private String producer;

    public Magazine(int itemNumber, String title, Priority priority, String itemType, LocalDate startBorrow, LocalDate endBorrow, String genre, String producer, String customerType) {
        super(itemNumber, title, priority, itemType, startBorrow, endBorrow, customerType);
        this.genre = genre;
        this.producer = producer;
    }


	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}


}