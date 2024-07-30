public class DeluxeRoom extends Room {
    private Hotel hotel;

    /**
     * Constructs a DeluxeRoom with a specified name and associated hotel.
     *
     * @param name the name (number) of the room
     * @param hotel the hotel to which the room belongs
     */
    public DeluxeRoom(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    /**
     * Calculates the price of the deluxe room.
     * The price is 20% more than the base rate provided by the hotel.
     *
     * @return the price of the deluxe room per night
     */
    @Override
    public double getPrice() {
        return this.hotel.getCostPerNight() * 1.2; // Deluxe room rate is 20% more than the base rate
    }
}
