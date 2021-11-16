package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.HealthPotion;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Player extends Actor {

    private ArrayList<Item> listOfPotions;
    private ArrayList<Item> listOfTools;
    private ArrayList<Item> listOfEquippedItems = new ArrayList<>();


    public Player(Cell cell) {
        super(cell);
        this.listOfPotions = new ArrayList<>();
        this.listOfTools = new ArrayList<>();
    }



    //Getters and Setters
    public ArrayList<Item> getListOfPotions() {
        return listOfPotions;
    }

    public ArrayList<Item> getListOfTools() {
        return listOfTools;
    }

    public ArrayList<Item> getListOfEquippedItems() {
        return listOfEquippedItems;
    }

    public void addItemToListOfPotions(Item newItem){
        listOfPotions.add(newItem);
    }
    public void addItemToListOfTools(Item newItem){
        listOfTools.add(newItem);
    }
    public void addItemToListOfEquippedItems(Item newItem){
        listOfEquippedItems.add(newItem);
    }

    public void equipPotion(Item potionItem){
        // TO DO: use neighbouringCellContainsItem!!!
        if (listOfPotions.contains(potionItem)){
            if(!listOfEquippedItems.contains(potionItem)){
                listOfEquippedItems.add(potionItem);
                if (potionItem instanceof HealthPotion){
                    ((HealthPotion) potionItem).increaseHealth(this); // increase health
                }
//                listOfEquippedItems.remove(potionItem);
            }
            System.out.println(potionItem.getName()+"("+potionItem.getID()+")" + " already in use!");
        }
        System.out.println(potionItem.getName()+"("+potionItem.getID()+")" + " not found in inventory!");
    }

    public void equipTool(Item toolItem){
        if(listOfTools.contains(toolItem)){
            if(!listOfEquippedItems.contains(toolItem)){
                listOfEquippedItems.add(toolItem);
            }
            System.out.println(toolItem.getName()+"("+toolItem.getID()+")" +" already in use!");
        }
        System.out.println(toolItem.getName()+"("+toolItem.getID()+")" + " not found in inventory!");
    }

    public boolean neighbouringCellContainsItem(int dx, int dy){
        Cell nextCell = cell.getNeighbor(dx, dy);

        return !Objects.equals(nextCell.getTileName(), "door") ||
                !Objects.equals(nextCell.getTileName(), "wall") ||
                !Objects.equals(nextCell.getTileName(), "empty") ||
                !Objects.equals(nextCell.getTileName(), "floor");
    }

    public String getTileName() {
        return "player";
    }
}
