public class IWorkHereDiscount implements DiscountCode {

    /**
     * Applies a 10% discount to the given reservation.
     * The discount is applied by reducing the reservation's price by 10%.
     *
     * @param reservation the reservation to which the discount will be applied
     * @return true indicating that the discount was successfully applied
     */
    @Override
    public boolean applyDiscount(Reservation reservation) {
        double discount = 0.10; // 10% discount
        double newPrice = reservation.getPrice() * (1 - discount);
        reservation.setPrice(newPrice);

        return true;
    }
}
