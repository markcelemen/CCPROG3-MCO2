public class PaydayDiscount implements DiscountCode {

	/**
	 * Applies a discount to a reservation if any of the reservation's days
	 * fall on the 15th or 30th of the month.
	 *
	 * @param reservation the reservation to which the discount will be applied
	 * @return true if a discount was applied, false otherwise
	 */
	@Override
	public boolean applyDiscount(Reservation reservation) {
		boolean value = false;
		for (Day d : reservation.getDayList()) {
			if (d.getDay() == 15 || d.getDay() == 30) {
				value = true;
				break;
			}
		}
		if (value == true) {
			double discount = 0.07; // 7% discount
			double newPrice = reservation.getPrice() * (1 - discount);
			reservation.setPrice(newPrice);
		}
		return value;
	}
}
