package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Scarab extends Actor {

    public Scarab(Cell cell) {
        super(cell);
        this.setHealth(10);
        this.setStrength(2);
        this.setArmor(6);
    }

    @Override
    public String getTileName() {
        return "scarab";
    }
}