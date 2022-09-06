package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Helper.DatabaseConnector;
import Models.DefultModel;


public class BookingDetailsDatabaseLayer {

	private DefultModel defultModel;
	private DatabaseConnector db;
	private Connection connection;
	
	public BookingDetailsDatabaseLayer() {
		this.defultModel = new DefultModel();
	}
	
	public BookingDetailsDatabaseLayer(DefultModel defultModel) throws Exception {
		this.defultModel = defultModel;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}

	public void setDefultModel(DefultModel defultModel) {
		this.defultModel = defultModel;
	}

	
	public ArrayList<DefultModel> loadUserDetails() throws Exception {
		try {
			ArrayList<DefultModel> defultModel = new ArrayList<DefultModel>();
			String query = "SELECT r.reserveID , g.fullName , c.companyName, c.companyContact,  "
					+ "cc.cardNo , g.roomPreference , g.country ,g.checkInDate ,"
					+ "g.checkOutDate, r.bookingStatus , r.roomNo FROM Reservation r "
					+ "LEFT JOIN Customer c2  ON c2.cusID = r.cusID "
					+ "LEFT JOIN Corporate c ON r.cusID = c.cusID "
					+ "LEFT JOIN CreditCard cc ON cc.cusID = r.reserveID "
					+ "LEFT JOIN Guest g ON g.guestID = r.reserveID  "
					+ "GROUP BY r.reserveID";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				
				
				DefultModel dM = new DefultModel();
				dM.setBookingID(rs.getString("reserveID"));
				dM.setName(rs.getString("fullName"));
				dM.setCorpName(rs.getString("companyName"));
				dM.setCorpContact(rs.getString("companyContact"));
				dM.setCardNumber(rs.getString("cardNo"));
				dM.setRoomPreference(rs.getString("roomPreference"));
				dM.setCountry(rs.getString("country"));
				dM.setCheckInDate(rs.getString("checkInDate"));
				dM.setCheckOutDate(rs.getString("checkOutDate"));
				dM.setBookingStatus(rs.getString("bookingStatus"));
				dM.setRoomNo(rs.getString("roomNo"));
				
				defultModel.add(dM);
			}
			
			return defultModel;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<DefultModel> getAllUserBooking() throws Exception {
		try {
			ArrayList<DefultModel> defultModel = new ArrayList<DefultModel>();
			String query = "SELECT r.reserveID , g.fullName , cc.cardNo , g.roomPreference ,"
					+ "g.checkInDate , g.checkOutDate , r.bookingStatus , r.roomNo , b.paymentStatus "
					+ "FROM Reservation r LEFT JOIN Guest g ON r.reserveID = g.guestID "
					+ "LEFT JOIN CreditCard cc ON cc.cusID = r.cusID "
					+ "LEFT JOIN Billing b  ON b.reserveID = r.reserveID "
					+ "LEFT JOIN Customer c ON c.cusID = r.cusID WHERE c.cusID = ? GROUP BY r.reserveID";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, UserDatabaseLayer.cusPrimeKey);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				
				DefultModel dM = new DefultModel();
				dM.setBookingID(rs.getString("reserveID"));
				dM.setName(rs.getString("fullName"));
				dM.setCardNumber(rs.getString("cardNo"));
				dM.setRoomPreference(rs.getString("roomPreference"));
				dM.setCheckInDate(rs.getString("checkInDate"));
				dM.setCheckOutDate(rs.getString("checkOutDate"));
				dM.setBookingStatus(rs.getString("bookingStatus"));
				dM.setRoomNo(rs.getString("roomNo"));
				dM.setPaymentStatus(rs.getString("paymentStatus"));
				
				defultModel.add(dM);
			}
			
			return defultModel;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}