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
			String query = "SELECT r.reserveID ,CONCAT(c.firstName,\" \" ,c.lastName) AS Name, "
					+ "c2.companyName ,c2.companyContact ,cc.cardNo ,g.roomPreference ,"
					+ "g.country ,g.checkInDate ,g.checkOutDate ,r.bookingStatus ,r.roomNo  "
					+ "FROM Customer c LEFT JOIN Corporate c2 ON c.cusID = c2.cusID  "
					+ "LEFT JOIN Guest g ON c.cusID = g.cusID  "
					+ "LEFT JOIN Reservation r ON c.cusID = r.cusID  "
					+ "LEFT JOIN CreditCard cc ON c.cusID = cc.cusID "
					+ "GROUP BY r.reserveID ORDER BY c.cusID ";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				
				
				DefultModel dM = new DefultModel();
				dM.setBookingID(rs.getString("reserveID"));
				dM.setName(rs.getString("name"));
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
}