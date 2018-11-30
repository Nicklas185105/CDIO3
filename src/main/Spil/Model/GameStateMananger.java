package main.Spil.Model;

public class GameStateMananger {
    public enum GameState {
        Running,
        Done
    }

    private GameState state;

    public GameStateMananger() {
        state = GameState.Running;
    }

    public void setPlayerLost(Player player) {
        state = GameState.Done;
    }

    public GameState getState() { return state; }
}
