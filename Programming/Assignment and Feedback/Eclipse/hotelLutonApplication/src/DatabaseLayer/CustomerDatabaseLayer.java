package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;




import Helper.DatabaseConnector;
import Models.Customer;


public class CustomerDatabaseLayer {

	private Customer customer;
	private DatabaseConnector db;
	private Connection connection;
	
	public CustomerDatabaseLayer() {
		this.customer = new Customer();
	}
	
	public CustomerDatabaseLayer(Customer customer) throws Exception {
		this.customer = customer;
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
	
	