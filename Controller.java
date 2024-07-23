import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private HRS HRS;

	public Controller(HRS HRS, View view) {
		this.view = view;
		this.HRS = HRS;
	}
}