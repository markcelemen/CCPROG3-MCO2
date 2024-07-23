public class Main {
	public static void main (String[] args) {
		View view = new View();
		HRS HRS = new HRS();
		Controller Controller = new Controller(HRS, view);
	}
}