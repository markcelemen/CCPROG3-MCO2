public class StandardRoom extends Room {
    private Hotel hotel;

    public StandardRoom(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    @Override
    public double getPrice() {
        return this.hotel.getCostPerNight(); // Standard room rate is equal to the base rate
    }
}