package ServiceLayer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	public DefultModel deleteBooking(DefultModel defultmodel) throws Exception {
		// This function saves the user detail to database and returns the user object after saving
		try {

			BookingDetailsDatabaseLayer dlDetailsBooking = new BookingDetailsDatabaseLayer(defultModel);
			dlDetailsBooking.deleteBooking(defultmodel);
		} catch (Exception e) {
			throw e;
		}
		return defultmodel;
	}
}
