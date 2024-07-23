import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
	private JFrame mainFrame;
	private JPanel mainPanel, createHotelPanel;
	private JLabel mainPanelLbl, createHotelLbl;
	private JTextField createHotelTf;
	private JButton mainMenuBtn, createHotelBtn, viewHotelBtn, manageHotelBtn, simulateBtn, datePriceBtn,
					enterHotelBtn1;
	private Container container;
	private CardLayout cardLayout;
	
	public View() {
		this.mainFrame = new JFrame();
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);

		this.container = this.mainFrame.getContentPane();
		this.cardLayout = new CardLayout();
		this.container.setLayout(cardLayout);

		this.mainMenuBtn = new JButton("Main Menu");
		this.mainMenuBtn.setBounds(0, 0, 100, 30);
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
		this.createHotelPanel = new JPanel();
		this.createHotelPanel.setLayout(null);

		this.createHotelTf = new JTextField();
		this.createHotelTf.setBounds(217, 50, 166, 25);
		this.createHotelPanel.add(createHotelTf);

		this.enterHotelBtn1 = new JButton("Enter");
		this.enterHotelBtn1.setBounds(190, 130, 220, 30);
		this.createHotelPanel.add(enterHotelBtn1);

		this.createHotelLbl = new JLabel("");
		this.createHotelLbl.setBounds(190, 210, 220, 30);
		this.createHotelPanel.add(createHotelLbl);

		this.createHotelPanel.add(this.mainMenuBtn);

		this.container.add(createHotelPanel, "createHotelPanel");
		//-------------------------------------------
		this.mainFrame.setVisible(true);
	}

	public Container getContainer() {
		return this.container;
	}

	public CardLayout getCardLayout() {
		return this.cardLayout;
	}

	public void setMainMenuBtnListener(ActionListener actionListener) {
		this.mainMenuBtn.addActionListener(actionListener);
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
}