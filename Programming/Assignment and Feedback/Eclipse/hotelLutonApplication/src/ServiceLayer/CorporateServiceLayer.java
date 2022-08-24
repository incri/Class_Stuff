package ServiceLayer;
// This class uses the corporate model to receive and send data to the database layer
// This class uses the corporate model to receive data from the frontend layer
import Models.Corporate;


import java.util.ArrayList;

import DatabaseLayer.CorporateDatabaseLayer;

import Helper.InputException;

public class CorporateServiceLayer {
	Corporate corporate;
	
	public CorporateServiceLayer() {
		this.corporate = new Corporate();
	}
	
	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) throws InputException {
		try {
			if(this.validateUser(corporate)) {
				this.corporate = corporate;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	private boolean validateUser(Corporate corporate) throws InputException {
		if(corporate.getCompanyName() == null || corporate.getCompanyName().length() == 0) {
			throw new InputException("Company name cannot be empty.");
		}
		
		
		
		return true;
	}
	
	// save the corporate, update the corporate, delete the corporate, getCorporateList
	
	public Corporate save() throws Exception {
		// This function saves the corporate detail to database and 
		// returns the corporate object after saving
		try {
			CorporateDatabaseLayer corporateDatabaseLayer = new CorporateDatabaseLayer(this.corporate);
			return corporateDatabaseLayer.save();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Corporate update() throws Exception {
		// This function saves the corporate detail to database and returns the corporate object after saving
		try {
			CorporateDatabaseLayer corporateDatabaseLayer = new CorporateDatabaseLayer(this.corporate);
			return corporateDatabaseLayer.update();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void delete() throws Exception {
		// This function saves the corporate detail to database and returns the corporate object after saving
		try {
			CorporateDatabaseLayer corporateDatabaseLayer = new CorporateDatabaseLayer(this.corporate);
			corporateDatabaseLayer.delete();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Corporate> getAllCorporate() throws Exception {
		try {
			CorporateDatabaseLayer corporateDatabaseLayer = new CorporateDatabaseLayer(this.corporate);
			return corporateDatabaseLayer.getAllCorporate();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Corporate> searchUser(String[] keys, String[] values) throws Exception{
		try {
			CorporateDatabaseLayer corporateDatabaseLayer = new CorporateDatabaseLayer(this.corporate);
			return corporateDatabaseLayer.searchCorporate(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}                                                                                                                                                                                                                                                                                                                                                                                                
}
