import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(String foodName, double price, int quantity) {
        if (foodName == null || foodName.trim().isEmpty()) {
            throw new IllegalArgumentException("Food name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        items.add(new CartItem(foodName, price, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\nYour cart:");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + " x " + item.getFoodName()
                    + " - Rs. " + item.getSubtotal());
        }
        System.out.println("Total amount: Rs. " + getTotal());
    }

    private static class CartItem {
        private final String foodName;
        private final double price;
        private final int quantity;

        private CartItem(String foodName, double price, int quantity) {
            this.foodName = foodName;
            this.price = price;
            this.quantity = quantity;
        }

        private String getFoodName() {
            return foodName;
        }

        private int getQuantity() {
            return quantity;
        }

        private double getSubtotal() {
            return price * quantity;
        }
    }
}
