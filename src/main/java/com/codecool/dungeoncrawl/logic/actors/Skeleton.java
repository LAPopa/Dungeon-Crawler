package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    private int health;
    public Skeleton(Cell cell,int health) {
        super(cell);
        this.health=health;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
