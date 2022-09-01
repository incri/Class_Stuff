package ServiceLayer;


import Models.Room;

// This class uses the room model to receive and send data to the database layer
// This class uses the room model to receive data from the frontend layer
import Models.Users;

import java.util.ArrayList;


import DatabaseLayer.RoomDatabaseLayer;

public class RoomServiceLayer {
	Room room;
	
	public RoomServiceLayer() {
		this.room = new Room();
	}

	public Room getRoom() {
		return room;
	}


	
	public Room roomSave(Room room) throws Exception {
		try {
			RoomDatabaseLayer roomDatabaseLayer = new RoomDatabaseLayer(room);
			return roomDatabaseLayer.roomSave();
		}catch(Exception e) {
			throw e;
		}
		
	}
	public ArrayList<Room> getAllRoom() throws Exception {
		try {
			RoomDatabaseLayer roomDL = new RoomDatabaseLayer(this.room);
			return roomDL.loadRoom();
		}catch(Exception e) {
			throw e;
		}
	}
}
	
	
	