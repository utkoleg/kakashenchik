package core;

public class Drink extends Item {
    private final String type = "drink";
    public Drink() {
    }

    public Drink(Long id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
