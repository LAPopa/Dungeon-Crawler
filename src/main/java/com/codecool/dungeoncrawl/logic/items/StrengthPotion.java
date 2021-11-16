package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.actors.Player;

public class StrengthPotion extends PerishableItem{

    private String color;

    public StrengthPotion(String name, int ID, int expirationTime,String color) {
        super(name, ID, expirationTime);
        this.color = color;
    }

    @Override
    public boolean canBePickedUp() {
        return false;
    }

    @Override
    public boolean canBeUsed() {
        return false;
    }

    public void increaseStrength(Player player){
        int currentPlayerStrength = player.getStrength();
        int increasedStrength = currentPlayerStrength+5;
        player.setHealth(increasedStrength);
    }

}
