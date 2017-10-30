package com.example.beijia.quizapp;

import java.util.List;
import java.util.Random;

public class Utility {

    private static Random random = new Random();

    public static int randomNumberGenerator(int max) {
        return random.nextInt(max);
    }

    public static int randomNumberGenerator(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

}
