package Models;

public class UserDetails {
	private static int userID;
	private static int cusID;
	private String name;
	private String email;
	private int corpID;
	private String corporateName;
	private String corporateContact;
	private String userType;
	
	public UserDetails() {
		UserDetails.userID = 0;
		UserDetails.cusID = 0;
		this.corpID = 0;
		this.name = "";
		this.email = "";
		this.corporateName = "";
		this.corporateContact = "";
		this.userType = "";
	}
	
	public UserDetails(int userID, int cusID,  String name, String email,int corpID, String corporateName, String corporateContact, String userType ) {
		UserDetails.userID = userID;
		UserDetails.cusID = cusID;
		this.name = name;
		this.email = email;
		this.corpID = corpID;
		this.corporateName = corporateName;
		this.corporateContact = corporateContact;
		this.userType = userType;
	}

	public int getUserID() {
		return userID;
	}

	public  void setUserID(int userID) {
		UserDetails.userID = userID;
	}

	

	public int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		UserDetails.cusID = cusID;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getCorpID() {
		return corpID;
	}

	public void setCorpID(int corpID) {
		this.corpID = corpID;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCorporateContact() {
		return corporateContact;
	}

	public void setCorporateContact(String corporateContact) {
		this.corporateContact = corporateContact;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}



	
}