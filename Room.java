public abstract class Room {
	private String name;
	public ReservationModel reservationModel;

	/**
	 * Constructor to initialize the room with a given name.
	 * Initializes the reservation model for the room.
	 *
	 * @param name the name of the room
	 */
	public Room(String name) {
		this.name = name;
		this.reservationModel = new ReservationModel();
	}

	/**
	 * Gets the name of the room.
	 *
	 * @return the name of the room
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Checks if the room is currently reserved.
	 *
	 * @return true if the reservation model has any reservations, false otherwise
	 */
	public boolean isReserved() {
		boolean value;

		if (this.reservationModel.getReservationList().isEmpty())
			value = false;
		else
			value = true;

		return value;
	}

	/**
	 * Checks if the room is available on a given date.
	 *
	 * @param date the date to check availability for
	 * @return true if the room is available on the given date, false otherwise
	 */
	public boolean isAvailable(int date) {
		for (Reservation r : this.reservationModel.getReservationList()) {
			for (Day d : r.getDayList()) {
				if (d.getDay() == date) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Abstract method to get the price of the room.
	 * Must be implemented by subclasses to return the specific price of the room.
	 *
	 * @return the price of the room
	 */
	public abstract double getPrice();
}