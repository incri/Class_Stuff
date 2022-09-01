package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Helper.DatabaseConnector;
import Models.Room;
import Models.Users;
import FrontendLayer.AdminPage;
import FrontendLayer.LogInBox;

import FrontendLayer.UserHomePage;

public class RoomDatabaseLayer {

	public static int primkey = 0;
	private Room room;
	private DatabaseConnector db;
	private Connection connection;
	
	public RoomDatabaseLayer() {
		this.room = new Room();
	}
	
	public RoomDatabaseLayer(Room room) throws Exception {
		this.room = room;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	//room login method
	
	
	
	
	public Room roomSave() throws Exception {
		
		
			PreparedStatement statement;
			ResultSet rs;
			String registerRoomQuery = "INSERT INTO Room (roomType, pricePerNight, roomDetails, roomStatus) VALUES (?,?,?,?)";
		try {
			
				String[] roomID = new String[] { "id" };
				
				statement = this.connection.prepareStatement(registerRoomQuery, roomID);
				statement.setObject(1, this.room.getRoomType());
				statement.setString(2, this.room.getPricePerNight());
				statement.setString(3, this.room.getRoomDetails());
				statement.setObject(4, this.room.getRoomStatus());
				
				
				try {
					
					if (statement.executeUpdate() !=0) {
						
						ResultSet generatedKeys = statement.getGeneratedKeys();
						 if ( generatedKeys.next() ) {
				                primkey = generatedKeys.getInt(1);
				            }
						JOptionPane.showMessageDialog(null, "Room has been added");
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "Please Check Your Information");
					}
			
				} catch (Exception ex) {
					throw ex;
				}
		
		
		} catch (Exception ex) {
			throw ex;
		}
	
			return room;
	}
	public ArrayList<Room> loadRoom() throws Exception {
		try {
			ArrayList<Room> room = new ArrayList<Room>();
			String query = "SELECT * FROM Room ORDER BY roomNo";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Room r = new Room();
				r.setRoomNo(rs.getInt("roomNo"));
				r.setRoomType(rs.getObject("roomtype"));
				r.setPricePerNight(rs.getString("pricePerNight"));
				r.setRoomDetails(rs.getString("roomDetails"));
				r.setRoomStatus(rs.getObject("roomStatus"));
				room.add(r);
			}
			return room;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}