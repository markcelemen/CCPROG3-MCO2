public class ExecutiveRoom extends Room {
    private double basePrice;

    public ExecutiveRoom(String name, double basePrice) {
        super(name);
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice() {
        return basePrice * 1.35; // Executive room rate is 35% more than the base rate
    }
}