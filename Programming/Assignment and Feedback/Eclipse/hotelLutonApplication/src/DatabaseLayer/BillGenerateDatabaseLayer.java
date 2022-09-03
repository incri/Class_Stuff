package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import FrontendLayer.BookingDetailsTable;
import Helper.DatabaseConnector;
import Models.DefultModel;

public class BillGenerateDatabaseLayer {

	private DefultModel defultModel;
	private DatabaseConnector db;
	private Connection connection;
	private String toPayDate;
	private String totalBill;
	private String cardNo;
	private String paymentStatus;
	
	public BillGenerateDatabaseLayer() {
		this.defultModel = new DefultModel();
	}
	
	public BillGenerateDatabaseLayer(DefultModel defultModel) throws Exception {
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
	

	
	public DefultModel generateBill() throws Exception {
		
			PreparedStatement gettingDataStatement;
			PreparedStatement billInserStatement;
			PreparedStatement discountUpdatestatement;
			ResultSet grs;
			
			
			
		try {
			String selectBillQuery = "SELECT g.checkOutDate As toPayDate, (DATEDIFF(g.checkOutDate ,g.checkInDate) * r2.pricePerNight) AS TotalBill, cc.cardNo , r.paymentStatus FROM Reservation r LEFT JOIN Guest g ON r.cusID = g.cusID LEFT JOIN Room r2 ON r2.roomNo  = r.roomNo LEFT JOIN CreditCard cc ON cc.cusID = r.cusID";
			gettingDataStatement = this.connection.prepareStatement(selectBillQuery);
			grs = gettingDataStatement.executeQuery();
			
			if (grs.next()) {
				toPayDate = grs.getString(1);
				totalBill = grs.getString(2);
				cardNo = grs.getString(3);
				paymentStatus = grs.getString(4);
			}
			
			
			String insertBillQuery = "INSERT INTO Billing (toPayDate, totalBill, reserveID, cardNo, paymentStatus, discountPer) VALUES (?,?,?,?,?,?)";
			billInserStatement = this.connection.prepareStatement(insertBillQuery);
			billInserStatement.setString(1, toPayDate);
			billInserStatement.setString(2, totalBill);
			billInserStatement.setString(3, this.defultModel.getBookingID());
			billInserStatement.setString(4, cardNo);
			billInserStatement.setString(5, paymentStatus);
			billInserStatement.setString(6, this.defultModel.getDiscountPer());
			
			
			
			String updateBillQuery = "UPDATE Billing b LEFT JOIN Reservation r ON b.reserveID = r.reserveID  LEFT JOIN Corporate c ON c.cusID = r.cusID SET b.totalBill = (b.totalBill -(b.totalBill * b.discountPer)/100) WHERE c.corpID != 0 AND r.reserveID = ?";
			
			discountUpdatestatement = this.connection.prepareStatement(updateBillQuery);
			discountUpdatestatement.setString(1, this.defultModel.getBookingID());
			
				try {
					
					
	
					
					billInserStatement.executeUpdate();
					discountUpdatestatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Bill Generated", "Complete", 2);
					
					
				} catch (Exception ex) {
					throw ex;
				}
		
		
		} catch (Exception ex) {
			throw ex;
		}
	
			return defultModel;
	}

}