package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


import Helper.DatabaseConnector;
import Models.GuestData;
import Models.Reservation;

public class GuestDatabaseLayer {

	private GuestData guest;
	private DatabaseConnector db;
	private Connection connection;
	public static int guestPrimeKey;
	
	public GuestDatabaseLayer() {
		this.guest = new GuestData();
	}
	
	public GuestDatabaseLayer(GuestData guest) throws Exception {
		this.guest = guest;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public GuestData getGuestData() {
		return guest;
	}

	public void setGuestData(GuestData guest) {
		this.guest = guest;
	}
	
	
	//guest login method
	
	
	
	public GuestData guestSave() throws Exception {
		
		
			PreparedStatement statement;
			ResultSet rs;
			String guestDetailQuery = "INSERT INTO Guest (fullName, dOb, contact, "
					+ "roomPreference, country, state, city, "
					+ "checkInDate, checkOutDate, cusID) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			
				String[] guestID = new String[] { "id" };  
			
				statement = this.connection.prepareStatement(guestDetailQuery, guestID);
				statement.setString(1, this.guest.getFullName());
				statement.setString(2, this.guest.getdOB());
				statement.setString(3, this.guest.getContact());
				statement.setString(4, this.guest.getRoomPreference());
				statement.setString(5, this.guest.getCountry());
				statement.setString(6, this.guest.getState());
				statement.setString(7, this.guest.getCity());
				statement.setString(8, this.guest.getCheckInDate());
				statement.setString(9, this.guest.getCheckOutDate());
				statement.setInt(10, UserDatabaseLayer.cusPrimeKey);
				
				try {
						if (statement.executeUpdate() !=0) {
							ResultSet generatedKeys = statement.getGeneratedKeys();
							 if ( generatedKeys.next() ) {
					                guestPrimeKey = generatedKeys.getInt(1);
					         }
						}
					}
			
				catch (Exception ex) {
					throw ex;
				}
				
		}catch (Exception ex) {
			throw ex;
		}
		return guest;
	}
	
}

	
