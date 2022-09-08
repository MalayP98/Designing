package com.train.manage;

import java.util.Random;

public class Util {

    private final static Random RANDOM = new Random();

    public static int getRandomNumber(int low, int high) {
        return RANDOM.nextInt(high - low) + low;
    }
}
