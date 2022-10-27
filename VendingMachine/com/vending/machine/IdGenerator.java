package com.vending.machine;

import java.util.Random;

public class IdGenerator {

    private static final Random RANDOM = new Random();

    public static Long generate() {
        return Long.valueOf(1 + RANDOM.nextInt(100000 - 1));
    }
}
