package DatabaseLayer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public Customer save() throws Exception {
		try {
			// prepare for the data to be returned in case of insert
			String generatedColumns[] = {"cusID","firstName", "lastName", "dOB"};
			// create the statement
			String query = "INSERT INTO Customer(firstName, lastName, dOB) VALUES(?,?,?)";
			PreparedStatement statement = this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1, this.customer.getFirstName());
			statement.setString(2, this.customer.getLastName());
			statement.setDate(3, this.customer.getdOB());
			// execute the query
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate>0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int customerID = rs.getInt(1);
					String name = rs.getString(2);
					this.customer.setCusID(customerID);
				}	
			}
			return this.customer;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public Customer update() throws Exception {
		try {
			// create the statement
			String query = "UPDATE Customer  SET firstName=? , lastName=?, dOB=?, WHERE cusID=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.customer.getFirstName());
			statement.setString(2, this.customer.getLastName());
			statement.setDate(3, this.customer.getdOB());
			statement.setInt(4, customer.getCusID());
			// execute the query
			statement.executeUpdate();
			return this.customer;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public void delete() throws Exception {
		try {
			// create the statement
			String query = "DELETE FROM Customer WHERE cusID=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, customer.getCusID());
			// execute the query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Customer> getAllUser() throws Exception {
		try {
			ArrayList<Customer> customers = new ArrayList<Customer>();
			String query = "SELECT * FROM Customer ORDER BY customerName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Customer u = new Customer();
				u.setCusID(rs.getInt("cusID"));
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
				u.setdOB(rs.getDate("dOB"));
				customers.add(u);
			}
			return customers;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Customer> searchUser(String[] keys, String[] values) throws Exception{
		// SELECT * FROM customer WHERE name LIKE '%Hari%' AND address LIKE '%PCPS%' ;
		ArrayList<Customer> customers = new ArrayList<Customer>();
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
			String query = "SELECT * FROM Customer"+where+" ORDER BY firstName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Customer u = new Customer();
				u.setCusID(rs.getInt("cusID"));
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
				u.setdOB(rs.getDate("dOB"));
				customers.add(u);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return customers;		
	}
}



