package Models;

public class Users {
	private int userId;
	private String firstName;
	private String lastName;
	private String companyName;
	private String companyContact;
	
	public Users() {
		this.userId = 0;
		this.firstName = "";
		this.lastName = "";
		this.companyName = "";
		this.companyContact = "";
	}
	public Users(int id, String firstName, String lastName, String companyName, String companyContact) {
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.companyContact = companyContact;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyContact() {
		return companyContact;
	}
	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}
	public void setUsersId(int userId) {
		this.userId = userId;
	}
	public int getUsersId() {
		return userId;
	}
	
}
