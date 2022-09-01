package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


import Helper.DatabaseConnector;
import Models.CreditCard;
import Models.Customer;
import Models.Users;

public class CreditCardDatabaseLayer {

	public static int creditPrimkey = 0;
	private CreditCard credit;
	private DatabaseConnector db;
	private Connection connection;
	
	public CreditCardDatabaseLayer() {
		this.credit = new CreditCard();
	}
	
	public CreditCardDatabaseLayer(CreditCard credit) throws Exception {
		this.credit = credit;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public CreditCard getCreditCard() {
		return credit;
	}

	public void setCreditCard(CreditCard credit) {
		this.credit = credit;
	}
	
	
	//credit login method
	
	
	
	public CreditCard creditSave() throws Exception {
		
		
			PreparedStatement statement;
			ResultSet rs;
			String creditDetailQuery = "INSERT INTO CreditCard (cardType,nameOnCard, cardNo, cusID) VALUES (?,?,?,?)";
		try {
			
				String[] creditID = new String[] { "id" };
				
				statement = this.connection.prepareStatement(creditDetailQuery, creditID);
				statement.setString(1, this.credit.getCardType());
				statement.setString(2, this.credit.getNameOnCard());
				statement.setString(3, this.credit.getCardNo());
				statement.setInt(4, UserDatabaseLayer.cusPrimeKey);
				
				try {
					
					if (statement.executeUpdate() !=0) {
						
						ResultSet generatedKeys = statement.getGeneratedKeys();
						 if ( generatedKeys.next() ) {
				                creditPrimkey = generatedKeys.getInt(1);
				         }
				}
			
				} catch (Exception ex) {
					throw ex;
				}
		
		
		} catch (Exception ex) {
			throw ex;
		}
	
		return credit;
}}

	
