package test;

import main.Spil.Model.Dice;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    Dice diceTest;



    @Test
    public void roll() {
        diceTest = new Dice(6);

        int lastThrow = -1;

        int sameRollInRow = 0;

        int[] rollOff = new int[6];

        for (int i = 0; i < 60000; i++) {
            int diceValue;
            diceValue = diceTest.roll();

            if (lastThrow == diceValue) {
                sameRollInRow++;
            } else {
                sameRollInRow = 0;

                assert diceValue <= 6 && diceValue > 0;
                assert sameRollInRow < 50;

                rollOff[diceValue - 1]++;
                lastThrow = diceValue;


            }

        }
        for(int i = 0; i < rollOff.length; i++) {
            assert rollOff[i] < 10000 + 400;
            assert rollOff[i] < 10000 - 400;

        }
    }
}