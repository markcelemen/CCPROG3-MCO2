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
		for (Reservation r : this.reservationModel.getReservationList()) {
			for (Day d : r.getDayList()) {
				if (d.getDay() == date) {
					return false;
				}
			}
		}

		return true;
	}

	// abstract method to be implemented by subclasses
	public abstract double getPrice();
}