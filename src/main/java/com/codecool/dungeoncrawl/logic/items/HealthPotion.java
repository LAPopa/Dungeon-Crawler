package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.actors.Player;

public class HealthPotion extends PerishableItem{

    private String color;

    public HealthPotion(String name, int ID, int expirationTime, String color) {
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

    public void increaseHealth(Player player){
        int currentPlayerHealth = player.getHealth();
        int increasedHealth = currentPlayerHealth+5;
        player.setHealth(increasedHealth);
    }

}
