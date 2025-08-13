package org.example.dice;

import java.util.Random;

public class SingleDiceStrategy implements DiceStrategy {

    private final int minValue;
    private final int maxValue;
    private final Random random = new Random();

    public SingleDiceStrategy(int minValue, int maxValue) {

        if (minValue > maxValue)
            throw new IllegalArgumentException(" ERROR - min value must be smaller than max value");

        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public int roll() {

        return random.nextInt(maxValue - minValue + 1) + minValue;
    }
}
