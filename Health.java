package App;

class Health extends Item {
	 private String type;

	 public Health(String name, String description, double price, int quantity, String type) {
	     super(name, description, price, quantity);
	     this.type = type;
	 }

	 @Override
	 public String getType() {
	     return type;
	 }
}