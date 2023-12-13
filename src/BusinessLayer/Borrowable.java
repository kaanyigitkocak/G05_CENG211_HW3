package BusinessLayer;

import java.util.Date;

public interface Borrowable {
	
    public int calculateBorrowingDays(Date startBorrow, Date endBorrow);
    public double calculateLateCharge(Member customer);
    public double calculateBorrowingCharge(Date startBorrow, Date endBorrow);
    public double calculateDiscount(Member customer);
    public int calculateTotalPrice();
}
