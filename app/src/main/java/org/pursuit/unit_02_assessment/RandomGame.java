package org.pursuit.unit_02_assessment;

import java.util.Random;

public class RandomGame {

    private Random random;

    public RandomGame() {
        this.random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(100) + 1;
    }

    public boolean checkGuess(int guess, int random) {
        return guess == random;
    }

    public String getStringResult(boolean isMatch) {
        if(isMatch) {
            return "You have guessed correctly!";
        } else {
            return "Wrong guess - please try again!";
        }
    }

    public int stringToInt(String input) {
        int result = Integer.MIN_VALUE;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }
}
