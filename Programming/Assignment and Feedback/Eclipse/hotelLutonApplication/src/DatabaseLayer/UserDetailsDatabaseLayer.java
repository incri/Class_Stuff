package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Helper.DatabaseConnector;
import Models.UserDetails;
import Models.Users;


public class UserDetailsDatabaseLayer {

	private UserDetails userDetails;
	private DatabaseConnector db;
	private Connection connection;
	public ResultSetMetaData rsmd;
	
	public UserDetailsDatabaseLayer() {
		this.userDetails = new UserDetails();
	}
	
	public UserDetailsDatabaseLayer(UserDetails userDetails) throws Exception {
		this.userDetails = userDetails;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public UserDetails getuserDetails() {
		return userDetails;
	}

	public void setuserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public ArrayList<UserDetails> getAllUserDetails() throws Exception {
		
		try {
			ArrayList<UserDetails> userDetails = new ArrayList<UserDetails>();
			String userDetailsQuery = "SELECT u.userID, c.cusID, CONCAT(c.firstName,c.lastName) AS Name, u.email, c2.corpID, c2.companyName, c2.companyContact FROM Users u  JOIN Customer c  ON u.userID  = c.userID JOIN Corporate c2 ON u.userID = c2.userID ORDER BY u.userID ";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(userDetailsQuery);
			
	
			while(rs.next()) {
				UserDetails ud = new UserDetails();
				ud.setUserID(rs.getInt(1));
				ud.setCusID(rs.getInt(2));
				ud.setName(rs.getString(3));
				ud.setEmail(rs.getString(4));
				ud.setCorpID(rs.getInt(5));
				ud.setCorporateName(rs.getString(5));
				ud.setCorporateContact(rs.getString(7));
				userDetails.add(ud);
			}
			//rsmd = (ResultSetMetaData) rs.getMetaData();
			return userDetails;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}
	
	