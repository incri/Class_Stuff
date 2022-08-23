package ServiceLayer;
// This class uses the user model to receive and send data to the database layer
// This class uses the user model to receive data from the frontend layer
import Models.Users;

import java.util.ArrayList;

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
			if(this.validateUser(user)) {
				this.user = user;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	private boolean validateUser(Users user) throws InputException {
		if(user.getEmail() == null || user.getEmail().length() == 0) {
			throw new InputException("Email cannot be empty.");
		}
		if(user.getUserName() == null || user.getUserName().length() == 0) {
			throw new InputException("User name cannot be empty.");
		}
		if(user.getPassword() == null || user.getPassword().length() == 0) {
			throw new InputException("Password cannot be empty.");
		}
		
		return true;
	}
	
	// save the user, update the user, delete the user, getUserList
	
	public Users save() throws Exception {
		// This function saves the user detail to database and 
		// returns the user object after saving
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(this.user);
			return userDatabaseLayer.save();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Users update() throws Exception {
		// This function saves the user detail to database and returns the user object after saving
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(this.user);
			return userDatabaseLayer.update();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void delete() throws Exception {
		// This function saves the user detail to database and returns the user object after saving
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(this.user);
			userDatabaseLayer.delete();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Users> getAllUser() throws Exception {
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(this.user);
			return userDatabaseLayer.getAllUser();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Users> searchUser(String[] keys, String[] values) throws Exception{
		try {
			UserDatabaseLayer userDatabaseLayer = new UserDatabaseLayer(this.user);
			return userDatabaseLayer.searchUser(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}
}
