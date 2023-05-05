package core;

public class Dessert extends Item {
    private final String type = "dessert";
    public Dessert() {
    }

    public Dessert(Long id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
