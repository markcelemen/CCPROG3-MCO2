import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private HRS HRS;
	private String chosenHotelName;
	private Hotel chosenHotel;
	private String chosenRoomType;
	private Room chosenRoom;
	private Reservation createdReservation;

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
					view.setMhTextArea("Hotel list: \n"+hotelList);
					view.setMhLbl2Text("");
				}
			}
		});

		this.view.setSimulateBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hotelList = "";
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system");
				else {
					view.setSbTfText("");
					view.setSbLbl1Text("Enter hotel for booking");
					view.getCardLayout().show(view.getContainer(), "SbPanel1");
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						hotelList += h.getName()+"\n";
					}
					view.setSbTextArea1("Hotel list: \n"+hotelList);
				}
			}
		});

		this.view.setDatePriceBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hotelList = "";
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system");
				else {
					view.setDpTfText("");
					view.setDpLbl1Text("Enter hotel to modify rate");
					view.getCardLayout().show(view.getContainer(), "DpPanel1");
					for (Hotel h : HRS.hotelModel.getHotelList()) {
						hotelList += h.getName()+"\n";
					}
					view.setDpTextArea("Hotel list: \n"+hotelList);
				}
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
				view.getCardLayout().show(view.getContainer(), "IRoomPanel");
				view.setIRoomLblText("Enter room name.");
				view.setIRoomTfText("");
				
				String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						stdList += r.getName()+"\n";
					if (r instanceof DeluxeRoom)
						delList += r.getName()+"\n";
					if (r instanceof ExecutiveRoom)
						exList += r.getName()+"\n";
				}
				view.setIRoomTextArea("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
			}
		});

		this.view.setVHBtn3Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resList = "";
				view.getCardLayout().show(view.getContainer(), "IResPanel");
				view.setIResLblText("Enter reservation details");
				view.clearIResTfText();
				
				for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
					resList += "Name: "+String.format("%-40s", r.getGuestName()) + String.format(" Check-in: %02d      ", r.getCheckIn())
					+String.format(" Check-out: %02d      ", r.getCheckOut()) + " Room: "+r.getRoom().getName();
					if (r.getRoom() instanceof StandardRoom)
						resList += "(S)\n";
					if (r.getRoom() instanceof DeluxeRoom)
						resList += "(D)\n";
					if (r.getRoom() instanceof ExecutiveRoom)
						resList += "(E)\n";
				}
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
									if (r instanceof StandardRoom)
										displayAvailable += r.getName() + "(S)\n";
									if (r instanceof DeluxeRoom)
										displayAvailable += r.getName() + "(D)\n";
									if (r instanceof ExecutiveRoom)
										displayAvailable += r.getName() + "(E)\n";
								}
								else {
									if (r instanceof StandardRoom)
										displayBooked += r.getName() + "(S)\n";
									if (r instanceof DeluxeRoom)
										displayBooked += r.getName() + "(D)\n";
									if (r instanceof ExecutiveRoom)
										displayBooked += r.getName() + "(E)\n";
								}
							} else {
								if (r instanceof StandardRoom)
									displayAvailable += r.getName() + "(S)\n";
								if (r instanceof DeluxeRoom)
									displayAvailable += r.getName() + "(D)\n";
								if (r instanceof ExecutiveRoom)
									displayAvailable += r.getName() + "(E)\n";
							}
						}
						view.setAbTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
						"\nTotal earnings: "+chosenHotel.getEarnings() + "\n\n"
						+"Booked rooms:\n"+ displayBooked + "\nAvailable rooms: \n" + displayAvailable);
						view.setAbLblText("Viewing hotel "+chosenHotel.getName()+" and day "+day+" availability");
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
				String displayType = "";
				String displayAvailability = "";
				String displayPrice = "";
				String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						stdList += r.getName()+"\n";
					if (r instanceof DeluxeRoom)
						delList += r.getName()+"\n";
					if (r instanceof ExecutiveRoom)
						exList += r.getName()+"\n";
				}
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (roomName.equals(r.getName())) {
						for (Day d : chosenHotel.getDayList()) {
							if (r.isReserved()) {
								if (r.isAvailable(d.getDay())) {
									displayAvailability += d.getDay()+"  ";
								}
							}
							else {
								displayAvailability += d.getDay()+"  ";
							}
						}
						for (Day d : chosenHotel.getDayList()) {
							if (d.getDay() % 5 == 0)
								displayPrice += "\n\n";
							displayPrice += "Day " + String.format("%02d", d.getDay()) + ": " + (d.getRate() * r.getPrice()) + "    ";
						}
						if (r instanceof StandardRoom)
							displayType += "Standard";
						if (r instanceof DeluxeRoom)
							displayType += "Deluxe";
						if (r instanceof ExecutiveRoom)
							displayType += "Executive";

						val = true;
						break;
					}
				}
				if (!val) {
					view.setIRoomLblText("Room not found");
					view.setIRoomTextArea("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
				}
				else {
					view.setIRoomTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
					"\nTotal earnings: "+chosenHotel.getEarnings() +"\n\n"+"Room type: "+displayType+
					"\n\nDays available within the month:\n" + displayAvailability + "\n\nPrice per night:\n" + displayPrice);
					view.setIRoomLblText("Viewing hotel "+chosenHotel.getName()+" and room "+roomName);
				}
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
					result = true;
				} catch (Exception d) {
					
				}
				if (chosenHotel.reservationModel.getReservationList().size() == 0)
					resList += "No reservations made for "+chosenHotel.getName();
				if (result == true) {
					for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
						if (resName.equals(r.getGuestName()) &&
						resRoom.equals(r.getRoom().getName()) &&
						resIn == r.getCheckIn() &&
						resOut == r.getCheckOut()) {
							display += "Guest name: "+r.getGuestName()+"\n";
							display += "Check-in day: "+String.format("%02d",r.getCheckIn())+"\n";
							display += "Check-out day: "+String.format("%02d",r.getCheckOut())+"\n";
							display += "Room: ";
							if (r.getRoom() instanceof StandardRoom) 
								display += r.getRoom().getName()+"(S)\n";
							if (r.getRoom() instanceof DeluxeRoom)
								display += r.getRoom().getName()+"(D)\n";
							if (r.getRoom() instanceof ExecutiveRoom)
								display += r.getRoom().getName()+"(E)\n";
							display += "\nPrice per night:\n";
							for (Day d : r.getDayList()) {
								display += "Day "+String.format("%02d: ", d.getDay())+ (r.getRoom().getPrice() * d.getRate())+"\n\n";
							}
							display += "Total price: "+r.getPrice();
							if (r.getRedeemedCode()) {
								display += "\nDiscount applied";
							}
							val = true;
							break;
						}
					}

					if (!val) {
						view.setIResLblText("Reservation not found");
						for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
							resList += "Name: "+String.format("%-40s", r.getGuestName()) + String.format(" Check-in: %02d      ", r.getCheckIn())
							+String.format(" Check-out: %02d      ", r.getCheckOut()) + " Room: "+r.getRoom().getName();
							if (r.getRoom() instanceof StandardRoom)
								resList += "(S)\n";
							if (r.getRoom() instanceof DeluxeRoom)
								resList += "(D)\n";
							if (r.getRoom() instanceof ExecutiveRoom)
								resList += "(E)\n";
						}
						view.setIResTextArea("List of reservations: \n" +resList);
					}
					else {
						view.setIResTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
						"\nTotal earnings: "+chosenHotel.getEarnings() +"\n\n"+display);
						view.setIResLblText("Viewing "+chosenHotel.getName()+" with selected reservation");
					}
				}
				else {
					view.setIResLblText("Invalid input");
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
				if (chosenHotel.roomModel.getRoomList().size() == 50) {
					view.setMhLbl2Text("Maximum number of rooms reached");
				}
				else {
					view.getCardLayout().show(view.getContainer(), "ArPanel1");
				}
			}
		});

		this.view.setMhBtn3Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ctr = 0;
				for (Room r : chosenHotel.roomModel.getRoomList()){
					if (!r.isReserved()) {
						ctr++;
					}
				}

				if (chosenHotel.roomModel.getRoomList().size() == 1) {
					view.setMhLbl2Text("Hotel must have at least 1 room");
				} else if (ctr == 0) {
					view.setMhLbl2Text("All rooms have a reservation");
				}
				else {
					String roomList = "";
					view.getCardLayout().show(view.getContainer(), "RRoomPanel");
					for (Room r : chosenHotel.roomModel.getRoomList()) {
						if (r instanceof StandardRoom) 
							roomList += r.getName()+"(S)\n";
						if (r instanceof DeluxeRoom)
							roomList += r.getName()+"(D)\n";
						if (r instanceof ExecutiveRoom)
							roomList += r.getName()+"(E)\n";
					}
					view.setRRoomTextArea("List of Rooms without a reservation:\n"+roomList);
					view.setRRoomLblText("Enter room to remove");
				}
			}
		});

		this.view.setMhBtn4Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenHotel.reservationModel.getReservationList().size() == 0) {
					view.getCardLayout().show(view.getContainer(), "UpPanel");
					view.setUpLblText("Enter new base price for a room");
				} else {
					view.setMhLbl2Text("Hotel must have no reservations");
				}
			}
		});

		this.view.setMhBtn5Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resList = "";
				if (chosenHotel.reservationModel.getReservationList().size() == 0) {
					view.setMhLbl2Text("Empty reservation list");
				}
				else {
					for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
						resList += "Name: "+String.format("%-20s", r.getGuestName()) + String.format(" Check-in: %02d  ", r.getCheckIn())
						+String.format(" Check-out: %02d  ", r.getCheckOut()) + " Room: "+r.getRoom().getName();
						if (r.getRoom() instanceof StandardRoom)
							resList += "(S)\n";
						if (r.getRoom() instanceof DeluxeRoom)
							resList += "(D)\n";
						if (r.getRoom() instanceof ExecutiveRoom)
							resList += "(E)\n";
					}
					view.setRResTextArea("List of reservations: \n" +resList);
					view.getCardLayout().show(view.getContainer(), "RResPanel");
					view.setRResLblText("Enter reservation details.");
					view.clearRResTfText();
				}
			}
		});

		this.view.setMhBtn6Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setRhLblText("The following hotel will be deleted");
				view.setRhLbl2Text(chosenHotel.getName());
				view.setRhLbl3Text("Continue?");
				view.getCardLayout().show(view.getContainer(), "RhPanel");
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

		this.view.setArStdBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "ArPanel2");
				chosenRoomType = "Standard";

				String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						stdList += r.getName()+"\n";
					if (r instanceof DeluxeRoom)
						delList += r.getName()+"\n";
					if (r instanceof ExecutiveRoom)
						exList += r.getName()+"\n";
				}
				view.setArTfText("");
				view.setArLblText("Add "+chosenRoomType+" Room");
				view.setArTextArea("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
			}
		});

		this.view.setArDelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "ArPanel2");
				chosenRoomType = "Deluxe";

				String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						stdList += r.getName()+"\n";
					if (r instanceof DeluxeRoom)
						delList += r.getName()+"\n";
					if (r instanceof ExecutiveRoom)
						exList += r.getName()+"\n";
				}
				view.setArTfText("");
				view.setArLblText("Add "+chosenRoomType+" Room");
				view.setArTextArea("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
			}
		});

		this.view.setArExBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "ArPanel2");
				chosenRoomType = "Executive";

				String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						stdList += r.getName()+"\n";
					if (r instanceof DeluxeRoom)
						delList += r.getName()+"\n";
					if (r instanceof ExecutiveRoom)
						exList += r.getName()+"\n";
				}
				view.setArTfText("");
				view.setArLblText("Add "+chosenRoomType+" Room");
				view.setArTextArea("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
			}	
		});

		//add room panel 2 components
		this.view.setArMenuBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setArEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String roomName = view.getArTfText();
				boolean val = true;
				String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
				if (roomName.equals(""))
					val = false;
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (roomName.equals(r.getName())) {
						val = false;
						break;
					}
				}
				if (chosenHotel.roomModel.getRoomList().size() == 50) 
					val = false;
				if (val) {
					if (chosenRoomType.equals("Standard"))
					chosenHotel.roomModel.addStandardRoom(roomName, chosenHotel);
					if (chosenRoomType.equals("Deluxe"))
						chosenHotel.roomModel.addDeluxeRoom(roomName, chosenHotel);
					if (chosenRoomType.equals("Executive"))
						chosenHotel.roomModel.addExecutiveRoom(roomName, chosenHotel);
					view.setArLblText("Room successfully added");
					view.setArTfText("");
				} else if (roomName.equals("")) {
					view.setArLblText("Invalid room name");
				} else if (chosenHotel.roomModel.getRoomList().size() == 50){
					view.setArLblText("Maximum number of rooms reached");
				} else {
					view.setArLblText("Room name must be unique");
				}
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						stdList += r.getName()+"\n";
					if (r instanceof DeluxeRoom)
						delList += r.getName()+"\n";
					if (r instanceof ExecutiveRoom)
						exList += r.getName()+"\n";
				}
				view.setArTextArea("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
			}
		});

		//remove rooms components
		this.view.setRRoomMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setRRoomEnterBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomName = view.getRRoomTfText();
				boolean val = false, found = false;
				
				if (roomName.equals(""))
					val = false;
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (roomName.equals(r.getName())) {
						if (!r.isReserved()){
							val = true;
							found = true;
							break;
						}
					}
				}
				if (chosenHotel.roomModel.getRoomList().size() == 1) 
					val = false;
				if (val && found) {
					chosenHotel.roomModel.removeRoom(roomName);
					view.setRRoomLblText("Room successfully removed");
					view.setRRoomTfText("");
				} else if (roomName.equals("")) {
					view.setRRoomLblText("Invalid room name");
				} else if (found && chosenHotel.roomModel.getRoomList().size() == 1) {
					view.setRRoomLblText("Hotel must have at least 1 room");
				} else {
					view.setRRoomLblText("Room not found in displayed list");
				}
				String roomList = "";
				for (Room r : chosenHotel.roomModel.getRoomList()) {
					if (r instanceof StandardRoom) 
						roomList += r.getName()+"(S)\n";
					if (r instanceof DeluxeRoom)
						roomList += r.getName()+"(D)\n";
					if (r instanceof ExecutiveRoom)
						roomList += r.getName()+"(E)\n";
				}
				view.setRRoomTextArea("List of Rooms without a reservation:\n"+roomList);
			}
		});

		// update base price components
		this.view.setUpMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setUpEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double input = 0;
				boolean result = false;
				try {
					input = Double.parseDouble(view.getUpTfText());
					result = true;
				} catch (Exception d) {
					
				}

				if (result) {
					if (input >= 100) {
						chosenHotel.setCostPerNight(input);
						view.setUpLblText("Base price successfully changed");
						view.setUpTfText("");
					} else {
						view.setUpLblText("Base price must be at least 100.0");
					}
				} else {
					view.setUpLblText("Invalid input");
				}
			}
		});

		//remove reservation components
		this.view.setRResMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setRResEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resName = view.getRResNameTfText();
				int resIn = 0;
				int resOut = 0;
				String resRoom = view.getRResRoomTfText();
				String display = "";
				boolean val = false, result = false;
				String resList = "";

				try {
					resIn = Integer.parseInt(view.getRResInTfText());
					resOut = Integer.parseInt(view.getRResOutTfText());
					result = true;
				} catch (Exception d) {
					
				}
				if (chosenHotel.reservationModel.getReservationList().size() == 0)
					resList += "No reservations made for "+chosenHotel.getName();
				if (result == true) {
					for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
						if (resName.equals(r.getGuestName()) &&
						resRoom.equals(r.getRoom().getName()) &&
						resIn == r.getCheckIn() &&
						resOut == r.getCheckOut()) {
							chosenHotel.reservationModel.getReservationList().remove(r);
							val = true;
							break;
						}
					}

					if (!val) {
						view.setRResLblText("Reservation not found");
					}
					else {
						view.setRResTextArea("Hotel name: " +chosenHotel.getName()+"\nTotal number of rooms: "+chosenHotel.roomModel.getRoomList().size()+
						"\nTotal earnings: "+chosenHotel.getEarnings() +"\n\n"+display);
						view.setRResLblText("Viewing hotel "+chosenHotel.getName()+" with selected reservation");
					}
					for (Reservation r : chosenHotel.reservationModel.getReservationList()) {
						resList += "Name: "+String.format("%-20s", r.getGuestName()) + String.format(" Check-in: %02d  ", r.getCheckIn())
						+String.format(" Check-out: %02d  ", r.getCheckOut()) + " Room: "+r.getRoom().getName();
						if (r.getRoom() instanceof StandardRoom)
							resList += "(S)\n";
						if (r.getRoom() instanceof DeluxeRoom)
							resList += "(D)\n";
						if (r.getRoom() instanceof ExecutiveRoom)
							resList += "(E)\n";
					}
					view.setRResTextArea("List of reservations: \n" +resList);
				}
				else {
					view.setRResLblText("Invalid input");
				}
			}
		});

		//remove hotel components
		this.view.setRhMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setRhOkBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setMainPanelLbl("Hotel "+chosenHotel.getName()+" successfully removed");
				HRS.hotelModel.getHotelList().remove(chosenHotel);
				view.getCardLayout().show(view.getContainer(), "mainPanel");
			}
		});

		this.view.setRhCancelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "MhPanel2");
			}
		});

		//simulate booking panel 1 components
		this.view.setSbMenuBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setSbEnterBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenHotelName = view.getSbTfText();
				boolean val = false;
				for (Hotel h : HRS.hotelModel.getHotelList()) {
					if (chosenHotelName.equals(h.getName())) {
						chosenHotel = h;
						val = true;
						break;
					}
				}

				if (val == false) {
					view.setSbLbl1Text("Hotel not found");
				} else {
					String stdList = "Standard Rooms:\n", delList = "Deluxe Rooms:\n", exList = "Executive Rooms\n";
					for (Room r : chosenHotel.roomModel.getRoomList()) {
						if (r instanceof StandardRoom) 
							stdList += r.getName()+"\n";
						if (r instanceof DeluxeRoom)
							delList += r.getName()+"\n";
						if (r instanceof ExecutiveRoom)
							exList += r.getName()+"\n";
					}
					view.setSbTextArea2("List of Rooms:\n"+stdList+"\n"+delList+"\n"+exList);
					view.setSbLbl2Text("Enter reservation details");
					view.getCardLayout().show(view.getContainer(), "SbPanel2");
					view.clearSbTfText();
				}
			}
		});

		//simulate booking panel 2 components
		this.view.setSbMenuBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setSbEnterBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resName = view.getSbNameTfText();
				int resIn = 0;
				int resOut = 0;
				String resRoom = view.getSbRoomTfText();
				boolean result = false, available = true, found = false;

				try {
					resIn = Integer.parseInt(view.getSbInTfText());
					resOut = Integer.parseInt(view.getSbOutTfText());
					result = true;
				} catch (Exception d) {
					
				}
				
				if (result == true) {
					if (resIn > resOut || resIn < 1 || resOut > 31 || resIn == 31 || resOut == 1) {
						view.setSbLbl2Text("Invalid check-in/check-out");
					} else {
						for (Room r : chosenHotel.roomModel.getRoomList()) { // checks availability of room
							if (resRoom.equals(r.getName())) {
								found = true;
								if (r.isReserved()) {
									for (int i = resIn; i < resOut; i++) {
										if (r.isAvailable(i)) {
											chosenRoom = r;
										} else {
											available = false;
										}
									}
								} else {
									chosenRoom = r;
								}
								break;
							}
						}
						if (found) {
							if (available) {
								createdReservation = new Reservation(resName, resIn, resOut, chosenRoom, chosenHotel);
								chosenHotel.reservationModel.getReservationList().add(createdReservation);
								chosenRoom.reservationModel.getReservationList().add(createdReservation);
								
								view.setCodeTfText("");
								view.setCodeLbl2Text("Enter discount code");
								view.getCardLayout().show(view.getContainer(), "CodePanel");
							} else {
								view.setSbLbl2Text("Room not available");
							}
						} else {
							view.setSbLbl2Text("Room not found");
						}
					}
				}
				else {
					view.setSbLbl2Text("Invalid input");
				}
			}
		});

		//discount code components
		this.view.setCodeMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setCodeEnterBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String code = view.getCodeTfText();
				DiscountCode discountCode;
				boolean result;

				if (createdReservation.getRedeemedCode() == false) {
					if (code.equals("I_WORK_HERE") || code.equals("STAY4_GET1") || code.equals("PAYDAY")) {
						if (code.equals("I_WORK_HERE")) {
							discountCode = new IWorkHereDiscount();
							result = discountCode.applyDiscount(createdReservation);
							createdReservation.setRedeemedCode(result);
							view.setCodeLbl2Text("Code accepted");
						}
						else if (code.equals("STAY4_GET1")) {
							discountCode = new Stay4Get1Discount();
							result = discountCode.applyDiscount(createdReservation);
							if (result == false) {
								view.setCodeLbl2Text("Conditions not met");
							} else {
								createdReservation.setRedeemedCode(result);
								view.setCodeLbl2Text("Code accepted");
							}
						}
						else if (code.equals("PAYDAY")) {
							discountCode = new PaydayDiscount();
							result = discountCode.applyDiscount(createdReservation);
							if (result == false) {
								view.setCodeLbl2Text("Conditions not met");
							} else {
								createdReservation.setRedeemedCode(result);
								view.setCodeLbl2Text("Code accepted");
							}
						}
					} else {
						view.setCodeLbl2Text("Invalid code");
					}
				} else {
					view.setCodeLbl2Text("Discount already applied");
				}
			}
		});

		//date price modifier panel 1 components
		this.view.setDpMenuBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setDpEnterBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenHotelName = view.getDpTfText();
				boolean val = false;
				for (Hotel h : HRS.hotelModel.getHotelList()) {
					if (chosenHotelName.equals(h.getName())) {
						chosenHotel = h;
						val = true;
						break;
					}
				}

				if (val == false) {
					view.setDpLbl1Text("Hotel not found");
				} else {
					view.setDpLbl2Text("Enter day and new rate");
					view.clearDpTfText();
					view.getCardLayout().show(view.getContainer(), "DpPanel2");
				}
			}
		});

		//date price modifier panel 2 components
		this.view.setDpMenuBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setDpEnterBtn2Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int day = 0;
				double rate = 0;
				boolean result = false;
				try {
					day = Integer.parseInt(view.getDpDayTfText());
					rate = Double.parseDouble(view.getDpRateTfText());
					result = true;
				} catch (Exception d) {
					
				}
				if (result == true) {
					if (day < 1 || day > 31) {
						view.setDpLbl2Text("Invalid day");
					}
					else if (rate < 0.5 || rate > 1.5) {
						view.setDpLbl2Text("Rate must be from 50% to 150%");
					}
					else {
						chosenHotel.getDayList().get(day - 1).setRate(rate);
						view.clearDpTfText();
						view.setDpLbl2Text("Rate successfully changed");
					}
				} else {
					view.setDpLbl2Text("Invalid input");
				}
			}
		});
	}
}