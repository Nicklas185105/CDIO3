package main.Spil.Model;

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
