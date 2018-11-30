package main.Spil.Model;

import gui_main.GUI;

public class GameState {
    private GUI view;
    private Player[] players;
    private GameBoard board;
    private GameStateMananger stateMananger;

    public GUI getView() {
        return view;
    }

    public void setView(GUI view) {
        this.view = view;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public GameStateMananger getStateMananger() {
        return stateMananger;
    }

    public void setStateMananger(GameStateMananger stateMananger) {
        this.stateMananger = stateMananger;
    }
}
