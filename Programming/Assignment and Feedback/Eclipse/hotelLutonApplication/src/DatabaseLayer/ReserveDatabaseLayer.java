package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


import Helper.DatabaseConnector;
import Models.Reservation;

public class ReserveDatabaseLayer {

	public static int reservePrimkey = 0;
	private Reservation reserve;
	private DatabaseConnector db;
	private Connection connection;
	
	public ReserveDatabaseLayer() {
		this.reserve = new Reservation();
	}
	
	public ReserveDatabaseLayer(Reservation reserve) throws Exception {
		this.reserve = reserve;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Reservation getReservation() {
		return reserve;
	}

	public void setRegistration(Reservation reserve) {
		this.reserve = reserve;
	}
	
	
	//reserve login method
	
	
	
	public Reservation reserveSave() throws Exception {
		
		
			PreparedStatement statement;
			ResultSet rs;
			String reserveDetailQuery = "INSERT INTO Reservation (bookingStatus,  paymentStatus, cusID) VALUES (?,?,?)";
		try {
			
				String[] reserveID = new String[] { "id" };
				
				statement = connection.prepareStatement(reserveDetailQuery, reserveID);
				statement.setString(1, this.reserve.getBookingStatus());
				statement.setString(2, this.reserve.getPaymentStatus());
				statement.setInt(3, UserDatabaseLayer.cusPrimeKey);
				
				try {
					
					if (statement.executeUpdate() !=0) {
						JOptionPane.showMessageDialog(null, "Booking Request Send", "Request Send", 2);
						
						ResultSet generatedKeys = statement.getGeneratedKeys();
						 if ( generatedKeys.next() ) {
				                reservePrimkey = generatedKeys.getInt(1);
				         }
				}
					else {
						JOptionPane.showMessageDialog(null, "Please Check Your Information", "Request Error", 2);
					}
			
				} catch (Exception ex) {
					throw ex;
				}
		
		
		} catch (Exception ex) {
			throw ex;
		}
	
		return reserve;
}}

	
