package ServiceLayer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DatabaseLayer.UserDatabaseLayer;
import DatabaseLayer.UserDetailsDatabaseLayer;
import Models.DefultModel;


public class UserDetailsServiceLayer {
	DefultModel defultModel;
	
	public UserDetailsServiceLayer() {
		this.defultModel = new DefultModel();
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}
	
	public ArrayList<DefultModel> getAllData() throws Exception {
		try {
			UserDetailsDatabaseLayer userDetailsDL = new UserDetailsDatabaseLayer(this.defultModel);
			return userDetailsDL.loadUserDetails();
		}catch(Exception e) {
			throw e;
		}
	}
	public DefultModel deleteUser(DefultModel defultmodel) throws Exception {
		// This function saves the user detail to database and returns the user object after saving
		try {

			UserDetailsDatabaseLayer dlDetailsUser = new UserDetailsDatabaseLayer(defultModel);
			dlDetailsUser.deleteUser(defultmodel);
		} catch (Exception e) {
			throw e;
		}
		return defultmodel;
	}
}
