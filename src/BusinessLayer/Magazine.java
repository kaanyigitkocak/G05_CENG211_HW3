package BusinessLayer;

import java.util.Date;

public class Magazine extends Item {
    private String genre;
    private String producer;
    private final double MAGAZINE_LATE_CHARGE = 2.0;
    private final double MAGAZINE_CHARGE_PER_DAY = 10.0;
    private double totalCharge;

    public Magazine(int itemNumber, String title, Priority priority, String itemType, Date startBorrow, Date endBorrow, String genre, String producer, Member customerType) {
        super(itemNumber, title, priority, itemType, startBorrow, endBorrow, customerType);
        this.genre = genre;
        this.producer = producer;
        this.totalCharge = calculateTotalPrice();
      
    }

	public String getGenre() {
		return genre;
	}

	public String getProducer() {
		return producer;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	@Override
	public double calculateLateCharge(Member customer) {
		if(customer.getExceedsDay() > 7) {
			return MAGAZINE_LATE_CHARGE;
		} else {
			return 0;
		}
	}

	@Override
	public double calculateBorrowingCharge(Date startBorrow, Date endBorrow) {
		int borrowingDays = calculateBorrowingDays(startBorrow, endBorrow);
		return borrowingDays * MAGAZINE_CHARGE_PER_DAY * getPriority().getValue();
	}

	
}