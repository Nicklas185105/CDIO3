package main.Spil.Model;

/**
 * Creates a ChanceCardPoints class which is a ChanceCard where the rule is that you get "pointsToGive" when you draw it!
 * */
public class ChanceCardPoints extends ChanceCard {
    private int pointsToGive;

    public ChanceCardPoints(String name, int pointsToGive) {
        super(name);
        this.pointsToGive = pointsToGive;
    }

    @Override
    public void invoke(FieldAction action) {
        action.player.setBalance(action.player.getBalance() - pointsToGive);
    }
}
