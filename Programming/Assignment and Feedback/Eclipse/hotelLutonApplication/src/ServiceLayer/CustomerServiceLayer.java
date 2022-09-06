package ServiceLayer;
// This class uses the customer model to receive and send data to the database layer
// This class uses the customer model to receive data from the frontend layer
import Models.Customer;
import Models.Users;

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
	
	
	
	//LogInBox validation
	public boolean ValidateCustomer(Customer customer) throws InputException {
		
		if(customer.getFirstName() == null || customer.getFirstName().length() == 0) {
			throw new InputException("First name cannot be empty.");
		}
		if(!(customer.getFirstName()).matches("[a-zA-Z]+") ) {
			throw new InputException("Cannot input number on first name");
		}
		if(customer.getLastName() == null || customer.getLastName().length() == 0) {
			throw new InputException("Last name cannot be empty.");
		}
		
		if(!(customer.getLastName()).matches("[a-zA-Z]+") ) {
			throw new InputException("Cannot input number on last name");
		}
		
		return true;
	}
	
	public Customer customerSave(Customer customer) throws Exception {
		try {
			CustomerDatabaseLayer customerDatabaseLayer = new CustomerDatabaseLayer(customer);
			return customerDatabaseLayer.customerSave();
		}catch(Exception e) {
			throw e;
		}
		
	}
}