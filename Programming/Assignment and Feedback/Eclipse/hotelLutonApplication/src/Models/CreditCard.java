package Models;

public class CreditCard {
	private int cardID;
	private String cardType;
	private String cardNo;
	private String nameOnCard;
	
	public CreditCard() {
		this.cardID = 0;
		this.cardType = "";
		this.cardNo = "";
		this.nameOnCard= "";
	}
	
	public CreditCard(int cardID, String cardType, String cardNo, String nameOnCard ) {
		this.cardID = cardID;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.nameOnCard = nameOnCard;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
}