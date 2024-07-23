public abstract class Room {
	private String name;
	public ReservationModel reservationModel;

	public Room(String name) {
		this.name = name;
		this.reservationModel = new ReservationModel();
	}

	public String getName() {
		return this.name;
	}

	public boolean isReserved() {
		boolean value;

		if (this.reservationModel.getReservationList().isEmpty())
		value = false;
		else
		value = true;

		return value;
	}

	public boolean isAvailable(int date) {
		boolean value = false;
		/*
		* - checks if the room is available during the given date
		* - since a check in date can be on the same day as a check out date of another
		* reservation,
		* the room is not available on that date anymore if it has a check in date and
		* a check out date
		*/
		for (Reservation r : this.reservationModel.getReservationList()) {
			if (date >= r.getCheckOut()) {
				for (Reservation i : this.reservationModel.getReservationList())
				if (date + 1 <= i.getCheckIn()) {
					value = true;
					break;
				}
				break;
			}
			if (date <= r.getCheckIn()) {
				for (Reservation i : this.reservationModel.getReservationList())
				if (date - 1 >= i.getCheckOut()) {
					value = true;
					break;
				}
				break;
			}
		}

		return value;
	}

	// abstract method to be implemented by subclasses
	public abstract double getPrice();
}