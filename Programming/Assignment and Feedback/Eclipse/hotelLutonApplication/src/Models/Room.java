package Models;

public class Room {
	private int roomNo;
	private String roomType;
	private String pricePerNight;
	private String roomDetails;
	private String roomStatus;
	
	public Room() {
		this.roomNo = 0;
		this.roomType = "";
		this.pricePerNight = "";
		this.roomDetails = "";
		this.roomStatus ="";
	}
	
	public Room(int roomNo, String roomType, String pricePerNight, String roomDetails, String roomStatus) {
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.roomDetails = roomDetails;
		this.roomStatus = roomStatus;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(String pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public String getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(String roomDetails) {
		this.roomDetails = roomDetails;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	
}