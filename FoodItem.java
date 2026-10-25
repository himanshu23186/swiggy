public class FoodItem {
    private final String name;
    private final double price;

    public FoodItem(String name, double price) {
        if (name == null || name.trim().isEmpty() || price < 0) {
            throw new IllegalArgumentException("Invalid food item.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
