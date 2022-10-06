package com.vehical.rental.generators;

import java.util.Random;

public class RandomElementGenerators {

    private static final Random RANDOM = new Random();

    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public static int getRandomInt(int upperBound) {
        return getRandomInt(1, upperBound);
    }

    public static double getRandomDouble(double min, double max) {
        return min + (max - min) * RANDOM.nextDouble();
    }

    public static char getRandomChar() {
        return (char) ('A' + RANDOM.nextInt(90 - 65));
    }
}
