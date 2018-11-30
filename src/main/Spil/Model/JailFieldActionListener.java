package main.Spil.Model;

import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;

/**
 * JailFieldActionListener's main responsibility is to determine if you landed on the "go to jail" field.
 * If the player lands on the "go to jail" field, then put the player there and charge them.
 * */
public class JailFieldActionListener implements FieldActionListener {
    public void onFieldLandedOn(FieldAction action) {
        if (isJailCard(action.guiField) && isGoToJailCard(action.field)) {
            // Find jail field.
            GameBoard board = action.gameState.getBoard();
            for (int i = 0; i < board.getGuiFields().length; i++) {
                if (isJailCard(board.getGuiFields()[i]) && !isGoToJailCard(board.getFields()[i])) {
                    //action.gameState.getPlayers()[getPlayerIndex(action.player, action.gameState.getPlayers())].setPosition(i);
                    setCarPosition(action.gameState, action.player, i);
                    action.player.setPosition(i);
                    action.player.setBalance(action.player.getBalance() - 1);
                }
            }
        }
    }

    /**
     * This function recursively calls itself until it ensures the input value is between 0 and 23 (I.e. clamps a position to the board)
     * @param position
     * @return
     */
    private int clampPosition(int position) {
        if (position < 0) { return clampPosition(position + 24); }
        if (position < 24) return position;
        return clampPosition(position - 24);
    }


    private void setCarPosition(GameState state, Player currentPlayer, int newPosition) {
        state.getView().getFields()[clampPosition(currentPlayer.getPosition())].setCar(currentPlayer, false);
        state.getView().getFields()[clampPosition(newPosition)].setCar(currentPlayer, true);
    }

    private boolean isJailCard(GUI_Field guiField) {
        return guiField instanceof GUI_Jail;
    }

    private boolean isGoToJailCard(Field field) {
        return field.value == 1;
    }
}
