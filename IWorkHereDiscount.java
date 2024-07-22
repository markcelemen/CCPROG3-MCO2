public class IWorkHereDiscount implements DiscountCode {
	@Override
    public boolean applyDiscount(Reservation reservation) {
        double discount = 0.10; // 10% discount
        double newPrice = reservation.getPrice() * (1 - discount);
        reservation.setPrice(newPrice);

		return true;
    }
}