package BusinessLayer;

import java.util.Date;
import java.util.Random;

public class General implements Member {

	private Date startBorrow;
	private Date endBorrow;
	private int exceedsDay;
	private double borrowingCharge;
	private double LateCharge;

	public General(Date startBorrow, Date endBorrow) {
		this.startBorrow = startBorrow;
		this.endBorrow = endBorrow;
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

	public int getExceedsDay() {
		return exceedsDay;
	}

	private void setExceedsDay() {
		
		Random random = new Random();
		int randomDay = random.nextInt(20);
		this.exceedsDay = randomDay;
	}

}
