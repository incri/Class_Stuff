package Models;



public class Customer {
	private int cusID;
	private String firstName;
	private String lastName;
	
	public Customer() {
		this.cusID = 0;
		this.firstName = "";
		this.lastName = "";
	}
	
	public Customer(int cusID, String firstName, String lastName, String dOB) {
		this.cusID = cusID;
		this.firstName = firstName;
		this.lastName = lastName;

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

	
	
	
}