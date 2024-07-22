public class StandardRoom extends Room {
    private double basePrice;

    public StandardRoom(String name, double basePrice) {
        super(name);
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice() {
        return basePrice; // Standard room rate is equal to the base rate
    }
}