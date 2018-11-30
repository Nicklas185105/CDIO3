package main.Spil.Model;

public class ChanceCardMove extends ChanceCard {
    private int moveAmount;

    public ChanceCardMove(String name, int moveAmount) {
        super(name);
        this.moveAmount = moveAmount;
    }

    @Override
    public void invoke(FieldAction action) {
        moveCar(action.player, moveAmount, action.gameState);
    }

    // Recursive function that ensures that the car position is between 0 and 23 (i.e. on board)
    private int clampPosition(int position) {
        if (position < 0) { return clampPosition(position + 24); }
        if (position < 24) return position;
        return clampPosition(position - 24);
    }

    // Moves the player's car with amount equvivalent to delta
    private void moveCar(Player currentPlayer, int delta, GameState state) {
        state.getView().getFields()[clampPosition(currentPlayer.getPosition())].setCar(currentPlayer, false);
        currentPlayer.setPosition(clampPosition(currentPlayer.getPosition() + delta));
        state.getView().getFields()[currentPlayer.getPosition()].setCar(currentPlayer, true);
    }
}
