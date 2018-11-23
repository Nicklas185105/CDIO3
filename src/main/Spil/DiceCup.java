package main.Spil;

/**
 * This class is creating and controlling the dices.
 */
public class DiceCup {
    /**
     * Is a final list that holds the dices.
     */
    private Dice[] DICE;

    /**
     * This method is creating the 2 dices the application uses.
     */
    public DiceCup() {
        DICE = new Dice[]{new Dice(6), new Dice(6)}; // There is always only 2 dices (final)
    }

    /**
     * This method is rolling the dices, while storing them in a list.
     *
     * @return Is returning the list which is holding the dices value.
     */
    public int[] rollDice() {
        int[] roll = new int[DICE.length];

        // We are here rolling the dices.
        for (int i = 0; i < DICE.length; i++) {
            Dice dice = DICE[i];
            roll[i] = dice.roll();
        }

        return roll;
    }

    /**
     * This method is for seeing the total value of the 2 dices.
     *
     * @return The value of both dices in a total sum.
     */
    public int getFaceValue() {
        int sum = 0;
        for (int i = 0; i < DICE.length; i++) {
            sum += DICE[i].getValue();
        }
        return sum;
    }

    /**
     * This method is for checking if the dices has the same value.
     *
     * @return Is returning true if the dices value are the same.
     */
    public boolean isEqual() {
        for (int i = 0; i < DICE.length; i++) {
            for (int j = 0; j < DICE.length; j++) {
                if (DICE[i] != DICE[j]) return false;
            }
        }
        return true;
    }
}
