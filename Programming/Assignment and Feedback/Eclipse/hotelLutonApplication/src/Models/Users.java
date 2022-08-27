package Models;

public class Users {
	private static int userID;
	private String email;
	private String userName;
	private String password;
	private String userType;
	
	public Users() {
		Users.userID = 0;
		this.email = "";
		this.userName = "";
		this.password = "";
		this.userType = "";
	}
	
	public Users(int id, String email, String userName, String password, String role ) {
		Users.userID = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public static int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		Users.userID = userID;
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