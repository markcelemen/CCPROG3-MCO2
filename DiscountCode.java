public interface DiscountCode {

	/**
	 * Applies a discount to the given reservation.
	 *
	 * @param reservation the reservation to which the discount will be applied
	 * @return true if the discount was successfully applied, false otherwise
	 */
	boolean applyDiscount(Reservation reservation);
}
