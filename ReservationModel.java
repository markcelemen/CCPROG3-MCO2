import java.util.ArrayList;

public class ReservationModel {
	private ArrayList<Reservation> reservationList;

	/**
	 * Default constructor.
	 * Initializes the reservation model with an empty list of reservations.
	 */
	public ReservationModel() {
		this.reservationList = new ArrayList<Reservation>();
	}

	/**
	 * Gets the list of reservations in the model.
	 *
	 * @return the list of reservations
	 */
	public ArrayList<Reservation> getReservationList() {
		return this.reservationList;
	}
}