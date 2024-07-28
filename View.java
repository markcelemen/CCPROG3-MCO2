import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
	private JFrame mainFrame;
	private JPanel mainPanel, createHotelPanel, viewHotelPanel, 
				   viewHotelPanel2, AbPanel, IRoomPanel, IResPanel,
				   MhPanel1, MhPanel2, CnPanel, ArPanel1, ArPanel2, RRoomPanel, UpPanel, RResPanel
				   ;
	private JLabel mainPanelLbl, createHotelLbl, VhLbl, MhLbl, 
						AbLbl, IRoomLbl, IResLbl, IResNameLbl, IResInLbl, IResOutLbl, IResRoomLbl,
						MhLbl2, CnLbl, ArLbl, RRoomLbl, UpLbl, RResLbl, RResNameLbl, RResInLbl, RResOutLbl, RResRoomLbl
						;
	private JTextField createHotelTf, 
					   viewHotelPanelTf, AbEnterTf, IRoomTf, IResNameTf, IResInTf, IResOutTf, IResRoomTf,
					   MhTf, CnTf, ArTf, RRoomTf, UpTf, RResNameTf, RResInTf, RResOutTf, RResRoomTf
					   ;
	private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, simulateBtn, datePriceBtn, // main menu buttons
					mainMenuBtn1, enterHotelBtn1, // create hotel buttons
					VhMainMenuBtn, VhEnterBtn, mainMenuBtn2, VHBtn1, VHBtn2, VHBtn3, // view hotel buttons
						AbMainMenuBtn, AbEnterBtn,
						IRoomMenuBtn, IRoomEnterBtn,
						IResMenuBtn, IResEnterBtn,
					MhMenuBtn1, MhEnterBtn, MhMenuBtn2, MhBtn1, MhBtn2, MhBtn3, MhBtn4, MhBtn5, MhBtn6, // manage hotel buttons
						CnMenuBtn, CnEnterBtn,
						ArMenuBtn1, ArMenuBtn2, ArStdBtn, ArDelBtn, ArExBtn, ArEnterBtn,
						RRoomMenuBtn, RRoomEnterBtn,
						UpMenuBtn, UpEnterBtn,
						RResMenuBtn, RResEnterBtn
					;
	private JTextArea VhTextArea, AbTextArea, IRoomTextArea, IResTextArea,
				      MhTextArea, ArTextArea, RRoomTextArea, RResTextArea
					  ;
	private Container container;
	private CardLayout cardLayout;
	
	public View() {
		this.mainFrame = new JFrame("Hotel Reservation System");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);

		this.container = this.mainFrame.getContentPane();
		this.cardLayout = new CardLayout();
		this.container.setLayout(cardLayout);

		//-------------------------------------------
		//main panel
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(null);

		this.createHotelBtn = new JButton("Create Hotel");
		this.createHotelBtn.setBounds(190, 50, 220, 30);
		this.mainPanel.add(createHotelBtn);

		this.viewHotelBtn = new JButton("View Hotel");
		this.viewHotelBtn.setBounds(190, 90, 220, 30);
		this.mainPanel.add(viewHotelBtn);

		this.manageHotelBtn = new JButton("Manage Hotel");
		this.manageHotelBtn.setBounds(190, 130, 220, 30);
		this.mainPanel.add(manageHotelBtn);

		this.simulateBtn = new JButton("Simulate Booking");
		this.simulateBtn.setBounds(190, 170, 220, 30);
		this.mainPanel.add(simulateBtn);

		this.datePriceBtn = new JButton("Modify Date Price");
		this.datePriceBtn.setBounds(190, 210, 220, 30);
		this.mainPanel.add(datePriceBtn);

		this.mainPanelLbl = new JLabel("");
		this.mainPanelLbl.setBounds(190, 250, 220, 30);
		this.mainPanel.add(mainPanelLbl);

		this.container.add(mainPanel, "mainPanel");

		//create hotel panel
		this.mainMenuBtn1 = new JButton("Main Menu");
		this.mainMenuBtn1.setBounds(0, 0, 100, 30);

		this.createHotelPanel = new JPanel();
		this.createHotelPanel.setLayout(null);

		this.createHotelTf = new JTextField();
		this.createHotelTf.setBounds(217, 50, 166, 25);
		this.createHotelPanel.add(createHotelTf);

		this.enterHotelBtn1 = new JButton("Enter");
		this.enterHotelBtn1.setBounds(190, 130, 220, 30);
		this.createHotelPanel.add(enterHotelBtn1);

		this.createHotelLbl = new JLabel("Enter hotel name.");
		this.createHotelLbl.setBounds(190, 210, 220, 30);
		this.createHotelPanel.add(createHotelLbl);

		this.createHotelPanel.add(this.mainMenuBtn1);

		this.container.add(createHotelPanel, "createHotelPanel");

		//view hotel panel
		this.viewHotelPanel2 = new JPanel();
		this.viewHotelPanel2.setLayout(null);

		this.VhMainMenuBtn = new JButton("Main Menu");
		this.VhMainMenuBtn.setBounds(0, 0, 100, 30);
		this.viewHotelPanel2.add(VhMainMenuBtn);

		this.viewHotelPanelTf = new JTextField();
		this.viewHotelPanelTf.setBounds(217, 50, 166, 25);
		this.viewHotelPanel2.add(viewHotelPanelTf);

		this.VhEnterBtn = new JButton("Enter");
		this.VhEnterBtn.setBounds(190, 130, 220, 30);
		this.viewHotelPanel2.add(this.VhEnterBtn);

		this.VhLbl = new JLabel();
		this.VhLbl.setBounds(190, 210, 220, 30);
		this.viewHotelPanel2.add(this.VhLbl);

		this.VhTextArea = new JTextArea();
		this.VhTextArea.setBounds(5, 300, 580, 400);
		this.VhTextArea.setEditable(false);
		this.viewHotelPanel2.add(this.VhTextArea);

		this.container.add(this.viewHotelPanel2, "viewHotelPanel2");

		//second view hotel panel
		this.mainMenuBtn2 = new JButton("Main Menu");
		this.mainMenuBtn2.setBounds(0, 0, 100, 30);

		this.viewHotelPanel = new JPanel();
		this.viewHotelPanel.setLayout(null);
		
		this.VHBtn1 = new JButton("# of Available & Booked Rooms");
		this.VHBtn1.setBounds(190, 50, 220, 30);
		this.viewHotelPanel.add(this.VHBtn1);

		this.VHBtn2 = new JButton("Info about Selected Room");
		this.VHBtn2.setBounds(190, 90, 220, 30);
		this.viewHotelPanel.add(this.VHBtn2);

		this.VHBtn3 = new JButton("Info about Selected Reservation");
		this.VHBtn3.setBounds(190, 130, 220, 30);
		this.viewHotelPanel.add(this.VHBtn3);

		this.viewHotelPanel.add(this.mainMenuBtn2);

		this.container.add(viewHotelPanel, "viewHotelPanel");

		// available and booked rooms panel
		this.AbPanel = new JPanel();
		this.AbPanel.setLayout(null);

		this.AbMainMenuBtn = new JButton("Main Menu");
		this.AbMainMenuBtn.setBounds(0, 0, 100, 30);

		this.AbPanel.add(this.AbMainMenuBtn);

		this.AbEnterTf = new JTextField();
		this.AbEnterTf.setBounds(217, 50, 166, 25);
		this.AbPanel.add(this.AbEnterTf);

		this.AbEnterBtn = new JButton("Enter");
		this.AbEnterBtn.setBounds(190, 130, 220, 30);
		this.AbPanel.add(this.AbEnterBtn);

		this.AbLbl = new JLabel();
		this.AbLbl.setBounds(190, 210, 220, 30);
		this.AbPanel.add(this.AbLbl);

		this.AbTextArea = new JTextArea();
		this.AbTextArea.setBounds(5, 300, 580, 400);
		this.AbTextArea.setEditable(false);
		this.AbPanel.add(this.AbTextArea);

		this.container.add(AbPanel, "AbPanel");

		// info room panel
		this.IRoomPanel = new JPanel();
		this.IRoomPanel.setLayout(null);

		this.IRoomMenuBtn = new JButton("Main Menu");
		this.IRoomMenuBtn.setBounds(0, 0, 100, 30);
		this.IRoomPanel.add(this.IRoomMenuBtn);

		this.IRoomTf = new JTextField();
		this.IRoomTf.setBounds(217, 50, 166, 25);
		this.IRoomPanel.add(this.IRoomTf);

		this.IRoomEnterBtn = new JButton("Enter");
		this.IRoomEnterBtn.setBounds(190, 130, 220, 30);
		this.IRoomPanel.add(this.IRoomEnterBtn);

		this.IRoomLbl = new JLabel();
		this.IRoomLbl.setBounds(190, 210, 220, 30);
		this.IRoomPanel.add(this.IRoomLbl);

		this.IRoomTextArea = new JTextArea();
		this.IRoomTextArea.setBounds(5, 300, 580, 400);
		this.IRoomTextArea.setEditable(false);
		this.IRoomPanel.add(this.IRoomTextArea);

		this.container.add(IRoomPanel, "IRoomPanel");

		//info reservation panel
		this.IResPanel = new JPanel();
		this.IResPanel.setLayout(null);

		this.IResMenuBtn = new JButton("Main Menu");
		this.IResMenuBtn.setBounds(0, 0, 100, 30);
		this.IResPanel.add(this.IResMenuBtn);
		
		this.IResNameLbl = new JLabel("Name:");
		this.IResNameLbl.setBounds(110, 5, 220, 30);
		this.IResPanel.add(this.IResNameLbl);

		this.IResInLbl = new JLabel("Check-in day:");
		this.IResInLbl.setBounds(110, 25, 220, 30);
		this.IResPanel.add(this.IResInLbl);

		this.IResOutLbl = new JLabel("Check-out day:");
		this.IResOutLbl.setBounds(110, 45, 220, 30);
		this.IResPanel.add(this.IResOutLbl);

		this.IResRoomLbl = new JLabel("Room:");
		this.IResRoomLbl.setBounds(110, 65, 220, 30);
		this.IResPanel.add(this.IResRoomLbl);

		this.IResNameTf = new JTextField();
		this.IResNameTf.setBounds(217, 10, 166, 25);
		this.IResPanel.add(this.IResNameTf);

		this.IResInTf = new JTextField();
		this.IResInTf.setBounds(217, 30, 166, 25);
		this.IResPanel.add(this.IResInTf);

		this.IResOutTf = new JTextField();
		this.IResOutTf.setBounds(217, 50, 166, 25);
		this.IResPanel.add(this.IResOutTf);

		this.IResRoomTf = new JTextField();
		this.IResRoomTf.setBounds(217, 70, 166, 25);
		this.IResPanel.add(this.IResRoomTf);

		this.IResEnterBtn = new JButton("Enter");
		this.IResEnterBtn.setBounds(190, 130, 220, 30);
		this.IResPanel.add(this.IResEnterBtn);

		this.IResLbl = new JLabel();
		this.IResLbl.setBounds(190, 210, 220, 30);
		this.IResPanel.add(this.IResLbl);

		this.IResTextArea = new JTextArea();
		this.IResTextArea.setBounds(5, 300, 580, 400);
		this.IResTextArea.setEditable(false);
		this.IResPanel.add(this.IResTextArea);

		this.container.add(IResPanel, "IResPanel");

		//manage hotel panel 1
		this.MhPanel1 = new JPanel();
		this.MhPanel1.setLayout(null);

		this.MhMenuBtn1 = new JButton("Main Menu");
		this.MhMenuBtn1.setBounds(0, 0, 100, 30);
		this.MhPanel1.add(this.MhMenuBtn1);

		this.MhTf = new JTextField();
		this.MhTf.setBounds(217, 50, 166, 25);
		this.MhPanel1.add(this.MhTf);

		this.MhEnterBtn = new JButton("Enter");
		this.MhEnterBtn.setBounds(190, 130, 220, 30);
		this.MhPanel1.add(this.MhEnterBtn);

		this.MhLbl = new JLabel();
		this.MhLbl.setBounds(190, 210, 220, 30);
		this.MhPanel1.add(this.MhLbl);

		this.MhTextArea = new JTextArea();
		this.MhTextArea.setBounds(5, 300, 580, 400);
		this.MhTextArea.setEditable(false);
		this.MhPanel1.add(this.MhTextArea);

		this.container.add(MhPanel1, "MhPanel1");

		//manage hotel panel 2
		this.MhPanel2 = new JPanel();
		this.MhPanel2.setLayout(null);

		this.MhMenuBtn2 = new JButton("Main Menu");
		this.MhMenuBtn2.setBounds(0, 0, 100, 30);
		this.MhPanel2.add(this.MhMenuBtn2);

		this.MhBtn1 = new JButton("Change Hotel Name");
		this.MhBtn1.setBounds(190, 50, 220, 30);
		this.MhPanel2.add(this.MhBtn1);

		this.MhBtn2 = new JButton("Add Room(s)");
		this.MhBtn2.setBounds(190, 90, 220, 30);
		this.MhPanel2.add(this.MhBtn2);

		this.MhBtn3 = new JButton("Remove Room(s)");
		this.MhBtn3.setBounds(190, 130, 220, 30);
		this.MhPanel2.add(this.MhBtn3);

		this.MhBtn4 = new JButton("Update Room Price");
		this.MhBtn4.setBounds(190, 170, 220, 30);
		this.MhPanel2.add(this.MhBtn4);

		this.MhBtn5 = new JButton("Remove Reservation");
		this.MhBtn5.setBounds(190, 210, 220, 30);
		this.MhPanel2.add(this.MhBtn5);
		
		this.MhBtn6 = new JButton("Remove Hotel");
		this.MhBtn6.setBounds(190, 250, 220, 30);
		this.MhPanel2.add(this.MhBtn6);

		this.MhLbl2 = new JLabel();
		this.MhLbl2.setBounds(190, 290, 220, 30);
		this.MhPanel2.add(MhLbl2);

		this.container.add(MhPanel2, "MhPanel2");

		//change hotel name panel
		this.CnPanel = new JPanel();
		this.CnPanel.setLayout(null);

		this.CnMenuBtn = new JButton("Main Menu");
		this.CnMenuBtn.setBounds(0, 0, 100, 30);
		this.CnPanel.add(this.CnMenuBtn);

		this.CnTf = new JTextField();
		this.CnTf.setBounds(217, 50, 166, 25);
		this.CnPanel.add(this.CnTf);

		this.CnEnterBtn = new JButton("Enter");
		this.CnEnterBtn.setBounds(190, 130, 220, 30);
		this.CnPanel.add(this.CnEnterBtn);

		this.CnLbl = new JLabel();
		this.CnLbl.setBounds(190, 210, 220, 30);
		this.CnPanel.add(this.CnLbl);

		this.container.add(CnPanel, "CnPanel");
		
		//add rooms panel 1
		this.ArPanel1 = new JPanel();
		this.ArPanel1.setLayout(null);

		this.ArMenuBtn1 = new JButton("Main Menu");
		this.ArMenuBtn1.setBounds(0, 0, 100, 30);
		this.ArPanel1.add(this.ArMenuBtn1);

		this.ArStdBtn = new JButton("Add Standard Room");
		this.ArStdBtn.setBounds(190, 50, 220, 30);
		this.ArPanel1.add(this.ArStdBtn);

		this.ArDelBtn = new JButton("Add Deluxe Room");
		this.ArDelBtn.setBounds(190, 90, 220, 30);
		this.ArPanel1.add(this.ArDelBtn);

		this.ArExBtn = new JButton("Add Executive Room");
		this.ArExBtn.setBounds(190, 130, 220, 30);
		this.ArPanel1.add(this.ArExBtn);

		this.container.add(ArPanel1, "ArPanel1");

		//add rooms panel 2
		this.ArPanel2 = new JPanel();
		this.ArPanel2.setLayout(null);

		this.ArMenuBtn2 = new JButton("Main Menu");
		this.ArMenuBtn2.setBounds(0, 0, 100, 30);
		this.ArPanel2.add(this.ArMenuBtn2);

		this.ArTf = new JTextField();
		this.ArTf.setBounds(217, 50, 166, 25);
		this.ArPanel2.add(this.ArTf);

		this.ArEnterBtn = new JButton("Enter");
		this.ArEnterBtn.setBounds(190, 130, 220, 30);
		this.ArPanel2.add(this.ArEnterBtn);

		this.ArLbl = new JLabel();
		this.ArLbl.setBounds(190, 210, 220, 30);
		this.ArPanel2.add(this.ArLbl);

		this.ArTextArea = new JTextArea();
		this.ArTextArea.setBounds(5, 300, 580, 400);
		this.ArTextArea.setEditable(false);
		this.ArPanel2.add(this.ArTextArea);

		this.container.add(ArPanel2, "ArPanel2");

		// remove rooms panel
		this.RRoomPanel = new JPanel();
		this.RRoomPanel.setLayout(null);

		this.RRoomMenuBtn = new JButton("Main Menu");
		this.RRoomMenuBtn.setBounds(0, 0, 100, 30);
		this.RRoomPanel.add(this.RRoomMenuBtn);

		this.RRoomTf = new JTextField();
		this.RRoomTf.setBounds(217, 50, 166, 25);
		this.RRoomPanel.add(this.RRoomTf);

		this.RRoomEnterBtn = new JButton("Enter");
		this.RRoomEnterBtn.setBounds(190, 130, 220, 30);
		this.RRoomPanel.add(this.RRoomEnterBtn);

		this.RRoomLbl = new JLabel();
		this.RRoomLbl.setBounds(190, 210, 220, 30);
		this.RRoomPanel.add(this.RRoomLbl);

		this.RRoomTextArea = new JTextArea();
		this.RRoomTextArea.setBounds(5, 300, 580, 400);
		this.RRoomTextArea.setEditable(false);
		this.RRoomPanel.add(this.RRoomTextArea);

		this.container.add(RRoomPanel, "RRoomPanel");

		// update price panel
		this.UpPanel = new JPanel();
		this.UpPanel.setLayout(null);

		this.UpMenuBtn = new JButton("Main Menu");
		this.UpMenuBtn.setBounds(0, 0, 100, 30);
		this.UpPanel.add(this.UpMenuBtn);

		this.UpTf = new JTextField();
		this.UpTf.setBounds(217, 50, 166, 25);
		this.UpPanel.add(this.UpTf);

		this.UpEnterBtn = new JButton("Enter");
		this.UpEnterBtn.setBounds(190, 130, 220, 30);
		this.UpPanel.add(this.UpEnterBtn);

		this.UpLbl = new JLabel();
		this.UpLbl.setBounds(190, 210, 220, 30);
		this.UpPanel.add(this.UpLbl);
		
		this.container.add(UpPanel, "UpPanel");

		// remove reservation label
		this.RResPanel = new JPanel();
		this.RResPanel.setLayout(null);

		this.RResMenuBtn = new JButton("Main Menu");
		this.RResMenuBtn.setBounds(0, 0, 100, 30);
		this.RResPanel.add(this.RResMenuBtn);
		
		this.RResNameLbl = new JLabel("Name:");
		this.RResNameLbl.setBounds(110, 5, 220, 30);
		this.RResPanel.add(this.RResNameLbl);

		this.RResInLbl = new JLabel("Check-in day:");
		this.RResInLbl.setBounds(110, 25, 220, 30);
		this.RResPanel.add(this.RResInLbl);

		this.RResOutLbl = new JLabel("Check-out day:");
		this.RResOutLbl.setBounds(110, 45, 220, 30);
		this.RResPanel.add(this.RResOutLbl);

		this.RResRoomLbl = new JLabel("Room:");
		this.RResRoomLbl.setBounds(110, 65, 220, 30);
		this.RResPanel.add(this.RResRoomLbl);

		this.RResNameTf = new JTextField();
		this.RResNameTf.setBounds(217, 10, 166, 25);
		this.RResPanel.add(this.RResNameTf);

		this.RResInTf = new JTextField();
		this.RResInTf.setBounds(217, 30, 166, 25);
		this.RResPanel.add(this.RResInTf);

		this.RResOutTf = new JTextField();
		this.RResOutTf.setBounds(217, 50, 166, 25);
		this.RResPanel.add(this.RResOutTf);

		this.RResOutTf = new JTextField();
		this.RResOutTf.setBounds(217, 70, 166, 25);
		this.RResPanel.add(this.RResOutTf);

		this.RResEnterBtn = new JButton("Enter");
		this.RResEnterBtn.setBounds(190, 130, 220, 30);
		this.RResPanel.add(this.RResEnterBtn);

		this.RResLbl = new JLabel();
		this.RResLbl.setBounds(190, 210, 220, 30);
		this.RResPanel.add(this.RResLbl);

		this.RResTextArea = new JTextArea();
		this.RResTextArea.setBounds(5, 300, 580, 400);
		this.RResTextArea.setEditable(false);
		this.RResPanel.add(this.RResTextArea);

		this.container.add(RResPanel, "RResPanel");

		//-------------------------------------------
		this.mainFrame.setVisible(true);
	}

	//methods
	public Container getContainer() {
		return this.container;
	}

	public CardLayout getCardLayout() {
		return this.cardLayout;
	}

	public void setMainMenuBtn1Listener(ActionListener actionListener) {
		this.mainMenuBtn1.addActionListener(actionListener);
	}

	//main panel components
	public void setCreateHotelBtnListener(ActionListener actionListener) {
		this.createHotelBtn.addActionListener(actionListener);
	}

	public void setViewHotelBtnListener(ActionListener actionListener) {
		this.viewHotelBtn.addActionListener(actionListener);
	}

	public void setManageHotelBtnListener(ActionListener actionListener) {
		this.manageHotelBtn.addActionListener(actionListener);
	} 

	public void setSimulateBtnListener(ActionListener actionListener) {
		this.simulateBtn.addActionListener(actionListener);
	}

	public void setDatePriceBtnListener(ActionListener actionListener) {
		this.datePriceBtn.addActionListener(actionListener);
	}

	public void setMainPanelLbl(String text) {
		this.mainPanelLbl.setText(text);
	}

	//create hotel components
	public String getHotelNameText() {
		return this.createHotelTf.getText();
	}

	public void setEnterHotelBtn1Listener(ActionListener actionListener) {
		this.enterHotelBtn1.addActionListener(actionListener);
	}

	public void setCreateHotelLbl(String text) {
		this.createHotelLbl.setText(text);
	}
	
	public void clearCreateHotelTf() {
		this.createHotelTf.setText("");
	}

	//view hotel panel 1 components
	public void setMainMenuBtn2Listener(ActionListener actionListener) {
		this.mainMenuBtn2.addActionListener(actionListener);
	}

	public void setViewHotelPanelTfText(String text) {
		this.viewHotelPanelTf.setText(text);
	}

	public String getViewHotelPanelTfText() {
		return this.viewHotelPanelTf.getText();
	}

	public void setVhEnterBtnListener(ActionListener actionListener) {
		this.VhEnterBtn.addActionListener(actionListener);
	}

	public void setVhTextArea(String text) {
		this.VhTextArea.setText(text);
	}

	public void setVhLblText(String text) {
		this.VhLbl.setText(text);
	}

	//view hotel panel2 components
	public void setVhMainMenuListener(ActionListener actionListener) {
		this.VhMainMenuBtn.addActionListener(actionListener);
	}

	public void setVHBtn1Listener(ActionListener actionListener) {
		this.VHBtn1.addActionListener(actionListener);
	}

	public void setVHBtn2Listener(ActionListener actionListener) {
		this.VHBtn2.addActionListener(actionListener);
	}

	public void setVHBtn3Listener(ActionListener actionListener) {
		this.VHBtn3.addActionListener(actionListener);
	}

	//available and booked rooms components
	public void setAbMainMenuBtnListener(ActionListener actionListener) {
		this.AbMainMenuBtn.addActionListener(actionListener);
	}

	public void setAbEnterBtnListener(ActionListener actionListener) {
		this.AbEnterBtn.addActionListener(actionListener);
	}

	public String getAbEnterTfText() {
		return this.AbEnterTf.getText();
	}

	public void setAbEnterTfText(String text) {
		this.AbEnterTf.setText(text);
	}

	public void setAbLblText(String text) {
		this.AbLbl.setText(text);
	}

	public void setAbTextArea(String text) {
		this.AbTextArea.setText(text);
	}

	public void clearAbTextArea() {
		this.AbTextArea.setText("");
	}

	//info room components
	public void setIRoomMenuListener(ActionListener actionListener) {
		this.IRoomMenuBtn.addActionListener(actionListener);
	}

	public void setIRoomEnterBtnListener(ActionListener actionListener) {
		this.IRoomEnterBtn.addActionListener(actionListener);
	}

	public String getIRoomTfText() {
		return this.IRoomTf.getText();
	}

	public void setIRoomTfText(String text) {
		this.IRoomTf.setText(text);
	}

	public void setIRoomLblText(String text) {
		this.IRoomLbl.setText(text);
	}

	public void setIRoomTextArea(String text) {
		this.IRoomTextArea.setText(text);
	}

	//info reservation components
	public void setIResMenuListener(ActionListener actionListener) {
		this.IResMenuBtn.addActionListener(actionListener);
	}

	public void setIResEnterBtnListener(ActionListener actionListener) {
		this.IResEnterBtn.addActionListener(actionListener);
	}

	public String getIResNameTfText() {
		return this.IResNameTf.getText();
	}

	public String getIResInTfText() {
		return this.IResInTf.getText();
	}

	public String getIResOutTfText() {
		return this.IResOutTf.getText();
	}

	public String getIResRoomTfText() {
		return this.IResRoomTf.getText();
	}

	public void clearIResTfText() {
		this.IResNameTf.setText("");
		this.IResInTf.setText("");
		this.IResOutTf.setText("");
		this.IResRoomTf.setText("");
	}

	public void setIResLblText(String text) {
		this.IResLbl.setText(text);
	}

	public void setIResTextArea(String text) {
		this.IResTextArea.setText(text);
	}

	//manage hotel panel 1 components
	public void setMhMenuBtn1Listener(ActionListener actionListener) {
		this.MhMenuBtn1.addActionListener(actionListener);
	}

	public void setMhTfText(String text) {
		this.MhTf.setText(text);
	}

	public String getMhTfText() {
		return this.MhTf.getText();
	}

	public void setMhEnterBtnListener(ActionListener actionListener) {
		this.MhEnterBtn.addActionListener(actionListener);
	}

	public void setMhTextArea(String text) {
		this.MhTextArea.setText(text);
	}

	public void setMhLblText(String text) {
		this.MhLbl.setText(text);
	}

	//manage hotel panel 2 components
	public void setMhMenuBtn2Listener(ActionListener actionListener) {
		this.MhMenuBtn2.addActionListener(actionListener);
	}

	public void setMhBtn1Listener(ActionListener actionListener) {
		this.MhBtn1.addActionListener(actionListener);
	}

	public void setMhBtn2Listener(ActionListener actionListener) {
		this.MhBtn2.addActionListener(actionListener);
	}

	public void setMhBtn3Listener(ActionListener actionListener) {
		this.MhBtn3.addActionListener(actionListener);
	}

	public void setMhBtn4Listener(ActionListener actionListener) {
		this.MhBtn4.addActionListener(actionListener);
	}

	public void setMhBtn5Listener(ActionListener actionListener) {
		this.MhBtn5.addActionListener(actionListener);
	}

	public void setMhBtn6Listener(ActionListener actionListener) {
		this.MhBtn6.addActionListener(actionListener);
	}

	public void setMhLbl2Text(String text) {
		this.MhLbl2.setText(text);
	}

	//change hotel name components
	public void setCnMenuBtnListener(ActionListener actionListener) {
		this.CnMenuBtn.addActionListener(actionListener);
	}

	public void setCnTfText(String text) {
		this.CnTf.setText(text);
	}

	public String getCnTfText() {
		return this.CnTf.getText();
	}

	public void setCnEnterBtnListener(ActionListener actionListener) {
		this.CnEnterBtn.addActionListener(actionListener);
	}

	public void setCnLblText(String text) {
		this.CnLbl.setText(text);
	}

	// add room panel 1 components
	public void setArMenuBtn1Listener(ActionListener actionListener) {
		this.ArMenuBtn1.addActionListener(actionListener);
	}

	public void setArStdBtnListener(ActionListener actionListener) {
		this.ArStdBtn.addActionListener(actionListener);
	}

	public void setArDelBtnListener(ActionListener actionListener) {
		this.ArDelBtn.addActionListener(actionListener);
	}

	public void setArExBtnListener(ActionListener actionListener) {
		this.ArExBtn.addActionListener(actionListener);
	}

	//add room panel 2 components
	public void setArMenuBtn2Listener(ActionListener actionListener) {
		this.ArMenuBtn2.addActionListener(actionListener);
	}

	public void setArTfText(String text) {
		this.ArTf.setText(text);
	}

	public String getArTfText() {
		return this.ArTf.getText();
	}

	public void setArEnterBtnListener(ActionListener actionListener) {
		this.ArEnterBtn.addActionListener(actionListener);
	}

	public void setArLblText(String text) {
		this.ArLbl.setText(text);
	}

	public void setArTextArea(String text) {
		this.ArTextArea.setText(text);
	}

	//remove rooms components
	public void setRRoomMenuBtnListener(ActionListener actionListener) {
		this.RRoomMenuBtn.addActionListener(actionListener);
	}

	public void setRRoomTfText(String text) {
		this.RRoomTf.setText(text);
	}

	public String getRRoomTfText() {
		return this.RRoomTf.getText();
	}

	public void setRRoomEnterBtnListener(ActionListener actionListener) {
		this.RRoomEnterBtn.addActionListener(actionListener);
	}

	public void setRRoomLblText(String text) {
		this.RRoomLbl.setText(text);
	}

	public void setRRoomTextArea(String text) {
		this.RRoomTextArea.setText(text);
	}

	// update base price components
	public void setUpMenuBtnListener(ActionListener actionListener) {
		this.UpMenuBtn.addActionListener(actionListener);
	}

	public void setUpTfText(String text) {
		this.UpTf.setText(text);
	}

	public String getUpTfText() {
		return this.UpTf.getText();
	}

	public void setUpEnterBtnListener(ActionListener actionListener) {
		this.UpEnterBtn.addActionListener(actionListener);
	}

	public void setUpLblText(String text) {
		this.UpLbl.setText(text);
	}

	//remove reservation components
	public void setRResMenuBtnListener(ActionListener actionListener) {
		this.RResMenuBtn.addActionListener(actionListener);
	}

	public void setRResEnterBtnListener(ActionListener actionListener) {
		this.RResEnterBtn.addActionListener(actionListener);
	}

	public String getRResNameTfText() {
		return this.RResNameTf.getText();
	}

	public String getRResInTfText() {
		return this.RResInTf.getText();
	}

	public String getRResOutTfText() {
		return this.RResOutTf.getText();
	}

	public String getRResRoomTfText() {
		return this.RResRoomTf.getText();
	}

	public void clearRResTfText() {
		this.RResNameTf.setText("");
		this.RResInTf.setText("");
		this.RResOutTf.setText("");
		this.RResRoomTf.setText("");
	}

	public void setRResLblText(String text) {
		this.RResLbl.setText(text);
	}

	public void setRResTextArea(String text) {
		this.RResTextArea.setText(text);
	}
}	
