package Models;

import java.util.Date;

public class GuestData {
	private int guestID;
	private String firstNAme;
	private String lastName;
	private Date dOB;
	private String country;
	private String state;
	private String city;
	private int postalCode;
	private Date checkInDate;
	private Date checkOutDate;
	private int contact;
	private String roomPreference;

	
	
	public GuestData() {
		this.guestID = 0;
		this.firstNAme = "";
		this.lastName = "";
		this.dOB= null;
		this.country = "";
		this.state = "";
		this.city= "";
		this.postalCode = 0;
		this.checkInDate = null;
		this.checkOutDate= null;
		this.contact = 0;
		this.roomPreference= "";
	}
	
	public GuestData(int guestID, String firstNAme, String lastName, Date dOB,
			String country, String state, String city, int postalCode,
			Date checkInDate, Date checkOutDate, int contact, String roomPreference) {
		this.guestID = guestID;
		this.firstNAme = firstNAme;
		this.lastName = lastName;
		this.dOB= dOB;
		this.country = country;
		this.state = state;
		this.city= city;
		this.postalCode = postalCode;
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

	public String getFirstNAme() {
		return firstNAme;
	}

	public void setFirstNAme(String firstNAme) {
		this.firstNAme = firstNAme;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
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

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getRoomPreference() {
		return roomPreference;
	}

	public void setRoomPreference(String roomPreference) {
		this.roomPreference = roomPreference;
	}
	
	
}