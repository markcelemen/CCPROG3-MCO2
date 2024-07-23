import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private HRS HRS;

	public Controller(HRS HRS, View view) {
		this.view = view;
		this.HRS = HRS;

		this.view.setMainMenuBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "mainPanel");
				view.setMainPanelLbl("");
			}
		});

		// main panel components
		this.view.setCreateHotelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCardLayout().show(view.getContainer(), "createHotelPanel");
				view.setMainPanelLbl("");
			}
		});

		this.view.setViewHotelBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (HRS.hotelModel.getHotelList().size() == 0)
					view.setMainPanelLbl("No hotels added to the system.");
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

		//create hotel panel components
		this.view.setEnterHotelBtn1Listener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = view.getHotelNameText();
				boolean val = true;

				for (Hotel h : HRS.hotelModel.getHotelList()) {
					if (name.equals(h.getName())) {
					  val = false;
					  break;
					}
				  }
			  
				  if (val == true) {
					HRS.hotelModel.getHotelList().add(new Hotel(name));
					view.setCreateHotelLbl("Hotel "+name+" sueccessfully created.");
					view.clearCreateHotelTf();
				  } else {
					view.setCreateHotelLbl("Hotel name must be unique.");
				  }
			}
		});
	}
}