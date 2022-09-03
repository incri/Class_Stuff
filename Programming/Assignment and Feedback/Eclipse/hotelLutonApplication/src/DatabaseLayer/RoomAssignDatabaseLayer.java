package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Helper.DatabaseConnector;
import Models.DefultModel;

public class RoomAssignDatabaseLayer {

	private DefultModel defultModel;
	private DatabaseConnector db;
	private Connection connection;
	
	public RoomAssignDatabaseLayer() {
		this.defultModel = new DefultModel();
	}
	
	public RoomAssignDatabaseLayer(DefultModel defultModel) throws Exception {
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
	
	
	//room login method
	
	
	
	
	public DefultModel roomAssign() throws Exception {
		
		
			PreparedStatement updateRoomStatement;
			PreparedStatement updateStatusStatement;
			ResultSet irs;
			ResultSet urs;
			
			
		try {
			String inserRoomNoQuery = "UPDATE Reservation r SET r.roomNo = ? WHERE r.reserveID = ?";
			updateRoomStatement = this.connection.prepareStatement(inserRoomNoQuery);
			updateRoomStatement.setString(1, this.defultModel.getRoomNo());
			updateRoomStatement.setString(2, this.defultModel.getBookingID());
			
			String updateStatusQuery = "UPDATE Reservation r INNER JOIN Room ro ON r.roomNo = ro.roomNo SET"
					+ " r.bookingStatus = 'Approved', ro.roomStatus = 'Booked'  WHERE reserveID = ?";
			updateStatusStatement = this.connection.prepareStatement(updateStatusQuery);
			updateStatusStatement.setString(1, this.defultModel.getBookingID());
				try {
					
					updateRoomStatement.executeUpdate();
					updateStatusStatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Room Assigned", "Complete", 2);
					
					
				} catch (Exception ex) {
					throw ex;
				}
		
		
		} catch (Exception ex) {
			throw ex;
		}
	
			return defultModel;
	}

}