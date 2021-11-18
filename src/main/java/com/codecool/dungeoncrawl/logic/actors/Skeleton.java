package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.utils.Randomizers;

public class Skeleton extends Actor {

    public Skeleton(Cell cell) {

        super(cell);
        this.setHealth(25);
        this.setStrength(5);
    }

    @Override
    public String getTileName() {

        return "skeleton";
    }


//    public void move(int dx, int dy) {
//        int x = Randomizers.getRandomIntInRange(0, 1);
//        int y = Randomizers.getRandomIntInRange(0, 1);
//        super.move(x, y);
//
//    }

//    @Override
//    public void move(int dx, int dy) {
//
//        int x = Randomizers.getRandomIntInRange(0, 1);
//        int y = Randomizers.getRandomIntInRange(0, 1);
//        super.move(x, y);

//        Cell nextCell = getCell().getNeighbor(dx, dy);
//
//        if (nextCell.getType() != CellType.WALL && (nextCell.getType() == CellType.FLOOR || nextCell.getType() == CellType.FLOOR_FANCY) && nextCell.getActor() == null) {
//            cell.setActor(null);
//            nextCell.setActor(this);
//            cell = nextCell;
//        }
//
//        this.cell.setActor(this);

//    }
}
