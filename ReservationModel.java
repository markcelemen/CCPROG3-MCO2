import java.util.ArrayList;

public class ReservationModel {
	private ArrayList<Reservation> reservationList;

	public ReservationModel() {
		this.reservationList = new ArrayList<Reservation>();
	}

	public ArrayList<Reservation> getReservationList() {
		return this.reservationList;
	}
}