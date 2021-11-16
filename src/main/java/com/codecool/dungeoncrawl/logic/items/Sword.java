package com.codecool.dungeoncrawl.logic.items;

public class Sword extends NonPerishableItem{

    private String name;
    private int damageInflicted;

    public Sword(String name, int ID, int durability,int damageInflicted) {
        super(name, ID, durability);
        this.damageInflicted = damageInflicted;
    }


//    public Sword(String name, int damageInflicted) {
//        this.name = name;
//        this.damageInflicted = damageInflicted;
//    }

}
