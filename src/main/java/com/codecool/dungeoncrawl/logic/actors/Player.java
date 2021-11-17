package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.CellType;

import java.util.ArrayList;
import java.util.Objects;
import com.codecool.dungeoncrawl.logic.items.*;

public class Player extends Actor {

    private String name;
    private Inventory inventory;
    private ArrayList<Item> listOfPotions;
    private ArrayList<Item> listOfTools;
    private ArrayList<Item> listOfEquippedItems = new ArrayList<>();


    public Player(Cell cell) {

        super(cell);
        this.inventory = new Inventory();
        this.setHealth(100);
        this.setStrength(10);
        this.name="Test";
        this.listOfPotions = new ArrayList<>();
        this.listOfTools = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }



//    //Getters and Setters
//    public ArrayList<Item> getListOfPotions() {
//        return listOfPotions;
//    }
//
//    public ArrayList<Item> getListOfTools() {
//        return listOfTools;
//    }
//
//    public ArrayList<Item> getListOfEquippedItems() {
//        return listOfEquippedItems;
//    }
//
//    public void addItemToListOfPotions(Item newItem){
//        listOfPotions.add(newItem);
//    }
//    public void addItemToListOfTools(Item newItem){
//        listOfTools.add(newItem);
//    }
//    public void addItemToListOfEquippedItems(Item newItem){
//        listOfEquippedItems.add(newItem);
//    }
//
//    public void equipPotion(Item potionItem){
//        // TO DO: use neighbouringCellContainsItem!!!
//        if (listOfPotions.contains(potionItem)){
//            if(!listOfEquippedItems.contains(potionItem)){
//                listOfEquippedItems.add(potionItem);
//                if (potionItem instanceof HealthPotion){
//                    ((HealthPotion) potionItem).increaseHealth(this); // increase health
//                }
////                listOfEquippedItems.remove(potionItem);
//            }
//            System.out.println(potionItem.getName()+"("+potionItem.getID()+")" + " already in use!");
//        }
//        System.out.println(potionItem.getName()+"("+potionItem.getID()+")" + " not found in inventory!");
//    }
//
//
//
//    public void equipTool(Item toolItem){
//        if(listOfTools.contains(toolItem)){
//            if(!listOfEquippedItems.contains(toolItem)){
//                listOfEquippedItems.add(toolItem);
//            }
//            System.out.println(toolItem.getName()+"("+toolItem.getID()+")" +" already in use!");
//        }
//        System.out.println(toolItem.getName()+"("+toolItem.getID()+")" + " not found in inventory!");
//    }
//
//    public boolean neighbouringCellContainsItem(int dx, int dy){
//        Cell nextCell = getCell().getNeighbor(dx, dy);
//
//        return !Objects.equals(nextCell.getTileName(), "door") ||
//                !Objects.equals(nextCell.getTileName(), "wall") ||
//                !Objects.equals(nextCell.getTileName(), "empty") ||
//                !Objects.equals(nextCell.getTileName(), "floor");
//    }

//    public boolean keyInInventory() {
//        return this.inventory.getKeyInInventory();
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
        if ((nextCell.getType()== CellType.FLOOR || nextCell.getType()== CellType.FLOOR_FANCY) && nextCell.getActor() == null) {
            //implement item pickup ?
            if (nextCell.getItem()!=null) {
                switch (nextCell.getItem().getTileName()){
                    case "key":
                        // add key to pickup item
                        inventory.addItem(nextCell.getItem());
                        inventory.setKeyInInventory(true);
                        nextCell.setItem(null);
                        break;
                    case "sword":
                        Actor player = getCell().getActor();
                        Item sword = nextCell.getItem();
                        inventory.addItem(nextCell.getItem());
                        player.setStrength(player.getStrength()+sword.getPoints());
                        nextCell.setItem(null);
                        break;
                    case "shield":
                        inventory.addItem(nextCell.getItem());
                        getCell().getActor().increaseArmor(nextCell.getItem().getPoints());
                        nextCell.setItem(null);
                        break;
                }
            }
            getCell().setActor(null);
            nextCell.setActor(this);
            setCell(nextCell);
        } else if ((nextCell.getType()== CellType.FLOOR || nextCell.getType()== CellType.FLOOR_FANCY) && nextCell.getActor() != null){
            Actor target = nextCell.getActor();
            while(target.getHealth() > 0) {
                fight(dx, dy, getCell());
//                System.out.println("current player health is " + this.getHealth());
            }
            getCell().setActor(null);
            nextCell.setActor(this);
            setCell(nextCell);
        } else if (nextCell.getType() == CellType.DOOR && inventory.getKeyInInventory()){
            System.out.println("Ascending to second level [WIP]");
        }

        this.getCell().setActor(this);

    }

    public String showInventory(){
        String inventoryContains = getInventory().toString();
        return inventoryContains;
    }



    public String getTileName() {

        return "player";
    }
}
