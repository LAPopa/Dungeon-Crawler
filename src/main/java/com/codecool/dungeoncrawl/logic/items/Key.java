package com.codecool.dungeoncrawl.logic.items;

public class Key extends NonPerishableItem{

    private String name;
    private int numberOfUses;


    public Key(String name, int ID, int durability, int numberOfUses) {
        super(name, ID, durability);
        this.numberOfUses = numberOfUses;
    }
}
