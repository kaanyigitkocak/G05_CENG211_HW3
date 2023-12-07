package BusinessLayer;

import java.time.LocalDate;

public interface Borrowable {
    void borrowItem(String customerType, LocalDate startBorrow, LocalDate endBorrow);
    int calculateBorrowingDays();
    double calculateLateCharge();
    double calculateBorrowingCharge();
    double calculateDiscount();
    double calculateTotalPrice();
}
