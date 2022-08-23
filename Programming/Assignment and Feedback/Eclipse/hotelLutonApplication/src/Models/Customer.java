package Models;

public class Customer {
	private int cusID;
	private String firstName;
	private String lastName;
	private java.sql.Date dOB;
	
	public Customer() {
		this.cusID = 0;
		this.firstName = "";
		this.lastName = "";
		this.dOB= null;
	}
	
	public Customer(int cusID, String firstName, String lastName, java.sql.Date dOB) {
		this.cusID = cusID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dOB = dOB;
	}

	public int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		this.cusID = cusID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public java.sql.Date getdOB() {
		return dOB;
	}

	public void setdOB(java.sql.Date dOB) {
		this.dOB = dOB;
	}
	
	
}