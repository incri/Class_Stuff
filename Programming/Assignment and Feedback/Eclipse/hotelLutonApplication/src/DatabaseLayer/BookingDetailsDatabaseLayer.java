package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Helper.DatabaseConnector;
import Models.DefultModel;


public class BookingDetailsDatabaseLayer {

	private DefultModel defultModel;
	private DatabaseConnector db;
	private Connection connection;
	
	
	public BookingDetailsDatabaseLayer() {
		this.defultModel = new DefultModel();
	}
	
	public BookingDetailsDatabaseLayer(DefultModel defultModel) throws Exception {
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

	
	public ArrayList<DefultModel> loadUserDetails() throws Exception {
		try {
			ArrayList<DefultModel> defultModel = new ArrayList<DefultModel>();
			String query = "SELECT c.cusID , c2.corpID , CONCAT(c.firstName,\" \" ,c.lastName) AS Name, g.roomPreference , r.roomNo , cc.cardNo  FROM Customer c LEFT JOIN Corporate c2 ON c.cusID =c2.cusID  LEFT JOIN Guest g ON c.cusID  = g.cusID  LEFT JOIN Reservation r ON c.cusID = r.cusID  LEFT JOIN CreditCard cc ON c.cusID = cc.cusID ;\n";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				DefultModel dM = new DefultModel();
				dM.setCusID(rs.getString("cusID"));
				dM.setCorpID(rs.getString("corpID"));
				dM.setName(rs.getString("name"));
				dM.setRoomPreference(rs.getString("roomPreference"));
				dM.setRoomNo(rs.getString("roomNo"));
				dM.setCardNumber(rs.getString("cardNo"));
				defultModel.add(dM);
			}
			return defultModel;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}