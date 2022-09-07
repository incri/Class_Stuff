package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import FrontendLayer.AdminPage;

import FrontendLayer.UserHomePage;
import Helper.DatabaseConnector;
import Models.DefultModel;
import Models.Users;


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
			String query = "SELECT r.reserveID , g.fullName , g.contact , r.roomNo ,"
					+ "r2.pricePerNight , b.totalBill , b.paymentStatus  "
					+ "FROM Reservation r LEFT JOIN Guest g  ON r.reserveID  = g.guestID "
					+ "LEFT JOIN Room r2 ON r2.roomNo = r.roomNo  "
					+ "LEFT JOIN Billing b ON b.reserveID = r.reserveID GROUP BY r.reserveID ";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				DefultModel dM = new DefultModel();
				dM.setBookingID(rs.getInt("reserveID"));
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
	
public DefultModel generateBill() throws Exception {
		
		PreparedStatement billStatement;
		ResultSet brs;
		
		
		//getting email and password from the login page
		
		// query to check if the username and password exist in data base or not
		
		String billQuery = "SELECT * FROM Reservation r INNER JOIN Customer c  ON r.cusID = c.cusID WHERE r.reserveID = ? AND c.cusID = ?";
		
		try {
			
			billStatement = this.connection.prepareStatement(billQuery);
			billStatement.setInt(1, this.defultModel.getBookingID());
			billStatement.setInt(2, UserDatabaseLayer.cusPrimeKey);
			
			brs = billStatement.executeQuery();
			
			//condition if the username and password match
			if (brs.next())
			{
				
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Please check your booking ID", "Failed", 2);
			}
			
			
		}catch(Exception ex) {
			throw ex;
		}
		
		
		return defultModel;
	}
}