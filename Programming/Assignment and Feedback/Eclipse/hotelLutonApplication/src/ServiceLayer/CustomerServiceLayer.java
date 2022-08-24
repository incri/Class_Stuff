package ServiceLayer;
// This class uses the customer model to receive and send data to the database layer
// This class uses the customer model to receive data from the frontend layer
import Models.Customer;


import java.util.ArrayList;

import DatabaseLayer.CustomerDatabaseLayer;
import Helper.InputException;

public class CustomerServiceLayer {
	Customer customer;
	
	public CustomerServiceLayer() {
		this.customer = new Customer();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) throws InputException {
		try {
			if(this.validateUser(customer)) {
				this.customer = customer;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	private boolean validateUser(Customer customer) throws InputException {
		if(customer.getFirstName() == null || customer.getFirstName().length() == 0) {
			throw new InputException("First name cannot be empty.");
		}
		if(customer.getLastName() == null || customer.getLastName().length() == 0) {
			throw new InputException("Last name cannot be empty.");
		}
		if(customer.getdOB() == null || ((CharSequence) customer.getdOB()).length() == 0) {
			throw new InputException("Date Of Birth cannot be empty.");
		}
		
		return true;
	}
	
	// save the customer, update the customer, delete the customer, getCustomerList
	
	public Customer save() throws Exception {
		// This function saves the customer detail to database and 
		// returns the customer object after saving
		try {
			CustomerDatabaseLayer customerDatabaseLayer = new CustomerDatabaseLayer(this.customer);
			return customerDatabaseLayer.save();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Customer update() throws Exception {
		// This function saves the customer detail to database and returns the customer object after saving
		try {
			CustomerDatabaseLayer customerDatabaseLayer = new CustomerDatabaseLayer(this.customer);
			return customerDatabaseLayer.update();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void delete() throws Exception {
		// This function saves the customer detail to database and returns the customer object after saving
		try {
			CustomerDatabaseLayer customerDatabaseLayer = new CustomerDatabaseLayer(this.customer);
			customerDatabaseLayer.delete();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Customer> getAllCustomer() throws Exception {
		try {
			CustomerDatabaseLayer customerDatabaseLayer = new CustomerDatabaseLayer(this.customer);
			return customerDatabaseLayer.getAllCustomer();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Customer> searchUser(String[] keys, String[] values) throws Exception{
		try {
			CustomerDatabaseLayer customerDatabaseLayer = new CustomerDatabaseLayer(this.customer);
			return customerDatabaseLayer.searchCustomer(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}
}
