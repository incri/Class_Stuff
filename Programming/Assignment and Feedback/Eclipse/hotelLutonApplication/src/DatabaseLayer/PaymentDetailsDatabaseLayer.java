package DatabaseLayer;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Helper.DatabaseConnector;
import Models.DefultModel;


public class PaymentDetailsDatabaseLayer {

	private DefultModel defultModel;
	private DatabaseConnector db;
	private Connection connection;
	
	
	public PaymentDetailsDatabaseLayer() {
		this.defultModel = new DefultModel();
	}
	
	public PaymentDetailsDatabaseLayer(DefultModel defultModel) throws Exception {
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

	
	public ArrayList<DefultModel> loadPaymentDetails() throws Exception {
		try {
			ArrayList<DefultModel> defultModel = new ArrayList<DefultModel>();
			String query = "SELECT r.reserveID, g.fullName, g.contact, r.roomNo, "
					+ "r2.pricePerNight, "
					+ "(DATEDIFF(g.checkOutDate ,g.checkInDate) * r2.pricePerNight) AS TotalBill, "
					+ "r.paymentStatus FROM Reservation r LEFT JOIN Guest g ON r.cusID = g.cusID "
					+ "LEFT JOIN Room r2 ON r2.roomNo  = r.roomNo  GROUP BY r.reserveID  ";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				DefultModel dM = new DefultModel();
				dM.setBookingID(rs.getString("reserveID"));
				dM.setGuestName(rs.getString("fullName"));
				dM.setContact(rs.getString("contact"));
				dM.setRoomNo(rs.getString("roomNo"));
				dM.setPricePerNight(rs.getString("pricePerNight"));
				dM.setTotalBill(rs.getString("totalBill"));
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