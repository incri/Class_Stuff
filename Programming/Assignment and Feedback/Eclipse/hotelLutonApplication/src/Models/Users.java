package Models;

public class Users {
	private int userID;
	private String email;
	private String userName;
	private String password;
	
	public Users() {
		this.userID = 0;
		this.email = "";
		this.userName = "";
		this.password= "";
	}
	
	public Users(int id, String email, String userName, String password ) {
		this.userID = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
	
	
}