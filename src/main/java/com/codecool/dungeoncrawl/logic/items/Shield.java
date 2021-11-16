package com.codecool.dungeoncrawl.logic.items;

public class Shield extends NonPerishableItem{

    private String name;
    private int damageDeflected;


    public Shield(String name, int ID, int durability, int damageDeflected) {
        super(name, ID, durability);
        this.damageDeflected = damageDeflected;
    }
}
