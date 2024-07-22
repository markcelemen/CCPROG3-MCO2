public class PaydayDiscount implements DiscountCode {

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