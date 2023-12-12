package BusinessLayer;

import java.util.Date;

public interface Borrowable {
	
    int calculateBorrowingDays(Date startBorrow, Date endBorrow);
    double calculateLateCharge(Member customer);
    double calculateBorrowingCharge(Date startBorrow, Date endBorrow);
    double calculateDiscount(Member customer);
    int calculateTotalPrice();
}
