import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("\nFood Menu:");
            System.out.println("1. Burger - Rs. 120");
            System.out.println("2. Pizza - Rs. 250");
            System.out.println("3. Pasta - Rs. 180");
            System.out.println("0. Checkout");

            System.out.print("Enter food number (0 to checkout): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            String foodName;
            double price;

            switch (choice) {
                case 1:
                    foodName = "Burger";
                    price = 120;
                    break;
                case 2:
                    foodName = "Pizza";
                    price = 250;
                    break;
                case 3:
                    foodName = "Pasta";
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid food choice!");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                continue;
            }

            cart.addItem(foodName, price, quantity);
            System.out.println(quantity + " x " + foodName + " added to cart.");
        }

        cart.display();
        if (!cart.isEmpty()) {
            System.out.println("Order placed successfully!");
        }

        scanner.close();
    }
}
