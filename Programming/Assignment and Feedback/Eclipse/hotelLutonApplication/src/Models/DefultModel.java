package Models;

public class DefultModel {
	private int userID;
	private String cusID;
	private String roomNo;
	private int bookingID;
	private String corpID;
	private String  guestID;
	private String  reserveID;
	private int  billID;
	
	
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
	private String pricePerNight;
	private String discountPer;
	
	
	
	public DefultModel() {
	
		this.userID = 0;
		this.cusID = "";
		this.roomNo = "";
		this.bookingID = 0;
		this.corpID = "";
		this.guestID = "";
		this.reserveID = "";
		this.billID = 0;
		
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
		this.pricePerNight =  "";
		this.discountPer = "";
	}


	
	public DefultModel(int userID, String cusID,String roomNo,
			int bookingID, String guestID, String reserveID, int billID, String corpID,
			String email, String name, String corpName, String corpContact, String guestName, String contact,
			String roomPreference, String country, String checkInDate, String checkOutDate, String cardType,
			String cardNumber, String nameOncard, String bookingStatus, String paymentStatus, String totalBill, String nameOnCard,String pricePerNight, String discountPer ) {
		
		this.userID = userID;
		this.cusID = cusID;
		this.roomNo = roomNo;
		this.bookingID = bookingID;
		this.corpID = corpID;
		this.guestID = guestID;
		this.reserveID = reserveID;
		this.billID = billID;
		
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
		this.pricePerNight =  pricePerNight;
		this.discountPer = discountPer;
	}



	public  int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
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



	public int getBookingID() {
		return bookingID;
	}



	public void setBookingID(int reserveID2) {
		this.bookingID = reserveID2;
	}



	public  String getCorpID() {
		return corpID;
	}



	public  void setCorpID(String corpID) {
		this.corpID = corpID;
	}



	public  String getGuestID() {
		return guestID;
	}



	public  void setGuestID(String guestID) {
		this.guestID = guestID;
	}



	public  String getReserveID() {
		return reserveID;
	}



	public  void setReserveID(String reserveID) {
		this.reserveID = reserveID;
	}



	public  int getBillID() {
		return billID;
	}



	public  void setBillID(int reserveID2) {
		this.billID = reserveID2;
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



	public String getPricePerNight() {
		return pricePerNight;
	}



	public void setPricePerNight(String pricePerNight) {
		this.pricePerNight = pricePerNight;
	}



	public String getDiscountPer() {
		return discountPer;
	}



	public void setDiscountPer(String discountPer) {
		this.discountPer = discountPer;
	}

	 
}