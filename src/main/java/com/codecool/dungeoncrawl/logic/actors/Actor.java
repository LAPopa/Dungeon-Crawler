package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

import java.util.Objects;

public abstract class Actor implements Drawable {
    protected Cell cell;
    protected int health = 10;
    protected int strength = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public Actor(Cell cell, int health, int strength) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.strength = strength;
    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null); //pleaca player de pe aceasta celula

        if(!Objects.equals(nextCell.getTileName(), "wall") && nextCell.getActor()==null){
                nextCell.setActor(this); // se duce pe aceasta celula
                cell = nextCell;

        }

        this.cell.setActor(this);
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void fight(int dx, int dy){
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (nextCell.getActor()!=null){
            nextCell.getActor().health-=1;
            this.health-=1;
        }
    }

}
