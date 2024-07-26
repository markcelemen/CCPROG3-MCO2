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
				view.setCreateHotelLbl("Enter hotel name");
			}
		});

		this.view.setViewHotelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hotelList = "";
				if (HRS.hotelModel.getHotelList().size() == 0) {
					view.setMainPanelLbl("No hotels added to the system");
				}
				else {
					view.setViewHotelPanelTfText("");
					view.setVhLblText("Enter hotel name to view");
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
				String hotelList = "";
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system");
				else {
					view.setMhTfText("");
					view.setMhLblText("Enter hotel name to modify");
					view.getCardLayout().show(view.getContainer(), "MhPanel1");
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						hotelList += h.getName()+"\n";
					}
				}
				view.setMhTextArea("Hotel list: \n"+hotelList);
			}
		});

		this.view.setSimulateBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system");
			}
		});

		this.view.setDatePriceBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system");
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
					view.setCreateHotelLbl("Invalid hotel name");
				} else {
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						if (name.equals(h.getName()) || name.equals("")) {
							val = false;
							break;
						}
					}
					
					if (val) {
						HRS.hotelModel.getHotelList().add(new Hotel(name));
						view.setCreateHotelLbl("Hotel "+name+" successfully created");
						view.clearCreateHotelTf();
					} else {
						view.setCreateHotelLbl("Hotel name must be unique");
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
				view.setVhLblText("Enter hotel name");
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
					view.setVhLblText("Hotel not found");
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
				
				for (Room r : chosenHotel.roomModel.getRoomList())
					roomList += r.getName() + "\n";
				view.setIRoomTextArea("List of rooms: \n" +roomList);
			}
		});

		this.view.setVHBtn3Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resList = "";
				view.getCardLayout().show(view.getContainer(), "IResPanel");
				view.setIResLblText("Enter reservation details.");
				view.clearIResTfText();
				
				for (Reservation r : chosenHotel.reservationModel.getReservationList())
					resList += "Name: "+String.format("%-20s", r.getGuestName()) + String.format(" Check-in: %02d  ", r.getCheckIn())
					+String.format(" Check-out: %02d  ", r.getCheckOut()) + " Room: "+r.getRoom().getName();
				if (chosenHotel.reservationModel.getReservationList().size() == 0)
					resList += "No reservations made for "+chosenHotel.getName();
				view.setIResTextArea("List of reservations: \n" +resList);
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
				int day = 0;
				boolean result = false;
				String displayAvailable = "";
				String displayBooked = "";

				try {
					day = Integer.parseInt(view.getAbEnterTfText());
					result = true;
				} catch (Exception d) {
					
				}

				if (result == true)
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
						view.setAbTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
						"\nTotal earnings: "+chosenHotel.getEarnings() + "\n\n"
						+"Booked rooms:\n"+ displayBooked + "\nAvailable rooms: \n" + displayAvailable);
					}
				else
					view.setAbLblText("Invalid input");
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
									displayAvailability += i+"  ";
								}
							}
							else {
								displayAvailability += i+"  ";
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
					view.setIRoomTextArea("List of rooms:\n"+roomList);
				}
				else
				view.setIRoomTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
				"\nTotal earnings: "+chosenHotel.getEarnings() +"\n\n"+"Days available within the month:\n" + displayAvailability + "\n\nPrice per night:\n" + displayPrice);
			}
		});

		//info reservation components
		this.view.setIResMenuListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setIResEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resName = view.getIResNameTfText();
				int resIn = 0;
				int resOut = 0;
				String resRoom = view.getIResRoomTfText();
				String display = "";
				boolean val = false, result = false;
				String resList = "";

				try {
					resIn = Integer.parseInt(view.getIResInTfText());
					resOut = Integer.parseInt(view.getIResOutTfText());
				} catch (Exception d) {
					
				}
				if (chosenHotel.reservationModel.getReservationList().size() == 0)
					resList += "No reservations made for "+chosenHotel.getName();
				for (Reservation r : chosenHotel.reservationModel.getReservationList())
					resList += "Name: "+String.format("%-20s", r.getGuestName()) + String.format(" Check-in: %02d  ", r.getCheckIn())
					+String.format(" Check-out: %02d  ", r.getCheckOut()) + " Room: "+r.getRoom().getName();
				if (result == true)
				for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
					if (resName.equals(r.getGuestName()) &&
					resRoom.equals(r.getRoom().getName()) &&
					resIn == r.getCheckIn() &&
					resOut == r.getCheckOut()) {
						display += "Guest name: "+r.getGuestName()+"\n";
						display += "Check-in day: "+String.format("%02",r.getCheckIn())+"\n";
						display += "Check-out day: "+String.format("%02",r.getCheckOut())+"\n";
						display += "Room: "+r.getRoom().getName()+"\n\n";
						display += "Price per night:\n";
						for (Day d : r.getDayList()) {
							display += "Day "+String.format("%02: ", d.getDay())+ (r.getRoom().getPrice() * d.getRate())+"\n\n";
						}
						display += "Total price: "+r.getPrice();
					}
					val = true;
					break;
				}

				if (!val) {
					view.setIResLblText("Reservation not found");
					view.setIResTextArea("List of reservations: \n" +resList);
				}
				else {
					view.setIResTextArea(display);
				}
			}
		});

		// manage hotel panel 1 components
		this.view.setMhMenuBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setMhEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenHotelName = view.getMhTfText();
				boolean val = false;
				for (Hotel h : HRS.hotelModel.getHotelList()) {
					if (chosenHotelName.equals(h.getName())) {
						chosenHotel = h;
						val = true;
						break;
					}
				}

				if (val == false) {
					view.setMhLblText("Hotel not found");
				} else {
					view.setViewHotelPanelTfText("");
					view.getCardLayout().show(view.getContainer(), "MhPanel2");
				}
			}
		});

		// manage hotel panel 2 components
		this.view.setMhMenuBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setMhBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "CnPanel");
				view.setCnLblText("Enter new hotel name");
				view.setCnTfText("");
			}
		});

		this.view.setMhBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "ArPanel1");
			}
		});

		//change hotel name components
		this.view.setCnMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setCnEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = view.getCnTfText();
				boolean val = true;
				if (name.equals("")) {
					view.setCreateHotelLbl("Invalid hotel name");
				} else {
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						if (name.equals(h.getName()) || name.equals("")) {
							val = false;
							break;
						}
					}
					
					if (val) {
						chosenHotel.setName(name);
						view.setCnLblText("Hotel name successfully changed");
						view.setCnTfText("");
					} else {
						view.setCnLblText("Hotel name must be unique/different");
					}
				}
			}
		});

		//add room panel 1 components
		this.view.setArMenuBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});
	}
}