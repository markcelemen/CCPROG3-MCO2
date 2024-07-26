public class ExecutiveRoom extends Room {
    private Hotel hotel;

    public ExecutiveRoom(String name, Hotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    @Override
    public double getPrice() {
        return this.hotel.getCostPerNight() * 1.35; // Executive room rate is 35% more than the base rate
    }
}