import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	private JFrame mainFrame;
	private JPanel panel;

	public View() {
		this.mainFrame = new JFrame();
		this.panel = new JPanel();
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setVisible(true);
	}
}