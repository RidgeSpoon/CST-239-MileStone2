package App;

class Product {
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;
    
    
    //Constructs a SalableProduct with the specified attributes.
    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    
    //Retrieves the name of the product.
    
    public String getName() {
        return name;
    }

    
    //Retrieves the current quantity of the product in the inventory.
    public int getQuantity() {
        return quantity;
    }

    // Instead of a setQuantity method, we can provide a method to adjust the quantity
    public void adjustQuantity(int quantityDelta) {
        this.quantity += quantityDelta;
    }
    
}