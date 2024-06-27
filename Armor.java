package App;

//Armor class now implements Salable and extends Item
class Armor extends Item {
private int defense;
private String type;


//Constructs an armor with specific properties.

public Armor(String name, String description, double price, int quantity, int defense, String type) {
   super(name, description, price, quantity);
   this.defense = defense;
   this.type = type;
}

@Override
public String getType() {
   return type;
}


}