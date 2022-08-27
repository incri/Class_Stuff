package Models;

public class Administration {
	private int adminID;
	private String contact;
	private String firstName;
	private String lastName;
	
	
	
	public Administration() {
		this.adminID = 0;
		this.contact= "";
		this.firstName = "";
		this.lastName = "";
		
	}
	
	public Administration(int id, String contact, String firstName, String lastName ) {
		this.adminID = id;
		this.contact = contact;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
	