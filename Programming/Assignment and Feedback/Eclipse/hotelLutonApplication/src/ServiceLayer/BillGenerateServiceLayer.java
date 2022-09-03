package ServiceLayer;


import Models.DefultModel;
import DatabaseLayer.BillGenerateDatabaseLayer;
import DatabaseLayer.RoomAssignDatabaseLayer;
import DatabaseLayer.RoomDatabaseLayer;

public class BillGenerateServiceLayer {
	DefultModel defultModel;
	
	public BillGenerateServiceLayer() {
		this.defultModel = new DefultModel();
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}


	
	public DefultModel generateBill(DefultModel defultModel) throws Exception {
		try {
			BillGenerateDatabaseLayer generateBillDL = new BillGenerateDatabaseLayer(defultModel);
			return generateBillDL.generateBill();
		}catch(Exception e) {
			throw e;
		}
		
	}

}
	
	
	