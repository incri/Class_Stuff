package DatabaseLayer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DatabaseConnector;
import Models.Users;

public class UserDatabaseLayer {

	private Users user;
	private DatabaseConnector db;
	private Connection connection;
	
	public UserDatabaseLayer() {
		this.user = new Users();
	}
	
	public UserDatabaseLayer(Users user) throws Exception {
		this.user = user;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public Users save() throws Exception {
		try {
			// prepare for the data to be returned in case of insert
			String generatedColumns[] = {"userID","email", "userName", "password"};
			// create the statement
			String query = "INSERT INTO Users(email, userName, password) VALUES(?,?,?)";
			PreparedStatement statement = this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1, this.user.getEmail());
			statement.setString(2, this.user.getUserName());
			statement.setString(3, this.user.getPassword());
			// execute the query
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate>0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int userID = rs.getInt(1);
					rs.getString(2);
					this.user.setUserID(userID);
				}	
			}
			return this.user;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public Users update() throws Exception {
		try {
			// create the statement
			String query = "UPDATE Users  SET email=? , userName=?, password=?, WHERE userID=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.user.getEmail());
			statement.setString(2, this.user.getUserName());
			statement.setString(3, this.user.getPassword());
			statement.setInt(4, user.getUserID());
			// execute the query
			statement.executeUpdate();
			return this.user;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public void delete() throws Exception {
		try {
			// create the statement
			String query = "DELETE FROM Users WHERE userID=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, user.getUserID());
			// execute the query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Users> getAllUser() throws Exception {
		try {
			ArrayList<Users> users = new ArrayList<Users>();
			String query = "SELECT * FROM Users ORDER BY userName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Users u = new Users();
				u.setUserID(rs.getInt("userID"));
				u.setEmail(rs.getString("email"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				users.add(u);
			}
			return users;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Users> searchUser(String[] keys, String[] values) throws Exception{
		// SELECT * FROM user WHERE name LIKE '%Hari%' AND address LIKE '%PCPS%' ;
		ArrayList<Users> users = new ArrayList<Users>();
		try {
			int keyLength = keys.length;
			String where = "";
			for(int i=0; i<keyLength; ++i) {
				if(i==0) {
					where = where+" WHERE "+ keys[i]+" LIKE '%"+values[i]+"%' ";
				}else {
					where = where+" AND "+ keys[i]+" LIKE '%"+values[i]+"%' ";
				}
			}
			String query = "SELECT * FROM Users"+where+" ORDER BY userName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Users u = new Users();
				u.setUserID(rs.getInt("userID"));
				u.setEmail(rs.getString("email"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getNString("password"));
				users.add(u);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return users;		
	}
}



