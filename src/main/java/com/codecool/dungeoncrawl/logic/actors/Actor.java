package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

import java.util.Objects;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int strength = 5;
    private int armor = 0;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {

        return cell;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null) {
            nextCell.setActor(this);
            cell = nextCell;
        }

        this.cell.setActor(this);

    }

    public void fight(int dx, int dy, Cell cell) {
// ?
        Cell nextCell = cell.getNeighbor(dx, dy);
        Actor player = cell.getActor();
        Actor target = nextCell.getActor();

        int playerDamage = player.getStrength();
        int targetDamage = target.getStrength();
        int targetHP = target.getHealth();
        int targetArmor = target.getArmor();


        if (!Objects.equals(target.getTileName(), "passive_target")) {

            System.out.println("target armor" + target.getArmor());
            target.setHealth((targetHP + targetArmor) - playerDamage);
            target.setArmor(target.getArmor() - 2);
            System.out.println("target armor after hit" + target.getArmor());
            player.takeHit(cell, targetDamage);

        } else {
            target.setHealth((targetHP + targetArmor) - playerDamage);
        }

    }

    public void takeHit(Cell cell, int damage) {
        Actor player = cell.getActor();

        int playerArmor = player.getArmor();

        if (playerArmor >= 2) {
            player.decreaseHealth(damage - playerArmor);
            player.decreaseArmor(2);
        } else {
            player.decreaseHealth(damage);
        }
    }

    public void decreaseArmor(int value) {
        this.armor -= value;
    }


    public void increaseArmor(int value) {
        this.armor += value;
    }

    public void decreaseHealth(int value) {
        this.health -= value;
    }

    //TODO healing items
    public void increaseHealth(int value) {
        this.health += value;
    }


//    public void fight(int dx, int dy){
//        Cell nextCell = cell.getNeighbor(dx, dy);
//
//        if (nextCell.getActor()!=null){
//            nextCell.getActor().health-=1;
//            this.health-=1;
//        }
//    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public boolean isDead() {
        return health <= 0;
    }


    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }


}
