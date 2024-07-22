import java.util.ArrayList;

public class ReservationModel {
	private ArrayList<Reservation> reservationList;

	public ReservationModel() {
		this.reservationList = new ArrayList<Reservation>();
	}

	public void addReservation(String name, String roomName, int checkIn, int checkOut, ArrayList<Room> roomList, Hotel hotel) {
		for (Room r : roomList) {
			if (r.getName().equals(roomName)) {
				Reservation reservation = new Reservation(name, checkIn, checkOut, r, hotel);
				// Add reservation to the list
				this.reservationList.add(reservation);
			}
		}
	}

	public void removeReservation(Reservation reservation) {
		this.reservationList.remove(reservation);
	}

	public ArrayList<Reservation> getReservationList() {
		return this.reservationList;
	}
}