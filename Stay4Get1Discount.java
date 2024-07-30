public class Stay4Get1Discount implements DiscountCode {

    /**
     * Applies the "Stay 4, Get 1 Free" discount to the given reservation.
     *
     * If the reservation includes 5 or more days, the rate for the first day in the list is set to 0,
     * and the total price of the reservation is updated accordingly.
     *
     * @param reservation the reservation to which the discount will be applied
     * @return true if the discount was applied (i.e., the reservation has 5 or more days), false otherwise
     */
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