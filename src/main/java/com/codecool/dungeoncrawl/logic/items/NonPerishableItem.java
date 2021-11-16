package com.codecool.dungeoncrawl.logic.items;

public abstract class NonPerishableItem extends Item{

    private String name;
    private int durability;

    public NonPerishableItem(String name, int ID,int durability) {
        super(name, ID);
        this.durability = durability;
    }
}
