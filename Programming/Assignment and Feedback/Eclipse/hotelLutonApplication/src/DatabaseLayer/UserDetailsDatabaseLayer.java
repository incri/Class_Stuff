package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Helper.DatabaseConnector;
import Models.DefultModel;


public class UserDetailsDatabaseLayer {

	private DefultModel defultModel;
	private DatabaseConnector db;
	private Connection connection;
	
	
	public UserDetailsDatabaseLayer() {
		this.defultModel = new DefultModel();
	}
	
	public UserDetailsDatabaseLayer(DefultModel defultModel) throws Exception {
		this.defultModel = defultModel;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}

	public void setDefultModel(DefultModel defultModel) {
		this.defultModel = defultModel;
	}

	
	public ArrayList<DefultModel> loadUserDetails() throws Exception {
		try {
			ArrayList<DefultModel> defultModel = new ArrayList<DefultModel>();
			String query = "SELECT u.userID, CONCAT(c.firstName,\" \" ,c.lastName) AS Name, u.email, c2.companyName, c2.companyContact FROM Users u LEFT JOIN Customer c ON u.userID = c.userID \n"
					+ "LEFT JOIN Corporate c2 ON c2.userID = u.userID GROUP BY u.userID ORDER BY u.userID ";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				DefultModel dM = new DefultModel();
				dM.setUserID(rs.getInt("UserID"));
				dM.setName(rs.getString("name"));
				dM.setEmail(rs.getString("email"));
				dM.setCorpName(rs.getString("companyName"));
				dM.setCorpContact(rs.getString("companyContact"));
				defultModel.add(dM);
			}
			return defultModel;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	public DefultModel deleteUser(DefultModel defultmodel) throws Exception {
		try {
			// create the statement

			String query = "DELETE FROM Users INNER JOIN  WHERE userID = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1,defultmodel.getUserID());
			// execute the query
			if(statement.executeUpdate()!= 0) {
				JOptionPane.showInternalMessageDialog(null, "User Deleted");

			}
			else {
				JOptionPane.showInternalMessageDialog(null, "Unable to delete");

			}
		}catch(Exception ex) {
			throw ex;
		}
		return defultModel;
	}
}