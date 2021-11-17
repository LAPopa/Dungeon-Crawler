package com.codecool.dungeoncrawl.logic.utils;

import java.util.Random;

public class Randomizers {

    private static final Random RANDOM = new Random();

//    {0,1,-1}
//    new int[] {}
//    int positionX = new int [ ]{0,1,-1}
//    int positionY = new int [ ]{0,1,-1}



    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static int getRandomIntInRange ( int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }




}
