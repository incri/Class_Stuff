package ServiceLayer;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DatabaseLayer.GuestDatabaseLayer;
import DatabaseLayer.ReserveDatabaseLayer;
import Helper.InputException;
import Models.GuestData;
import Models.Reservation;


public class GuestServiceLayer {
	GuestData guest;
	java.util.Date checkInDate;
	java.util.Date checkOutDate;
	java.util.Date currentDate;
	DateTimeFormatter dtf;
	LocalDateTime now;
	
	
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
		if(!(guest.getFullName()).matches("^[a-zA-Z\\s]*$") ) {
			throw new InputException("Cannot input number on  name");
		}

		if(guest.getdOB() == null || guest.getdOB().length() == 0) {
			
			throw new InputException("Date of Birth cannot be empty.");
		}
		
		if(guest.getContact() == null || guest.getContact().length() == 0) {
			throw new InputException("Contact cannot be empty.");
		}
		if(!(guest.getContact()).matches("^[0-9, ]+$") ) {
			throw new InputException("cannot input alphabet on contact");
		}

		if(guest.getRoomPreference() == null || guest.getRoomPreference().length() == 0) {
			throw new InputException("Please enter your room preference");
		}

		if(guest.getCountry() == null || guest.getCountry().length() == 0) {
			throw new InputException("Country Name cannot be empty.");
		}
		if(!(guest.getCountry()).matches("[a-zA-Z]+") ) {
			throw new InputException("Cannot input number on  Country");
		}
		if(guest.getState() == null || guest.getState().length() == 0) {
			throw new InputException("State Name cannot be empty.");
		}
		if(!(guest.getState()).matches("[a-zA-Z]+") ) {
			throw new InputException("Cannot input number on  State");
		}
		if(guest.getCity() == null || guest.getCity().length() == 0) {
			throw new InputException("City Name cannot be empty.");
		}
		if(!(guest.getCity()).matches("[a-zA-Z]+") ) {
			throw new InputException("Cannot input number on City.");
		}
		
		
		dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");  
		now = LocalDateTime.now();  
		
		

		SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
		try {
			checkInDate = format.parse(guest.getCheckInDate());
			checkOutDate = format.parse(guest.getCheckOutDate());
			currentDate = format.parse(dtf.format(now));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		if(guest.getCheckInDate() == null || guest.getCheckInDate().length() == 0) {
			throw new InputException("Must enter Check Out Date");
		}
		if(checkInDate.before(currentDate)) {
			throw new InputException("Invalid Check in Date");
		}
		
		
		if(guest.getCheckOutDate() == null || guest.getCheckOutDate().length() == 0) {
			throw new InputException("Must enter Check Out Date");
		}
		
		if(checkOutDate.before(checkInDate)) {
			throw new InputException("Invalid Check Out Date");
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