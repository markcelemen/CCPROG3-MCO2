import java.util.ArrayList;

public class RoomModel {
	private ArrayList<Room> roomList;

	/**
	 * Default constructor.
	 * Initializes the RoomModel with an empty list of rooms.
	 */
	public RoomModel() {
		this.roomList = new ArrayList<Room>();
	}

	/**
	 * Adds a StandardRoom to the room list.
	 *
	 * @param name the name (number) of the room
	 * @param hotel the hotel to which the room belongs
	 */
	public void addStandardRoom(String name, Hotel hotel) {
		Room room = new StandardRoom(name, hotel);
		roomList.add(room);
	}

	/**
	 * Adds a DeluxeRoom to the room list.
	 *
	 * @param name the name (number) of the room
	 * @param hotel the hotel to which the room belongs
	 */
	public void addDeluxeRoom(String name, Hotel hotel) {
		Room room = new DeluxeRoom(name, hotel);
		roomList.add(room);
	}

	/**
	 * Adds an ExecutiveRoom to the room list.
	 *
	 * @param name the name (number) of the room
	 * @param hotel the hotel to which the room belongs
	 */
	public void addExecutiveRoom(String name, Hotel hotel) {
		Room room = new ExecutiveRoom(name, hotel);
		roomList.add(room);
	}

	/**
	 * Removes a room from the room list by its name.
	 *
	 * @param name the name (number) of the room to remove
	 */
	public void removeRoom(String name) {
		for (int i = 0; i < this.roomList.size(); i++)
			if (roomList.get(i).getName().equals(name)) {
				this.roomList.remove(i);
				break;
			}
	}

	/**
	 * Gets the list of rooms.
	 *
	 * @return the list of rooms
	 */
	public ArrayList<Room> getRoomList() {
		return this.roomList;
	}
}