import java.util.ArrayList;

public class Hotel {
	private String name;
	public RoomModel roomModel;
	public ReservationModel reservationModel;
	private ArrayList<Day> dayList;
	private double costPerNight;
	private double earnings;

	public Hotel(String name) {
		this.name = name;
		this.costPerNight = 1299.0;
		this.earnings = 0.0;
		this.roomModel = new RoomModel();
		this.roomModel.addStandardRoom("101", this.costPerNight);
		this.reservationModel = new ReservationModel();
		this.dayList = new ArrayList<Day>();
		for (int i = 1; i <= 31; i++)
			this.dayList.add(new Day(i, 1.0));
	}

	public String getName() {
		return this.name;
	}

	public double getCostPerNight() {
		return this.costPerNight;
	}

	public double getEarnings() {
		this.earnings = 0.0;
		for (Reservation r : this.reservationModel.getReservationList())
		this.earnings += r.getPrice();
		return this.earnings;
	}

	public ArrayList<Day> getDayList() {
		return this.dayList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDayRate(int day, double rate) {
		for (Day d : this.dayList) {
			if (day == d.getDay()){
				d.setRate(rate);
				break;
			}
		}
	}

	public void setCostPerNight(double costPerNight) {
		this.costPerNight = costPerNight;
	}
}