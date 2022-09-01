package Models;



public class Customer {
	private static int cusID;
	private String firstName;
	private String lastName;
	
	public Customer() {
		Customer.cusID = 0;
		this.firstName = "";
		this.lastName = "";
	}
	
	public Customer(int cusID, String firstName, String lastName) {
		Customer.cusID = cusID;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public static int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		Customer.cusID = cusID;
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