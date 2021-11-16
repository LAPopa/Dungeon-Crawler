package com.codecool.dungeoncrawl.logic.items;

public abstract class PerishableItem extends Item{

    private int expirationTime;

    public abstract boolean canBePickedUp();
    public abstract boolean canBeUsed();

    public PerishableItem(String name, int ID,int expirationTime) {
        super(name, ID);
        this.expirationTime = expirationTime;
    }
}
