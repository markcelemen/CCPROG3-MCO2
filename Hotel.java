import java.util.ArrayList;

public class Hotel {
	private String name;
	public RoomModel roomModel;
	public ReservationModel reservationModel;
	private ArrayList<Day> dayList;
	private double costPerNight;
	private double earnings;

	/**
	 * Constructs a Hotel object with the specified name.
	 * Initializes the hotel with default cost per night, earnings, room model, reservation model,
	 * and a list of days with default rates.
	 *
	 * @param name the name of the hotel
	 */
	public Hotel(String name) {
		this.name = name;
		this.costPerNight = 1299.0;
		this.earnings = 0.0;
		this.roomModel = new RoomModel();
		this.roomModel.addStandardRoom("101", this);
		this.reservationModel = new ReservationModel();
		this.dayList = new ArrayList<Day>();
		for (int i = 1; i <= 31; i++)
			this.dayList.add(new Day(i, 1.0));
	}

	/**
	 * Gets the name of the hotel.
	 *
	 * @return the name of the hotel
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the cost per night for staying at the hotel.
	 *
	 * @return the cost per night
	 */
	public double getCostPerNight() {
		return this.costPerNight;
	}

	/**
	 * Gets the total earnings from reservations.
	 *
	 * @return the total earnings
	 */
	public double getEarnings() {
		this.earnings = 0.0;
		for (Reservation r : this.reservationModel.getReservationList())
			this.earnings += r.getPrice();
		return this.earnings;
	}

	/**
	 * Gets the list of days with their rates.
	 *
	 * @return the list of days
	 */
	public ArrayList<Day> getDayList() {
		return this.dayList;
	}

	/**
	 * Sets the name of the hotel.
	 *
	 * @param name the new name of the hotel
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the rate for a specific day.
	 *
	 * @param day the day to set the rate for
	 * @param rate the new rate for the day
	 */
	public void setDayRate(int day, double rate) {
		for (Day d : this.dayList) {
			if (day == d.getDay()){
				d.setRate(rate);
				break;
			}
		}
	}

	/**
	 * Sets the cost per night for staying at the hotel.
	 *
	 * @param costPerNight the new cost per night
	 */
	public void setCostPerNight(double costPerNight) {
		this.costPerNight = costPerNight;
	}
}