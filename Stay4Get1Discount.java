public class Stay4Get1Discount implements DiscountCode {

    @Override
    public boolean applyDiscount(Reservation reservation) {
		boolean value = false;
        if (reservation.getDayList().size() >= 5) {
            reservation.getDayList().get(0).setRate(0.0); // sets the first day in the list to a rate of 0
			value = true;

			double newPrice = 0.0;
			for (Day d : reservation.getDayList()) // updates the price
				newPrice += (reservation.getRoom().getPrice() * d.getRate());
            reservation.setPrice(newPrice);
        }
		return value;
    }
}