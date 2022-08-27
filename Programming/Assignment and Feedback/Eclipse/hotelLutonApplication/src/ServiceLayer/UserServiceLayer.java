package ServiceLayer;


// This class uses the user model to receive and send data to the database layer
// This class uses the user model to receive data from the frontend layer
import Models.Users;

import DatabaseLayer.UserDatabaseLayer;
import Helper.InputException;

public class UserServiceLayer {
	Users user;
	
	public UserServiceLayer() {
		this.user = new Users();
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) throws InputException {
		try {
			if(this.ValidateLogIn(user)) {
				this.user = user;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	
	//LogInBox validation
	public boolean ValidateLogIn(Users user) throws InputException {
		
		if(user.getUserName() == null || user.getUserName().length() == 0) {
			throw new InputException("User name cannot be empty.");
		}
		if(user.getPassword() == null || user.getPassword().length() == 0) {
			throw new InputException("Password cannot be empty.");
		}
		
		return true;
	}
	
	
	
	
	// save the user, update the user, delete the user, getUserList
	
	public Users userLogIn(Users user) throws Exception {
		//this fuction get the user detail to log in
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(user);
			return userDatabaseLayer.userLogIn();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Users userSave(Users user) throws Exception {
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(user);
			return userDatabaseLayer.userSave();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}
	
	
	