package ServiceLayer;


import java.util.ArrayList;

import DatabaseLayer.UserDetailsDatabaseLayer;
// This class uses the user model to receive and send data to the database layer
// This class uses the user model to receive data from the frontend layer
import Models.UserDetails;
import Models.Users;



public class UserDetailsServiceLayer {
	UserDetails userDetails;
	
	public UserDetailsServiceLayer() {
		this.userDetails = new UserDetails();
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public ArrayList<UserDetails> getAllUserDetails() throws Exception {
		try {
			UserDetailsDatabaseLayer userDetailsDatabase = new UserDetailsDatabaseLayer(getUserDetails());
			return userDetailsDatabase.getAllUserDetails();
		}catch(Exception e) {
			throw e;
		}
	}
}
	
	
	