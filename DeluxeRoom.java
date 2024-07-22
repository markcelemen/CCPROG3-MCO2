public class DeluxeRoom extends Room {
    private double basePrice;

    public DeluxeRoom(String name, double basePrice) {
        super(name);
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice() {
        return basePrice * 1.2; // Deluxe room rate is 20% more than the base rate
    }
}