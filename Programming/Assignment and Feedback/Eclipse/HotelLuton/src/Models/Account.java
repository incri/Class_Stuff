package Models;

public class Account {
	private String email;
	private String userName;
	private String password;
	private String userType;
	
	public Account() {
		this.email = "";
		this.userName = "";
		this.password = "";
		this.userType = "";
	}
	public Account( String email, String userName, String password, String userType) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
