import java.util.ArrayList;

public class HotelModel {

	private ArrayList<Hotel> hotelList;

	public HotelModel() {
		this.hotelList = new ArrayList<Hotel>();
	}

	public void addHotel(String name) {
		Hotel hotel = new Hotel(name);
		this.hotelList.add(hotel);
	}

	public void removeHotel(String name) {
		for (int i = 0; i < this.hotelList.size(); i++)
			if (hotelList.get(i).getName().equals(name)) {
				this.hotelList.remove(i);
				break;
			}
	}

	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}
}