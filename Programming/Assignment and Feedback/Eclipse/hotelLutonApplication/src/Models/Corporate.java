package Models;

public class Corporate {
	private int corpID;
	private String companyName;
	private int companyContact;
	
	public Corporate() {
		this.corpID = 0;
		this.companyName = "";
		this.companyContact = 0;
	}
	
	public Corporate(int corpID, String companyName, int companyContact ) {
		this.corpID = corpID;
		this.companyName = companyName;
		this.companyContact = companyContact;
	}

	public int getCorpID() {
		return corpID;
	}

	public void setCorpID(int corpID) {
		this.corpID = corpID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(int companyContact) {
		this.companyContact = companyContact;
	}
	
	
}