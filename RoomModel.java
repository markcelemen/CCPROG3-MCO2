import java.util.ArrayList;

public class RoomModel {
	private ArrayList<Room> roomList;

	public RoomModel() {
		this.roomList = new ArrayList<Room>();
	}

	public void addStandardRoom(String name, Hotel hotel) {
		Room room = new StandardRoom(name, hotel);
		roomList.add(room);
	}

	public void addDeluxeRoom(String name, Hotel hotel) {
		Room room = new DeluxeRoom(name, hotel);
		roomList.add(room);
	}

	public void addExecutiveRoom(String name, Hotel hotel) {
		Room room = new ExecutiveRoom(name, hotel);
		roomList.add(room);
	}

	public void removeRoom(String name) {
		for (int i = 0; i < this.roomList.size(); i++)
			if (roomList.get(i).getName().equals(name)) {
				this.roomList.remove(i);
				break;
			}
	}

	public ArrayList<Room> getRoomList() {
		return this.roomList;
	}
}