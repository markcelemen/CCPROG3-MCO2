import java.util.ArrayList;

public class Reservation {
	private String guestName;
	private int checkIn;
	private int checkOut;
	private ArrayList<Day> dayList;
	private Room room;
	private double price;
	private boolean redeemedCode = false;

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

	public String getGuestName() {
	  	return this.guestName;
	}

	public int getCheckIn() {
	  	return this.checkIn;
	}

	public int getCheckOut() {
	 	 return this.checkOut;
	}

	public ArrayList<Day> getDayList() {
		return this.dayList;
	}

	public Room getRoom() {
	  	return this.room;
	}

	public double getPrice() {
	  	return this.price;
	}

	public boolean getRedeemedCode() {
		return this.redeemedCode;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRedeemedCode(boolean val) {
		this.redeemedCode = val;
	}
}