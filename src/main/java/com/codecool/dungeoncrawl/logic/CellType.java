package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.StrengthPotion;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOR("door"),
    SWORD("sword"),
    HEALTHPOTION("healthpotion"),
    STRENGTHPOTION("strengthpotion");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
