package ServiceLayer;

import DatabaseLayer.GuestDatabaseLayer;
import DatabaseLayer.ReserveDatabaseLayer;
import Helper.InputException;
import Models.GuestData;
import Models.Reservation;


public class GuestServiceLayer {
	GuestData guest;
	
	public GuestServiceLayer() {
		this.guest = new GuestData();
	}

	public GuestData getGuestData() {
		return guest;
	}

	
public boolean validateGuestDetails(GuestData guest) throws InputException {
	
		if(guest.getFullName() == null || guest.getFullName().length() == 0) {
			throw new InputException("Name cannot be empty.");
		}

		if(guest.getdOB() == null || guest.getdOB().length() == 0) {
			throw new InputException("Date of Birth cannot be empty.");
		}
		if(guest.getContact() == null || guest.getContact().length() == 0) {
			throw new InputException("Contact cannot be empty.");
		}

		if(guest.getRoomPreference() == null || guest.getRoomPreference().length() == 0) {
			throw new InputException("Please enter your room preference");
		}

		if(guest.getCountry() == null || guest.getCountry().length() == 0) {
			throw new InputException("Country Name cannot be empty.");
		}
		if(guest.getState() == null || guest.getState().length() == 0) {
			throw new InputException("State Name cannot be empty.");
		}
		if(guest.getCity() == null || guest.getCity().length() == 0) {
			throw new InputException("City Name cannot be empty.");
		}

		if(guest.getCheckInDate() == null || guest.getCheckInDate().length() == 0) {
			throw new InputException("Must enter Check In Date");
		}
		if(guest.getCheckOutDate() == null || guest.getCheckOutDate().length() == 0) {
			throw new InputException("Must enter Check Out Date");
		}
		
		return true;
	}
	
	
	
	
	public GuestData guestSave(GuestData guest) throws Exception {
		try {
			GuestDatabaseLayer guestDatabaseLayer = new GuestDatabaseLayer(guest);
			return guestDatabaseLayer.guestSave();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	

}