package ServiceLayer;

import java.util.ArrayList;

import DatabaseLayer.BookingDetailsDatabaseLayer;
import DatabaseLayer.UserDetailsDatabaseLayer;
import Models.DefultModel;


public class BookingDetailsServiceLayer {
	DefultModel defultModel;
	
	public BookingDetailsServiceLayer() {
		this.defultModel = new DefultModel();
	}

	public DefultModel getDefultModel() {
		return defultModel;
	}
	
	public ArrayList<DefultModel> getAllBooking() throws Exception {
		try {
			BookingDetailsDatabaseLayer bookingDetailsDL = new BookingDetailsDatabaseLayer(this.defultModel);
			return bookingDetailsDL.loadUserDetails();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<DefultModel> getAllUserBooking() throws Exception {
		try {
			BookingDetailsDatabaseLayer bookingDetailsDL = new BookingDetailsDatabaseLayer(this.defultModel);
			return bookingDetailsDL.getAllUserBooking();
		}catch(Exception e) {
			throw e;
		}
	}
}
