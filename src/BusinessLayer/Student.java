package BusinessLayer;

import java.util.Date;
import java.util.Random;

public class Student implements Member {

	private Date startBorrow;
	private Date endBorrow;
	private int exceedsDay;
	private double borrowingCharge;
	private double LateCharge;
	private double discount;
	private boolean isHasScholarship;
	
	public Student(Date startBorrow,Date endBorrow,boolean isHasScholarship) {
		
		this.startBorrow = startBorrow;
		this.endBorrow = endBorrow;
		this.isHasScholarship = isHasScholarship;
		setExceedsDay();
	}

	public Date getStartBorrow() {
		return startBorrow;
	}

	public Date getEndBorrow() {
		return endBorrow;
	}

	public double getBorrowingCharge() {
		return borrowingCharge;
	}

	public void setBorrowingCharge(double borrowingCharge) {
		this.borrowingCharge = borrowingCharge;
	}

	public double getLateCharge() {
		return LateCharge;
	}

	public void setLateCharge(double lateCharge) {
		LateCharge = lateCharge;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isHasScholarship() {
		return isHasScholarship;
	}

	public int getExceedsDay() {
		return exceedsDay;
	}
	
	private void setExceedsDay() {
		
		Random random = new Random();
		int randomDay = random.nextInt(20);
		this.exceedsDay = randomDay;
	}
	
}
