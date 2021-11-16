package com.codecool.dungeoncrawl.logic.items;

public abstract class Item {

    private String name;
    private int ID;

    public Item(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
