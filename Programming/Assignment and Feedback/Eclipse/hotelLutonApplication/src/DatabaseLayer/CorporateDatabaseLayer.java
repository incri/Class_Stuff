package DatabaseLayer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DatabaseConnector;
import Models.Corporate;

public class CorporateDatabaseLayer {

	private Corporate corporate;
	private DatabaseConnector db;
	private Connection connection;
	
	public CorporateDatabaseLayer() {
		this.corporate = new Corporate();
	}
	
	public CorporateDatabaseLayer(Corporate corporate) throws Exception {
		this.corporate = corporate;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}
	
	public Corporate save() throws Exception {
		try {
			// prepare for the data to be returned in case of insert
			String generatedColumns[] = {"corpID","companyName", "companyContact"};
			// create the statement
			String query = "INSERT INTO Corporate(companyName, companyContact) VALUES(?,?)";
			PreparedStatement statement = this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1, this.corporate.getCompanyName());
			statement.setInt(2, this.corporate.getCompanyContact());
			// execute the query
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate>0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int corporateID = rs.getInt(1);
					String name = rs.getString(2);
					this.corporate.setCorpID(corporateID);
				}	
			}
			return this.corporate;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public Corporate update() throws Exception {
		try {
			// create the statement
			String query = "UPDATE Corporate  SET companyName=? , companyContact=?, WHERE corpID=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.corporate.getCompanyName());
			statement.setString(2, this.corporate.getCompanyName());
			statement.setInt(4, corporate.getCorpID());
			// execute the query
			statement.executeUpdate();
			return this.corporate;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public void delete() throws Exception {
		try {
			// create the statement
			String query = "DELETE FROM Corporate WHERE corpID=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, corporate.getCorpID());
			// execute the query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Corporate> getAllUser() throws Exception {
		try {
			ArrayList<Corporate> corporates = new ArrayList<Corporate>();
			String query = "SELECT * FROM Corporate ORDER BY corporateName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Corporate u = new Corporate();
				u.setCorpID(rs.getInt("corpID"));
				u.setCompanyName(rs.getString("companyName"));
				u.setCompanyContact(rs.getInt("companyContact"));
				corporates.add(u);
			}
			return corporates;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Corporate> searchUser(String[] keys, String[] values) throws Exception{
		// SELECT * FROM corporate WHERE name LIKE '%Hari%' AND address LIKE '%PCPS%' ;
		ArrayList<Corporate> corporates = new ArrayList<Corporate>();
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
			String query = "SELECT * FROM Corporate"+where+" ORDER BY companyName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Corporate u = new Corporate();
				u.setCorpID(rs.getInt("cusID"));
				u.setCompanyName(rs.getString("companyName"));
				u.setCompanyContact(rs.getInt("companyContact"));
				corporates.add(u);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return corporates;		
	}
}



