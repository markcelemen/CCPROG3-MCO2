import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
	private JFrame mainFrame;
	private JPanel mainPanel, createHotelPanel, viewHotelPanel, 
					viewHotelPanel2, AbPanel, IRoomPanel;
	private JLabel mainPanelLbl, createHotelLbl, VhLbl, 
						AbLbl, IRoomLbl;
	private JTextField createHotelTf, 
					   viewHotelPanelTf, AbEnterTf, IRoomTf;
	private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, simulateBtn, datePriceBtn, // main menu buttons
					mainMenuBtn1, enterHotelBtn1, // create hotel buttons
					VhMainMenuBtn, VhEnterBtn, mainMenuBtn2, VHBtn1, VHBtn2, VHBtn3, // view hotel buttons
						AbMainMenuBtn, AbEnterBtn,
						IRoomMenuBtn, IRoomEnterBtn
					;
	private JTextArea VhTextArea, AbTextArea, IRoomTextArea;
	private Container container;
	private CardLayout cardLayout;
	
	public View() {
		this.mainFrame = new JFrame();
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
		this.createHotelBtn.setBounds(190, 10, 220, 30);
		this.mainPanel.add(createHotelBtn);

		this.viewHotelBtn = new JButton("View Hotel");
		this.viewHotelBtn.setBounds(190, 50, 220, 30);
		this.mainPanel.add(viewHotelBtn);

		this.manageHotelBtn = new JButton("Manage Hotel");
		this.manageHotelBtn.setBounds(190, 90, 220, 30);
		this.mainPanel.add(manageHotelBtn);

		this.simulateBtn = new JButton("Simulate Booking");
		this.simulateBtn.setBounds(190, 130, 220, 30);
		this.mainPanel.add(simulateBtn);

		this.datePriceBtn = new JButton("Modify Date Price");
		this.datePriceBtn.setBounds(190, 170, 220, 30);
		this.mainPanel.add(datePriceBtn);

		this.mainPanelLbl = new JLabel("");
		this.mainPanelLbl.setBounds(190, 210, 220, 30);
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

		// Info room panel
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

	public void setMainMenuBtn2Listener(ActionListener actionListener) {
		this.mainMenuBtn2.addActionListener(actionListener);
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

	//view hotel components
	public void setVhMainMenuListener(ActionListener actionListener) {
		this.VhMainMenuBtn.addActionListener(actionListener);
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

	public void setVhLblText(String text) {
		this.VhLbl.setText(text);
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

	public void setVhTextArea(String text) {
		this.VhTextArea.setText(text);
	}

	//available and booked rooms panel
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

	//info room panel
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
}	
