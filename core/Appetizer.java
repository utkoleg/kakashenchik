package core;

public class Appetizer extends Item {
    private final String type = "apperizer";
    public Appetizer() {
    }

    public Appetizer(Long id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
