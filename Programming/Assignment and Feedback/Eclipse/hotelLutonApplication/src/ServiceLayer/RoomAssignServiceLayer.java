package ServiceLayer;


import Models.DefultModel;
import DatabaseLayer.RoomAssignDatabaseLayer;
import DatabaseLayer.RoomDatabaseLayer;

public class RoomAssignServiceLayer {
	DefultModel defultModel;
	
	public RoomAssignServiceLayer() {
		this.defultModel = new DefultModel();
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}
	
	


	
	public DefultModel roomAssign(DefultModel defultModel) throws Exception {
		try {
			RoomAssignDatabaseLayer roomAssignDL = new RoomAssignDatabaseLayer(defultModel);
			return roomAssignDL.roomAssign();
		}catch(Exception e) {
			throw e;
		}
		
	}

}
	
	
	