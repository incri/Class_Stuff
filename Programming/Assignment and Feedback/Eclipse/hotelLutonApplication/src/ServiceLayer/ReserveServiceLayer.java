package ServiceLayer;

import DatabaseLayer.ReserveDatabaseLayer;
import Models.Reservation;


public class ReserveServiceLayer {
	Reservation reserve;
	
	public ReserveServiceLayer() {
		this.reserve = new Reservation();
	}

	public Reservation getReservation() {
		return reserve;
	}
	
	public Reservation reservationSave(Reservation reserve) throws Exception {
		try {
			ReserveDatabaseLayer reserveDL = new ReserveDatabaseLayer(reserve);
			return reserveDL.reserveSave();
		}catch(Exception e) {
			throw e;
		}
		
	}
}

