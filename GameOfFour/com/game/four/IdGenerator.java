package com.game.four;

import java.util.Random;

public class IdGenerator {

    private static final Random RANDOM = new Random();

    public static Long generate() {
        return Long.valueOf(1 + RANDOM.nextInt(10000 - 1));
    }

}
