package Models;

public class Reservation {
	private int reserveID;
	private String bookingStatus;
	private String paymentStatus;
	private int noOfStayDay;
	
	public Reservation() {
		this.reserveID = 0;
		this.bookingStatus = "";
		this.paymentStatus = "";
		this.noOfStayDay= 0;
	}
	
	public Reservation(int reserveID, String bookingStatus, String paymentStatus, int noOfStayDay ) {
		this.reserveID = reserveID;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.noOfStayDay = noOfStayDay;
	}

	public int getReserveID() {
		return reserveID;
	}

	public void setReserveID(int reserveID) {
		this.reserveID = reserveID;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getNoOfStayDay() {
		return noOfStayDay;
	}

	public void setNoOfStayDay(int noOfStayDay) {
		this.noOfStayDay = noOfStayDay;
	}
	
	
}