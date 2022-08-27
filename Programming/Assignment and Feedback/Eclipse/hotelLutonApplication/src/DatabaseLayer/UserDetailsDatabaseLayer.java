package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;




import Helper.DatabaseConnector;
import Models.Corporate;
import Models.Customer;
import Models.Users;


public class UserDetailsDatabaseLayer {

	private Customer customer;
	private Corporate corporate;
	private Users user;
	private DatabaseConnector db;
	private Connection connection;
	
	public UserDetailsDatabaseLayer() {
		this.customer = new Customer();
		this.corporate = new Corporate();
		this.user = new Users();
	}
	
	public UserDetailsDatabaseLayer(Customer customer, Corporate corporate, Users user) throws Exception {
		this.customer = customer;
		this.corporate = corporate;
		this.user = user;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	public Customer customerSave() throws Exception {
		PreparedStatement statement;
		ResultSet rs;
		String registerCustomerQuery = "INSERT INTO Customer (firstName, lastName, userID) VALUES (?,?,?)";
	try {
		
			statement = this.connection.prepareStatement(registerCustomerQuery);
			statement.setString(1, this.customer.getFirstName());
			statement.setString(2, this.customer.getLastName());
			statement.setInt(3, UserDatabaseLayer.primkey);
			
			try {
				
				if (statement.executeUpdate() !=0) {
				}
				else {
					
				}
		
			} catch (Exception ex) {
				throw ex;
			}
	
	
	} catch (Exception ex) {
		throw ex;
	}
	return customer;
}
}
	
