import java.util.ArrayList;

public class Reservation {
	private String guestName;
	private int checkIn;
	private int checkOut;
	private ArrayList<Day> dayList;
	private Room room;
	private double price;
	private boolean redeemedCode = false;

	/**
	 * Constructor for creating a reservation.
	 *
	 * @param name the name of the guest
	 * @param checkIn the check-in date
	 * @param checkOut the check-out date
	 * @param room the room being reserved
	 * @param hotel the hotel where the reservation is made
	 */
	public Reservation(String name, int checkIn, int checkOut, Room room, Hotel hotel) {
		this.guestName = name;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.dayList = new ArrayList<Day>();
		for (int i = checkIn; i < checkOut; i++) // searches for the corresponding day and adds a new instance of that day with the same attributes
			this.dayList.add(new Day(hotel.getDayList().get(i - 1).getDay(), hotel.getDayList().get(i - 1).getRate()));
		this.room = room;
		this.price = 0.0;
		for (Day d : this.dayList)
			price += (this.room.getPrice() * d.getRate());
	}

	/**
	 * Gets the name of the guest.
	 *
	 * @return the name of the guest
	 */
	public String getGuestName() {
		return this.guestName;
	}

	/**
	 * Gets the check-in date.
	 *
	 * @return the check-in date
	 */
	public int getCheckIn() {
		return this.checkIn;
	}

	/**
	 * Gets the check-out date.
	 *
	 * @return the check-out date
	 */
	public int getCheckOut() {
		return this.checkOut;
	}

	/**
	 * Gets the list of days covered by the reservation.
	 *
	 * @return the list of days
	 */
	public ArrayList<Day> getDayList() {
		return this.dayList;
	}

	/**
	 * Gets the room associated with the reservation.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return this.room;
	}

	/**
	 * Gets the total price of the reservation.
	 *
	 * @return the total price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Checks if a promotional code has been redeemed for the reservation.
	 *
	 * @return true if the code has been redeemed, false otherwise
	 */
	public boolean getRedeemedCode() {
		return this.redeemedCode;
	}

	/**
	 * Sets the total price of the reservation.
	 *
	 * @param price the new total price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Sets whether a promotional code has been redeemed.
	 *
	 * @param val true if the code has been redeemed, false otherwise
	 */
	public void setRedeemedCode(boolean val) {
		this.redeemedCode = val;
	}
}