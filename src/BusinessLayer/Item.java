package BusinessLayer;
import java.util.Date;

public abstract class Item implements Searchable, Borrowable {
    private int itemNumber;
    private String title;
    private Priority priority;
    private String itemType;
	private Member customerType;
    private Date startBorrow;
    private Date endBorrow;
    private boolean exceedsDate;

    public Item(int itemNumber, String title, Priority priority, String itemType, Date startBorrow, Date endBorrow, Member customerType) {
        this.itemNumber = itemNumber;
        this.title = title;
        this.priority = priority;
        this.itemType = itemType;
        this.startBorrow = startBorrow;
        this.endBorrow = endBorrow;
        this.customerType = customerType;
        if(customerType.getExceedsDay() != 0) {
        	exceedsDate = true;
        } else {
        	exceedsDate = false;
        }
    }
 
    @Override
	public int calculateBorrowingDays(Date startBorrow, Date endBorrow) {
    	long differenceInMillis = endBorrow.getTime() - startBorrow.getTime();
    	int borrowingDays = (int) (differenceInMillis / (1000 * 60 * 60 * 24));
		return borrowingDays;
	}

	@Override
	abstract public double calculateLateCharge(Member customer);

	@Override
	abstract public double calculateBorrowingCharge(Date startBorrow, Date endBorrow);

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

	@Override
	public int calculateTotalPrice() {
		double borrowingCharge = calculateBorrowingCharge(this.getStartBorrow(), this.getEndBorrow());
		double lateCharge = calculateLateCharge(this.getCustomerType());
		double discountRatio = calculateDiscount(this.getCustomerType());
		return (int) ((borrowingCharge * discountRatio) + lateCharge);
	}

	@Override
	public boolean searchByTitle(String title) {
		return this.title.equalsIgnoreCase(title);
	}

	@Override
	public boolean searchByTitleAndType(String title, String type) {
		return this.title.equalsIgnoreCase(title) && this.itemType.equalsIgnoreCase(type);
	}

    public void printDetails() {
        System.out.println("Item Number: " + itemNumber);
        System.out.println("Title: " + title);
        System.out.println("Item Type: " + itemType);
        System.out.println("Total Borrowing Days: " + calculateBorrowingDays(this.startBorrow, this.endBorrow));
        System.out.println("Exceeds Date: " + (exceedsDate ? "exceeds " + this.customerType.getExceedsDay() : "not exceeds"));
        System.out.println("Total Price: $" + calculateTotalPrice());
        System.out.println("-----------------------------------------");
    }

	public int getItemNumber() {
		return itemNumber;
	}

	public String getTitle() {
		return title;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getItemType() {
		return itemType;
	}

	public Member getCustomerType() {
		return customerType;
	}

	public Date getStartBorrow() {
		return startBorrow;
	}

	public Date getEndBorrow() {
		return endBorrow;
	}

	public boolean isExceedsDate() {
		return exceedsDate;
	}
	
   
}

