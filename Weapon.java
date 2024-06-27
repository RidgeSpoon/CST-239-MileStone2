package App;

public class Weapon extends Item {
	
	private int damage;
	 private String type;

	 public Weapon(String name, String description, double price, int quantity, int damage, String type) {
	     super(name, description, price, quantity);
	     this.damage = damage;
	     this.type = type;
	 }

	 @Override
	 public String getType() {
	     return type;
	 }
	
}
