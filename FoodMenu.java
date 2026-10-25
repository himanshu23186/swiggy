public class FoodMenu {
    private static final FoodItem[] ITEMS = {
        new FoodItem("Burger", 120),
        new FoodItem("Pizza", 250),
        new FoodItem("Pasta", 180)
    };

    public static void display() {
        System.out.println("\nFood Menu:");
        for (int i = 0; i < ITEMS.length; i++) {
            System.out.println((i + 1) + ". " + ITEMS[i].getName()
                    + " - Rs. " + ITEMS[i].getPrice());
        }
    }

    public static FoodItem getItem(int choice) {
        if (choice < 1 || choice > ITEMS.length) {
            return null;
        }
        return ITEMS[choice - 1];
    }
}
