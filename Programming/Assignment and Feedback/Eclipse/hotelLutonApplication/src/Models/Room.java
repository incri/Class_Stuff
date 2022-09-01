package Models;



public class Room {
	private int roomNo;
	private Object roomType;
	private String pricePerNight;
	private String roomDetails;
	private Object roomStatus;
	
	public Room() {
		this.roomNo = 0;
		this.roomType = "";
		this.pricePerNight = "";
		this.roomDetails = "";
		this.roomStatus ="";
	}
	
	public Room(int roomNo, Object roomType, String pricePerNight, String roomDetails, Object roomStatus) {
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

	public Object getRoomType() {
		return roomType;
	}

	public void setRoomType(Object object) {
		this.roomType = object;
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

	public Object getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(Object object) {
		this.roomStatus = object;
	}
	
	
	
}