package ServiceLayer;
// This class uses the corporate model to receive and send data to the database layer
// This class uses the corporate model to receive data from the frontend layer
import Models.Corporate;
import Models.Customer;

import java.util.ArrayList;

import DatabaseLayer.CorporateDatabaseLayer;
import DatabaseLayer.CustomerDatabaseLayer;
import Helper.InputException;

public class CorporateServiceLayer {
	Corporate corporate;
	
	public CorporateServiceLayer() {
		this.corporate = new Corporate();
	}
	
	public Corporate getCorporate() {
		return corporate;
	}

	
public boolean ValidateCorporate(Corporate corporate) throws InputException {
		
		if(corporate.getCompanyName() == null || corporate.getCompanyName().length() == 0) {
			throw new InputException("Company name cannot be empty.");
		}
		
		if(corporate.getCompanyContact() == null || corporate.getCompanyContact().length() == 0) {
			throw new InputException("Company Contact cannot be empty.");
		}
		if(!(corporate.getCompanyContact()).matches("^[0-9, ]+$") ) {
			throw new InputException("cannot input alphabet on contact");
		}
		return true;
	}
	
	
	public Corporate corporateSave(Corporate corporate) throws Exception {
		try {
			CorporateDatabaseLayer corporateDatabaseLayer = new CorporateDatabaseLayer(corporate);
			return corporateDatabaseLayer.corporateSave();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}
	// save the corporate, update the corporate, delete the corporate, getCorporateList
	
	