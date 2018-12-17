package main.Spil.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    /**
     * Unit-test of Roll method. creates a die and do 60000 rolls, it checks if the dice value is between 1-6 and makes
     * sure the die dosn't rolls the same value 50 times in a row.
     */

    @Test
    void roll() {

        Dice dice = new Dice(6);

        int lastThrow = -1;

        int sameRollInRow = 0;

        int[] rollOff = new int[6];

        for (int i = 0; i < 60000; i++) {
            int diceValue;
            diceValue = dice.roll();

            Assert.assertTrue(sameRollInRow < 50);


            if (lastThrow == diceValue) {
                sameRollInRow++;
            } else {
                Assert.assertTrue(diceValue <= 6 && diceValue > 0);

                lastThrow = diceValue;
                sameRollInRow = 0;
            }

            rollOff[diceValue - 1]++;
        }
        for(int i = 0; i < rollOff.length; i++) {
            Assert.assertTrue(rollOff[i] < 10000 + 400);
            Assert.assertTrue(rollOff[i] > 10000 - 400);
        }
    }

    @Test
    void getValue() {

    }
}