import java.util.ArrayList;

public class HotelModel {

	private ArrayList<Hotel> hotelList;

	/**
	 * Default constructor.
	 * Initializes the hotel model with an empty list of hotels.
	 */
	public HotelModel() {
		this.hotelList = new ArrayList<Hotel>();
	}

	/**
	 * Adds a new hotel to the model with the given name.
	 *
	 * @param name the name of the hotel to add
	 */
	public void addHotel(String name) {
		Hotel hotel = new Hotel(name);
		this.hotelList.add(hotel);
	}

	/**
	 * Removes a hotel from the model by name.
	 *
	 * @param name the name of the hotel to remove
	 */
	public void removeHotel(String name) {
		for (int i = 0; i < this.hotelList.size(); i++)
			if (hotelList.get(i).getName().equals(name)) {
				this.hotelList.remove(i);
				break;
			}
	}

	/**
	 * Gets the list of hotels in the model.
	 *
	 * @return the list of hotels
	 */
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}
}