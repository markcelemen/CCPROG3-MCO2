import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private HRS HRS;
	private String chosenHotelName;
	private Hotel chosenHotel;

	public Controller(HRS HRS, View view) {
		this.view = view;
		this.HRS = HRS;
		
		// main panel components
		this.view.setCreateHotelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "createHotelPanel");
				view.setCreateHotelLbl("Enter hotel name.");
			}
		});

		this.view.setViewHotelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hotelList = "";
				view.setVhLblText("Enter hotel name.");
				if (HRS.hotelModel.getHotelList().size() == 0) {
					view.setMainPanelLbl("No hotels added to the system.");
				}
				else {
					view.getCardLayout().show(view.getContainer(), "viewHotelPanel2");
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						hotelList += h.getName()+"\n";
					}
				}
				view.setVhTextArea("Hotel list: \n"+hotelList);
			}
		});

		this.view.setManageHotelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system.");
			}
		});

		this.view.setSimulateBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system.");
			}
		});

		this.view.setDatePriceBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system.");
			}
		});

		// create hotel panel components
		this.view.setMainMenuBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
				view.clearCreateHotelTf();
			}
		});

		this.view.setEnterHotelBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = view.getHotelNameText();
				boolean val = true;
				if (name.equals("")) {
					view.setCreateHotelLbl("Invalid hotel name.");
				} else {
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						if (name.equals(h.getName()) || name.equals("")) {
							val = false;
							break;
						}
					}
					
					if (val) {
						HRS.hotelModel.getHotelList().add(new Hotel(name));
						view.setCreateHotelLbl("Hotel "+name+" successfully created.");
						view.clearCreateHotelTf();
					} else {
						view.setCreateHotelLbl("Hotel name must be unique.");
					}
				}
			}
		});

		// view hotel components
		this.view.setVhMainMenuListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
				view.setVhLblText("Enter hotel name.");
			}
		});

		this.view.setVhEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenHotelName = view.getViewHotelPanelTfText();
				boolean val = false;
				for (Hotel h : HRS.hotelModel.getHotelList()) {
					if (chosenHotelName.equals(h.getName())) {
						chosenHotel = h;
						val = true;
						break;
					}
				}

				if (val == false) {
					view.setVhLblText("Hotel not found.");
				} else {
					view.setViewHotelPanelTfText("");
					view.getCardLayout().show(view.getContainer(), "viewHotelPanel");
				}
			}
		});

		// second view hotel components
		this.view.setMainMenuBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});
		
		this.view.setVHBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "AbPanel");
				view.setAbLblText("Enter day of the month");
				view.setAbEnterTfText("");
				view.clearAbTextArea();
			}
		});

		this.view.setVHBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String roomList = "";
				view.getCardLayout().show(view.getContainer(), "IRoomPanel");
				view.setIRoomLblText("Enter room name.");
				view.setIRoomTfText("");
				view.setIRoomTextArea("");
				for (Room r : chosenHotel.roomModel.getRoomList())
					roomList += r.getName() + "\n";
				view.setIRoomTextArea("List of rooms: \n" +roomList);
			}
		});
		// available and booked components
		this.view.setAbMainMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setAbEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int day = Integer.parseInt(view.getAbEnterTfText());
				String displayAvailable = "";
				String displayBooked = "";

				if (day < 1 || day > 31) {
					view.setAbLblText("Invalid input");
				} else {
					for (Room r : chosenHotel.roomModel.getRoomList()) {
						if (r.isReserved()) {
							if (r.isAvailable(day)) {
								displayAvailable += r.getName() + "\n";
							}
							else {
								displayBooked += r.getName() + "\n";
							}
						} else {
							displayAvailable += r.getName() + "\n";
						}
					}
				}

				view.setAbTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
				"\nTotal earnings: "+chosenHotel.getEarnings() + "\n\n"
				+"Booked rooms:\n"+ displayBooked + "\nAvailable rooms: \n" + displayAvailable);
			}
		});

		//info room components
		this.view.setIRoomMenuListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setIRoomEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String roomName = view.getIRoomTfText();
				boolean val = false;
				String displayAvailability = "";
				String displayPrice = "";
				String roomList = "";
				for (Room r : chosenHotel.roomModel.getRoomList())
					roomList += r.getName() + "\n";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (roomName.equals(r.getName())) {
						for (int i = 1; i <= 31; i++) {
							if (r.isReserved()) {
								if (r.isAvailable(i)) {
									displayAvailability += i+" ";
								}
							}
							else {
								displayAvailability += i+" ";
							}
						}
						for (Day d : chosenHotel.getDayList()) {
							if (d.getDay() % 5 == 0)
								displayPrice += "\n\n";
							displayPrice += "Day " + String.format("%02d", d.getDay()) + ": " + (d.getRate() * r.getPrice()) + "    ";
						}
						val = true;
						break;
					}
				}
				if (!val) {
					view.setIRoomLblText("Room not found.");
					view.setIRoomTextArea("");
					view.setIRoomTextArea("List of rooms:\n"+roomList);
				}
				else
				view.setIRoomTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
				"\nTotal earnings: "+chosenHotel.getEarnings() +"\n\n"+"Days available within the month:\n" + displayAvailability + "\n\nPrice per night:\n" + displayPrice);
			}
		});
	}
}