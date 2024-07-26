public class DeluxeRoom extends Room {
    private Hotel hotel;

    public DeluxeRoom(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    @Override
    public double getPrice() {
        return this.hotel.getCostPerNight() * 1.2; // Deluxe room rate is 20% more than the base rate
    }
}