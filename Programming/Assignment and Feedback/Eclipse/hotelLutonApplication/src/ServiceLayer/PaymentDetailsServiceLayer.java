package ServiceLayer;

import java.util.ArrayList;

import DatabaseLayer.PaymentDetailsDatabaseLayer;
import DatabaseLayer.UserDatabaseLayer;
import Models.DefultModel;
import Models.Users;


public class PaymentDetailsServiceLayer {
	DefultModel defultModel;
	
	public PaymentDetailsServiceLayer() {
		this.defultModel = new DefultModel();
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}
	
	public ArrayList<DefultModel> getAllPayment() throws Exception {
		try {
			PaymentDetailsDatabaseLayer paymentDetailsDL = new PaymentDetailsDatabaseLayer(this.defultModel);
			return paymentDetailsDL.loadPaymentDetails();
		}catch(Exception e) {
			throw e;
		}
	}
	public DefultModel generateBill() throws Exception {
		try {
			PaymentDetailsDatabaseLayer paymentDatabaseLayer = new PaymentDetailsDatabaseLayer(defultModel);
			return paymentDatabaseLayer.generateBill();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}