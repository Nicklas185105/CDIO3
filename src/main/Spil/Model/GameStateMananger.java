package main.Spil.Model;

public class GameStateMananger {
    public enum GameStateType {
        Running,
        Done
    }

    private GameStateType state;

    public GameStateMananger() {
        state = GameStateType.Running;
    }

    public void determineState(GameState gameState) {
        for (int i = 0; i < gameState.getPlayers().length; i++) {
            if (gameState.getPlayers()[i].getBalance() < 0) {
                state = GameStateType.Done;
            }
        }
    }

    public GameStateType getState() { return state; }
}
