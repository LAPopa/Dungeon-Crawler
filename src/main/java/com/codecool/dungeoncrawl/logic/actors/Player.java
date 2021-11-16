package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Player extends Actor {

    private String name;
//    private int health;
//    private int strength;
//    private Inventory inventory; // TODO


    public Player(Cell cell) {

        super(cell);
//        this.inventory = new Inventory(); // to be implemented
        this.setHealth(100);
        this.setStrength(10);
        this.name="Test";
    }

    // TODO
//    public Inventory getInventory() {
//        return inventory;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (nextCell.getType()== CellType.FLOOR && nextCell.getActor() == null) {
            //implement item pickup ?
            getCell().setActor(null);
            nextCell.setActor(this);
            setCell(nextCell);
        } else if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() != null){
            Actor target = nextCell.getActor();
            while(target.getHealth() > 0) {
                fight(dx, dy, getCell());
//                System.out.println("current player health is " + this.getHealth());
            }
            getCell().setActor(null);
            nextCell.setActor(this);
            setCell(nextCell);
        }
        //TODO
//        else if (nextCell.getType() == CellType.DOOR) {
//
//        }
        this.getCell().setActor(this);

    }



    public String getTileName() {

        return "player";
    }
}
