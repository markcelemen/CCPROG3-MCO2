import java.util.ArrayList;

public class RoomModel {
	private ArrayList<Room> roomList;

	public RoomModel() {
		this.roomList = new ArrayList<Room>();
	}

	public void addStandardRoom(String name, double baseRate) {
		Room room = new StandardRoom(name, baseRate);
		roomList.add(room);
	}

	public void addDeluxeRoom(String name, double baseRate) {
		Room room = new DeluxeRoom(name, baseRate);
		roomList.add(room);
	}

	public void addExecutiveRoom(String name, double baseRate) {
		Room room = new ExecutiveRoom(name, baseRate);
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