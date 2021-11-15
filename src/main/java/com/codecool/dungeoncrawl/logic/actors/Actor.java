package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

import java.util.Objects;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
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

//    public void fight(int dx, int dy){
//        Cell nextCell = cell.getNeighbor(dx, dy);
//
//        if (nextCell.getActor()!=null){
//            nextCell.getActor().health-=1;
//            this.health-=1;
//        }
//    }

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
}
