package Models;

import java.util.Date;

public class GuestData {
	private int guestID;
	private String fullName;
	private String dOB;
	private String country;
	private String state;
	private String city;
	private String checkInDate;
	private String checkOutDate;
	private String contact;
	private String roomPreference;
	

	
	
	public GuestData() {
		this.guestID = 0;
		this.fullName = "";
		this.dOB= "";
		this.country = "";
		this.state = "";
		this.city= "";
		this.checkInDate = "";
		this.checkOutDate= "";
		this.contact = "";
		this.roomPreference= "";
	}
	
	public GuestData(int guestID, String fullName, String dOB,
			String country, String state, String city, 
			String checkInDate, String checkOutDate, String contact, String roomPreference) {
		this.guestID = guestID;
		this.fullName= fullName;
		this.dOB= dOB;
		this.country = country;
		this.state = state;
		this.city= city;
		this.checkInDate = checkInDate;
		this.checkOutDate= checkOutDate;
		this.contact = contact;
		this.roomPreference= roomPreference;
	}

	public int getGuestID() {
		return guestID;
	}

	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRoomPreference() {
		return roomPreference;
	}

	public void setRoomPreference(String roomPreference) {
		this.roomPreference = roomPreference;
	}
	
	
}