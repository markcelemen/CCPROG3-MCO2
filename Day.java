public class Day {
	private int day;
	private double rate;

	public Day(int day, double rate) {
		this.day = day;
		this.rate = rate;
	}

	public int getDay() {
		return day;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}