package Models;

import java.util.Date;

public class Billing {
	private int billingID;
	private Date paidDate;
	private String totalBill;
	
	public Billing() {
		this.billingID = 0;
		this.paidDate = null;
		this.totalBill = "";
		
	}
	
	public Billing(int billingID, Date paidDate, String totalBill ) {
		this.billingID = billingID;
		this.paidDate = paidDate;
		this.totalBill = totalBill;
	}

	public int getBillingID() {
		return billingID;
	}

	public void setBillingID(int billingID) {
		this.billingID = billingID;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	
	
}