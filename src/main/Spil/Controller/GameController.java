package main.Spil.Controller;

import gui_fields.GUI_Field;
import gui_main.GUI;
import gui_tests.Test;
import gui_tests.TestRunExampleGame;
import main.Spil.Model.*;
import main.Spil.View.GUI_View;

import java.io.FileNotFoundException;
import java.util.Random;


/**
 * This is the class that starts the application.
 */
public class GameController {

    /**
     * Defines GameStringContainer as stringContainer.
     */
    LanguagePack stringContainer;

    /**
     * Set user interface
     */
    GUI view;
    Random random;
    DiceCup d = new DiceCup();
    Player[] players;
    GameBoard board;

    public GameController() {
        try {
            view = new GUI_View().getGUI();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String language = view.getUserSelection("Choose language/Vælg sprog", "EN", "DA");


        try {
            stringContainer = new LanguagePack(String.format("resources/%s_game_strings.txt", language));
        } catch (FileNotFoundException fnfException) {
            System.out.println("Kunne ikke finde DA_game_strings.txt filen under resourcer.");
        }

        board = new GameBoard(stringContainer);
        if (language != "EN") {
            for (int j = 0; j < view.getFields().length; j++) {
                view.getFields()[j].setDescription(board.getGuiFields()[j].getDescription());
                view.getFields()[j].setSubText(board.getGuiFields()[j].getSubText());
                view.getFields()[j].setTitle(board.getGuiFields()[j].getTitle());
            }
        }

        this.players = getPlayers();
        Dice die = new Dice(6);


        while (true) { // Denne kører hele spillet (dvs. kører bilerne rundt i et loop i GUI)
            for (int k = 0; k < players.length; k++) {
                int dieValue = die.roll();
                view.setDie(dieValue);
                TestRunExampleGame.sleep();

                Player currentPlayer = players[k];

                Field currentField = board.getFields()[currentPlayer.getPosition()];
                GUI_Field currentGUIField = view.getFields()[currentPlayer.getPosition()];

                moveCar(currentPlayer, dieValue);
            }
        }
    }

    private int clampPosition(int position) {
        if (position < 0) { return clampPosition(position + 24); }
        if (position < 24) return position;
        return clampPosition(position - 24);
    }

    private void moveCar(Player currentPlayer, int delta) {
        for (int q = 0; q < delta; q++) {
            currentPlayer.setPosition(clampPosition(currentPlayer.getPosition() + 1));
            updateCar(currentPlayer);
            TestRunExampleGame.sleep(100);
        }
    }

    private void updateCar(Player currentPlayer) {
        view.getFields()[clampPosition(currentPlayer.getPosition() - 1)].setCar(currentPlayer, false);
        view.getFields()[currentPlayer.getPosition()].setCar(currentPlayer, true);
    }


    /**
     * This method is used for getting the players names.
     *
     * @return Returning the players names.
     */
    public Player[] getPlayers() {
        int n;

        while ((n = Integer.parseInt(view.getUserSelection(stringContainer.getString("amount_players"), "2", "3", "4"))) <= 0) {
            view.showMessage(stringContainer.getString("invalid_amount_players"));
        }

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {

            String name = view.getUserString(stringContainer.getString("give_player_name") + (i + 1));

            FigureCard figureCard = new FigureCard(Enum.valueOf(FigureCard.cardType.class, view.getUserString(stringContainer.getString("select_card_type"))));

            Player player = new Player(name, 24 - 2 * n, figureCard);
            players[i] = player;
            view.addPlayer(player);
            view.getFields()[0].setCar(player, true);


        }
        return players;
    }


}
