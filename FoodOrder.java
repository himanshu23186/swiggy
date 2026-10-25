import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            FoodMenu.display();
            System.out.println("4. Remove an item");
            System.out.println("5. Clear cart");
            System.out.println("0. Checkout");

            System.out.print("Enter food number (0 to checkout): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice == 5) {
                cart.clear();
                System.out.println("Cart cleared.");
                continue;
            }
            if (choice == 4) {
                cart.display();
                System.out.print("Enter item number to remove (1-3): ");
                int removeChoice = scanner.nextInt();
                String item = removeChoice == 1 ? "Burger"
                        : removeChoice == 2 ? "Pizza"
                        : removeChoice == 3 ? "Pasta" : null;
                System.out.println(item != null && cart.removeItem(item)
                        ? item + " removed from cart." : "Item not found.");
                continue;
            }

            FoodItem foodItem = FoodMenu.getItem(choice);
            if (foodItem == null) {
                System.out.println("Invalid food choice!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                continue;
            }

            cart.addItem(foodItem.getName(), foodItem.getPrice(), quantity);
            System.out.println(quantity + " x " + foodItem.getName() + " added to cart.");
        }

        cart.display();
        if (!cart.isEmpty()) {
            System.out.println("Order placed successfully!");
        }

        scanner.close();
    }
}
