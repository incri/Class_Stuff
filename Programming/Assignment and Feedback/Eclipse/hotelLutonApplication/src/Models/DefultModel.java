package Models;

public class DefultModel {
	private String userID;
	private String cusID;
	private String roomNo;
	private static int bookingID;
	private String corpID;
	private static int guestID;
	private static int reserveID;
	private static int billID;
	
	
	private String email;
	private String name;
	private String corpName;
	private String corpContact;
	private String guestName;
	private String contact;
	private String roomPreference;
	private String country;
	private String checkInDate;
	private String checkOutDate;
	private String cardType;
	private String cardNumber;
	private String nameOnCard;
	private String bookingStatus;
	private String paymentStatus;
	private String totalBill;
	
	
	
	public DefultModel() {
	
		this.userID = "";
		this.cusID = "";
		this.roomNo = "";
		DefultModel.bookingID = 0;
		this.corpID = "";
		DefultModel.guestID = 0;
		DefultModel.reserveID = 0;
		DefultModel.billID = 0;
		
		this.email =  "";
		this.name =  "";
		this.corpName =  "";
		this.corpContact =  "";
		this.guestName =  "";
		this.contact =  "";
		this.roomPreference =  "";
		this.country =  "";
		this.checkInDate =  "";
		this.checkOutDate =  "";
		this.cardType =  "";
		this.cardNumber =  "";
		this.nameOnCard =  "";
		this.bookingStatus =  "";
		this.paymentStatus =  "";
		this.totalBill =  "";
	}


	
	public DefultModel(String userID, String cusID,String roomNo,
			int bookingID, int guestID, int reserveID, int billID, String corpID,
			String email, String name, String corpName, String corpContact, String guestName, String contact,
			String roomPreference, String country, String checkInDate, String checkOutDate, String cardType,
			String cardNumber, String nameOncard, String bookingStatus, String paymentStatus, String totalBill, String nameOnCard ) {
		
		this.userID = userID;
		this.cusID = cusID;
		this.roomNo = roomNo;
		DefultModel.bookingID = bookingID;
		this.corpID = corpID;
		DefultModel.guestID = guestID;
		DefultModel.reserveID = reserveID;
		DefultModel.billID = billID;
		
		this.email = email;
		this.name = name;
		this.corpName = corpName;
		this.corpContact = corpContact ;
		this.guestName = guestName ;
		this.contact =  contact;
		this.roomPreference =  roomPreference;
		this.country =  country;
		this.checkInDate =  checkInDate;
		this.checkOutDate =  checkOutDate;
		this.cardType =  cardType;
		this.cardNumber =  cardNumber;
		this.nameOnCard =  nameOnCard;
		this.bookingStatus =  bookingStatus;
		this.paymentStatus =  paymentStatus;
		this.totalBill =  totalBill;
	}



	public  String getUserID() {
		return userID;
	}



	public void setUserID(String string) {
		this.userID = string;
	}



	public  String getCusID() {
		return cusID;
	}



	public  void setCusID(String cusID) {
		this.cusID = cusID;
	}



	public  String getRoomNo() {
		return roomNo;
	}



	public  void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}



	public static int getBookingID() {
		return bookingID;
	}



	public static void setBookingID(int bookingID) {
		DefultModel.bookingID = bookingID;
	}



	public  String getCorpID() {
		return corpID;
	}



	public  void setCorpID(String corpID) {
		this.corpID = corpID;
	}



	public static int getGuestID() {
		return guestID;
	}



	public static void setGuestID(int guestID) {
		DefultModel.guestID = guestID;
	}



	public static int getReserveID() {
		return reserveID;
	}



	public static void setReserveID(int reserveID) {
		DefultModel.reserveID = reserveID;
	}



	public static int getBillID() {
		return billID;
	}



	public static void setBillID(int billID) {
		DefultModel.billID = billID;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCorpName() {
		return corpName;
	}



	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}



	public String getCorpContact() {
		return corpContact;
	}



	public void setCorpContact(String corpContact) {
		this.corpContact = corpContact;
	}



	public String getGuestName() {
		return guestName;
	}



	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getRoomPreference() {
		return roomPreference;
	}



	public void setRoomPreference(String roomPreference) {
		this.roomPreference = roomPreference;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getCheckInDate() {
		return checkInDate;
	}



	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}



	public String getCheckOutDate() {
		return checkOutDate;
	}



	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}



	public String getCardType() {
		return cardType;
	}



	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	public String getNameOnCard() {
		return nameOnCard;
	}



	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}



	public String getBookingStatus() {
		return bookingStatus;
	}



	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}



	public String getPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	public String getTotalBill() {
		return totalBill;
	}



	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}

	 
}