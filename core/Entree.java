package core;

public class Entree extends Item {
    private final String type = "entree";

    public Entree() {
    }

    public Entree(Long id,String name, String description, int price) {
        super(id, name, description, price);
    }
}
