package ServiceLayer;

import DatabaseLayer.CreditCardDatabaseLayer;
import Helper.InputException;
import Models.CreditCard;


public class CreditServiceLayer {
	CreditCard credit;
	
	public CreditServiceLayer() {
		this.credit = new CreditCard();
	}

	public CreditCard getCreditCard() {
		return credit;
	}

	
public boolean validateCreditDetails(CreditCard credit) throws InputException {
	
		if(credit.getCardType() == null || credit.getCardType().length() == 0) {
			throw new InputException("Card Type cannot be empty.");
		}

		if(credit.getNameOnCard() == null || credit.getNameOnCard().length() == 0) {
			throw new InputException("Please enter your name used on card.");
		}
		if(!(credit.getNameOnCard()).matches("^[a-zA-Z\\s]*$") ) {
			throw new InputException("Cannot input number on  name");
		}
		if(credit.getCardNo() == null || credit.getCardNo().length() == 0) {
			throw new InputException("Credit Card Number canot be empty.");
		}
		if(!(credit.getCardNo()).matches("^[0-9, ]+$") ) {
			throw new InputException("cannot input alphabet on contact");
		}


		return true;
	}
	
	
	
	
	public CreditCard creditSave(CreditCard credit) throws Exception {
		try {
			CreditCardDatabaseLayer creditDatabaseLayer = new CreditCardDatabaseLayer(credit);
			return creditDatabaseLayer.creditSave();
		}catch(Exception e) {
			throw e;
		}
		
	}

}