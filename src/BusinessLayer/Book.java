package BusinessLayer;

import java.util.Date;

public class Book extends Item {
    private String author;
    private String publisher;
    private final double BOOK_LATE_CHARGE = 5.0;
    private final double BOOK_CHARGE_PER_DAY = 5.0;
    private double totalCharge;

    public Book(int itemNumber, String title, Priority priority, String itemType, Date startBorrow, Date endBorrow, String author, String publisher, Member customer) {
        super(itemNumber, title, priority, itemType, startBorrow, endBorrow, customer);
        this.author = author;
        this.publisher = publisher;
        printDetails();
        this.totalCharge = calculateTotalPrice();
      
    }

	public String getAuthor() {
		return author;
	}


	public String getPublisher() {
		return publisher;
	}
	
	public double getTotalCharge() {
		return totalCharge;
	}

	@Override
	public double calculateLateCharge(Member customer) {
		if (customer.getExceedsDay() > 10) {
            return BOOK_LATE_CHARGE;
		} else {
			return 0;
		}
	}

	@Override
	public double calculateBorrowingCharge(Date startBorrow, Date endBorrow) {
		int borrowingDays = calculateBorrowingDays(startBorrow, endBorrow);
		return borrowingDays * BOOK_CHARGE_PER_DAY * getPriority().getValue();
	}

	@Override
	public double calculateDiscount(Member customer) {
		if(customer instanceof Student) {
			if(((Student) customer).isHasScholarship()) {
				return 0.7; //discount %30
			} else {
				return 0.8; //discount %20
			}
		}
		return 1.0; //not effects multiplication if customer is
	}


	

	

	


}
