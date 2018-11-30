package main.Spil.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    Dice dice;

    @Before
    void setup() {
        dice = new Dice(6);
    }

    @Test
    void roll() {
        int lastThrow = -1;

        int sameRollInRow = 0;

        int[] rollOff = new int[6];

        for (int i = 0; i < 60000; i++) {
            int diceValue;
            diceValue = dice.roll();

            if (lastThrow == diceValue) {
                sameRollInRow++;
            } else {
                Assert.assertTrue(diceValue <= 6 && diceValue > 0);
                Assert.assertTrue(sameRollInRow < 50);

                rollOff[diceValue - 1]++;
                lastThrow = diceValue;
                sameRollInRow = 0;
            }

        }
        for(int i = 0; i < rollOff.length; i++) {
            Assert.assertTrue(rollOff[i] < 10000 + 400);
            Assert.assertTrue(rollOff[i] < 10000 - 400);
        }
    }

    @Test
    void getValue() {

    }
}