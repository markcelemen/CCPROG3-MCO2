public class Day {
	private int day;
	private double rate;

	/**
	 * Constructor to initialize the day and rate.
	 *
	 * @param day the day of the month
	 * @param rate the rate for the day
	 */
	public Day(int day, double rate) {
		this.day = day;
		this.rate = rate;
	}

	/**
	 * Gets the day of the month.
	 *
	 * @return the day of the month
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Gets the rate for the day.
	 *
	 * @return the rate for the day
	 */
	public double getRate() {
		return this.rate;
	}

	/**
	 * Sets the rate for the day.
	 *
	 * @param rate the new rate for the day
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
}
