public class ExecutiveRoom extends Room {
    private Hotel hotel;

    /**
     * Constructs an ExecutiveRoom with a specified name and associated hotel.
     *
     * @param name the name (number) of the room
     * @param hotel the hotel to which this executive room belongs
     */
    public ExecutiveRoom(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    /**
     * Gets the price of the executive room.
     * The price is calculated as 135% of the hotel's base rate per night.
     *
     * @return the price of the executive room per night
     */
    @Override
    public double getPrice() {
        return this.hotel.getCostPerNight() * 1.35; // Executive room rate is 35% more than the base rate
    }
}
