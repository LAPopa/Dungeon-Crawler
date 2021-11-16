package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
//    private String name;
//    private int health;
//    private int strength;
    public Skeleton(Cell cell) {

        super(cell);
        this.setHealth(25);
        this.setStrength(5);
    }

    @Override
    public String getTileName() {

        return "skeleton";
    }
}
