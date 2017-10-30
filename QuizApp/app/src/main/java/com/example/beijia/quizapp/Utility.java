package com.example.beijia.quizapp;

import java.util.Random;

public class Utility {

    private Random random;

    public Utility() {
        random = new Random();
    }

    public Integer randomNumberGenerator(int max) {
        return this.random.nextInt(max);
    }

    public int randomNumberGenerator(int min, int max) {
        return this.random.nextInt(max - min + 1) + min;
    }

}
