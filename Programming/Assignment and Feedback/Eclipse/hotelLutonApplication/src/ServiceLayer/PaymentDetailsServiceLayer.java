package ServiceLayer;

import java.util.ArrayList;

import DatabaseLayer.PaymentDetailsDatabaseLayer;
import Models.DefultModel;


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
}
