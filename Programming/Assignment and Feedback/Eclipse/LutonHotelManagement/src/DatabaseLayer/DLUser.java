package DatabaseLayer;

import Models.Users;

import Helper.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DLUser {
	private Users user;
	private DatabaseConnector db;
	private Connection connection;
	
	
	public DLUser() throws Exception {
		this.user = new Users();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLUser(Users user) throws Exception {
		this.user = user;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
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
			String generatedColumns[] = {"id","name"};
			// create the statement
			String query = "INSERT INTO user(name, address) VALUES(?,?)";
			PreparedStatement statement = this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1, this.user.getName());
			statement.setString(2, this.user.getAddress());
			// execute the query
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate>0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					rs.getString(2);
					this.user.setUserId(id);
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
			String query = "UPDATE user  SET name=? , address=? WHERE id=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.user.getName());
			statement.setString(2, this.user.getAddress());
			statement.setInt(3, user.getUserId());
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
			String query = "DELETE FROM user WHERE id=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, user.getUserId());
			// execute the query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Users> loadUser() throws Exception {
		try {
			ArrayList<Users> users = new ArrayList<Users>();
			String query = "SELECT * FROM user ORDER BY name";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Users u = new Users();
				u.setUserId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAddress(rs.getString("address"));
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
			String query = "SELECT * FROM user"+where+" ORDER BY name";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Users u = new Users();
				u.setUserId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAddress(rs.getString("address"));
				users.add(u);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return users;		
	}
}
