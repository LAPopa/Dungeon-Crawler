package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Juggernaut extends Actor{

    public Juggernaut(Cell cell){
        super(cell);
        this.setHealth(50);
        this.setStrength(10);
        this.setArmor(10);
    }

    @Override
    public String getTileName() {
        return "juggernaut";
    }
}