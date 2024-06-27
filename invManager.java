package App;

import java.util.ArrayList;
import java.util.List;

class InventoryManager {
    private List<Product> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public void populateInventory() {
        //Hardcode initial inventory
        Weapon weapon1 = new Weapon("Combat Knife", "Sharp and one hit", 50.0, 10, 20, "Melee");
        Weapon weapon2 = new Weapon("MP5", "Great at midranged attacks", 40.0, 15, 15, "Ranged");
        Armor armor1 = new Armor("Satchel", "Heavy protection", 80.0, 5, 30, "Heavy");
        Armor armor2 = new Armor("Upgraded Satchel", "Light and flexible", 30.0, 8, 15, "Light");
        Health health = new Health("Stimulant", "Restores health", 10.0, 20, "Healing");

        inventory.add(weapon1);
        inventory.add(weapon2);
        inventory.add(armor1);
        inventory.add(armor2);
        inventory.add(health);
    }

    public void purchaseProduct(Product product, int quantity) {
        for (Product inventoryProduct : inventory) {
            if (inventoryProduct.equals(product)) {
                if (inventoryProduct.getQuantity() >= quantity) {
                    // Decrease the quantity of the product in the inventory
                    inventoryProduct.adjustQuantity(-quantity);
                    System.out.println("Purchase successful! Thank you for buying " + quantity + " " + product.getName() + ".");
                } else {
                    System.out.println("Not enough quantity available for " + product.getName() + ".");
                }
                return;
            }
        }
        System.out.println(product.getName() + " not found in the inventory.");
    }

    public void cancelPurchase(Product product, int quantity) {
        for (Product inventoryProduct : inventory) {
            if (inventoryProduct.equals(product)) {
                // Increase the quantity of the product in the inventory
                inventoryProduct.adjustQuantity(quantity);
                System.out.println("Purchase canceled for " + quantity + " " + product.getName() + ".");
                return;
            }
        }
        System.out.println(product.getName() + " not found in the inventory.");
    }
    
    public List<Product> getInventory() {
        return this.inventory;
    }
}

