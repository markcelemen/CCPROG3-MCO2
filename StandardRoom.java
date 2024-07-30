public class StandardRoom extends Room {
    private Hotel hotel;

    /**
     * Constructor for a StandardRoom.
     * Initializes the room with a given name and associated hotel.
     *
     * @param name the name (number) of the room
     * @param hotel the hotel to which this room belongs
     */
    public StandardRoom(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    /**
     * Gets the price per night for the standard room.
     * The price is determined by the hotel's cost per night.
     *
     * @return the price of the room per night
     */
    @Override
    public double getPrice() {
        return this.hotel.getCostPerNight(); // Standard room rate is equal to the base rate
    }
}
