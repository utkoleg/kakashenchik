package core;

import emuns.CommandEnum;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {

    private CommandEnum operationType;
    private ArrayList<Item> items = new ArrayList<>();
    private Long id;
    private Item item;

    public PackageData() {
    }

    public PackageData(CommandEnum operationType, Item item) {
        this.operationType = operationType;
        this.item = item;
    }

    public PackageData(CommandEnum operationType, long id) {
        this.operationType = operationType;
        this.id = id;
    }
    public PackageData(CommandEnum operationType) {
        this.operationType = operationType;
    }



    public CommandEnum getOperationType() {
        return operationType;
    }

    public void setOperationType(CommandEnum operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
