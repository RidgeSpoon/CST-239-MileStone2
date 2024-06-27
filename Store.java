package App;

import java.util.Scanner;

public class Store {
	private String storeName;
    private InventoryManager invManager;

    public Store(String storeName) {
        this.storeName = storeName;
        this.invManager = new InventoryManager();
    }

    public void displayWelcome() {
        System.out.println("Welcome to " + storeName + "!");
    }

    public void displayActions() {
        System.out.println("1. Display Inventory");
        System.out.println("2. Purchase Product");
        System.out.println("3. Cancel Purchase");
    }

    
    public void executeAction(int action) {
        switch (action) {
            case 1:
                displayInventory();
                break;
            case 2:
                purchaseOrCancel(true); // Purchase
                break;
            case 3:
                purchaseOrCancel(false); // Cancel
                break;
            default:
                System.out.println("Invalid action. Please choose a valid action.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : invManager.getInventory()) {
            System.out.println(product.name + " - " + product.description + " - $" + product.price + " - Quantity: " + product.quantity);
        }
    }

   
    public void purchaseOrCancel(boolean isPurchase) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the product: ");
        String productName = scanner.nextLine();

        for (Product product : invManager.getInventory()) {
            if (product.name.equalsIgnoreCase(productName)) {
                int quantity = readValidQuantity();
                if (isPurchase) {
                    invManager.purchaseProduct(product, quantity);
                    
                } 
                else 
                {
                    invManager.cancelPurchase(product, quantity);

                }
                return;
            }
        }

        System.out.println("Product not found in the inventory. Please enter a valid product name.");
    }

    private int readValidQuantity() {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.print("Enter the quantity: ");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
    
    
    public void displayFeedback(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Store store = new Store("Gotham City Store");
        store.displayWelcome();
        store.invManager.populateInventory();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            store.displayActions();
            System.out.print("Choose an action (0 to exit): ");
            int userAction = scanner.nextInt();

            if (userAction == 0) {
                System.out.println("Exiting. Thank you for visiting " + store.storeName + "!");
                break;
            }

            store.executeAction(userAction);
            scanner.nextLine(); // Consume the newline character after reading the integer

            System.out.print("Do you want to choose another action? (yes/no): ");
            String continueChoice = scanner.nextLine().toLowerCase();
            if (!continueChoice.equals("yes")) {
                System.out.println("Exiting. Thank you for visiting " + store.storeName + "!");
                break;
            }
        }
    }
}