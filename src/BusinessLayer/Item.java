package BusinessLayer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Item implements Searchable, Borrowable {
    private int itemNumber;
    private String title;
    private Priority priority;
    private String itemType;
	private String customerType;
    private LocalDate startBorrow;
    private LocalDate endBorrow;
    private boolean exceedsDate;

    public Item(int itemNumber, String title, Priority priority, String itemType, LocalDate startBorrow, LocalDate endBorrow, String customerType) {
        this.itemNumber = itemNumber;
        this.title = title;
        this.priority = priority;
        this.itemType = itemType;
        this.startBorrow = startBorrow;
        this.endBorrow = endBorrow;
        this.customerType = customerType;
        this.exceedsDate = endBorrow.isAfter(startBorrow);
    }

    @Override
    public boolean searchByTitle(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    @Override
    public boolean searchByTitleAndType(String title, String type) {
        return this.title.equalsIgnoreCase(title) && this.itemType.equalsIgnoreCase(type);
    }

    @Override
    public void borrowItem(String customerType, LocalDate startBorrow, LocalDate endBorrow) {
        this.startBorrow = startBorrow;
        this.endBorrow = endBorrow;
        this.exceedsDate = endBorrow.isAfter(endBorrow);
    }

    @Override
    public int calculateBorrowingDays() {
        return (int) ChronoUnit.DAYS.between(startBorrow, endBorrow);
    }

    @Override
    public double calculateLateCharge() {
        int daysLate;
        if (this.itemType.equalsIgnoreCase("book")) {
            daysLate = calculateBorrowingDays() - 10;
            return (daysLate > 0) ? daysLate * 5 : 0;
        } else if (this.itemType.equalsIgnoreCase("magazine")) {
            daysLate = calculateBorrowingDays() - 7;
            return (daysLate > 0) ? daysLate * 2 : 0;
        }
        return 0;
    }

    @Override
    public double calculateBorrowingCharge() {
        int daysBorrowed = calculateBorrowingDays();
        if (this.itemType.equalsIgnoreCase("book")) {
            return daysBorrowed * 5 * priority.getValue();
        } else if (this.itemType.equalsIgnoreCase("magazine")) {
            return daysBorrowed * 10 * priority.getValue();
        }
        return 0;
    }

    @Override
    public double calculateDiscount() {


        if (customerType.startsWith("student")) {
            if (customerType.equals("studentWScholar")) {
                return calculateBorrowingCharge() * 0.3; // 30% discount
            } else {
                return calculateBorrowingCharge() * 0.2; // 20% discount
            }
        }
        return 0;
    }

    @Override
    public double calculateTotalPrice() {
        double borrowingCharge = calculateBorrowingCharge();
        double lateCharge = calculateLateCharge();
        double discount = calculateDiscount();
        return borrowingCharge + lateCharge - discount;
    }

    public void printDetails() {
        System.out.println("Item Number: " + itemNumber);
        System.out.println("Title: " + title);
        System.out.println("Item Type: " + itemType);
        System.out.println("Total Borrowing Days: " + calculateBorrowingDays());
        System.out.println("Exceeds Date: " + (exceedsDate ? "exceeds" : "not exceeds"));
        System.out.println("Total Price: $" + calculateTotalPrice());
        System.out.println("-----------------------------------------");
    }
}

