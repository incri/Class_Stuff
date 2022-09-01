package DatabaseLayer;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Helper.DatabaseConnector;
import Models.Corporate;
import Models.Users;


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
	
	public Corporate corporateSave() throws Exception {
		PreparedStatement statement;
		ResultSet rs;
		String registerCorporateQuery = "INSERT INTO Corporate (companyName, companyContact, userID, cusID) VALUES (?,?,?,?)";
	try {
		
			statement = this.connection.prepareStatement(registerCorporateQuery);
			statement.setString(1, this.corporate.getCompanyName());
			statement.setString(2, this.corporate.getCompanyContact());
			statement.setInt(3, UserDatabaseLayer.PrimKey);
			statement.setInt(4, CustomerDatabaseLayer.PrimKey);
			
			try {
				
				if (statement.executeUpdate() !=0) {
					
				}
			
		
			} catch (Exception ex) {
				throw ex;
			}
	
	
	} catch (Exception ex) {
		throw ex;
	}
	return corporate;
}
}
	
