import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class View {
	private JFrame mainFrame;
	private JPanel panel;
	private JLabel enterLbl, feedbackLbl;
	private JTextField textField;
	private JButton button;

	public View() {
		this.mainFrame = new JFrame();
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);

		this.panel = new JPanel();
		this.mainFrame.add(this.panel);

		this.panel.setLayout(null);

		this.enterLbl = new JLabel("Enter Input : ");
		this.enterLbl.setBounds(10, 20, 80, 25);
		this.panel.add(this.enterLbl);

		this.textField = new JTextField();
		this.textField.setBounds(100, 20, 165, 25);
		this.panel.add(this.textField);

		this.button = new JButton();
		this.button.setBounds(10, 80, 80, 25);
		this.panel.add(this.button);

		this.feedbackLbl = new JLabel("");

		this.mainFrame.setVisible(true);
	}

	public void setButtonListener(ActionListener actionListener) {
		this.button.addActionListener(actionListener);
	}

	public JFrame getFrame() {
		return this.mainFrame;
	}
}