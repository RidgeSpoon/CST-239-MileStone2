package App;
		
		//Interface for all salable products
		interface Salable 
		{
		// Get the type of the product ("Weapon", "Armor", "Health").
		    
		 String getType();
		}

		//Abstract class for common properties among Health, Armor, and Weapon
		abstract class Item extends Product implements Product
		{
		
		
			
		//Constructs an item with common properties.
		 public Item(String name, String description, double price, int quantity) 
		 {
		     super(name, description, price, quantity);
		 }
	
		}
