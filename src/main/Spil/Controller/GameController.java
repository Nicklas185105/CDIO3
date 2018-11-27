package main.Spil.Controller;

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

    public GameController() {


        try {
            view = new GUI_View().getGUI();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = view.getUserInteger("Press 1 for english. Tryk 2 for dansk", 1, 2);

        String language = "";

        switch (i) {
            case 1:
                language = "EN";
                break;
            case 2:
                language = "DA";
                break;
        }
        try {
            stringContainer = new LanguagePack(String.format("resources/%s_game_strings.txt", language));
        } catch (FileNotFoundException fnfException) {
            System.out.println("Kunne ikke finde DA_game_strings.txt filen under resourcer.");
        }

        if (language != "EN") {
        GameBoard board = new GameBoard(stringContainer);
        for (int j = 0; j < view.getFields().length; j++) {
            view.getFields()[j].setDescription(board.getGuiFields()[j].getDescription());
            view.getFields()[j].setSubText(board.getGuiFields()[j].getSubText());
            view.getFields()[j].setTitle(board.getGuiFields()[j].getTitle());
        }
        }

        this.players = getPlayers();


        while(true) { // Denne kører hele spillet (dvs. kører bilerne rundt i et loop i GUI)
            for (int k = 0; k < players.length; k++) {
                int value1[] = d.rollDice();
                view.setDice(value1[0], value1[1]);
                TestRunExampleGame.sleep();
                view.getFields()[players[k].current_position].setCar(players[k],false);

                players[k].previous_position = players[k].current_position;

                if ((players[k].current_position+value1[0]+value1[1])<=23){
                    players[k].current_position += value1[0] + value1[1];
                }
                else {
                    players[k].current_position = (players[k].current_position-24)+value1[0]+value1[1];
                }

                for (int q = 0; q < (value1[0]+value1[1]); q++) {
                    if (players[k].previous_position >= 23) {
                        view.getFields()[players[k].previous_position].setCar(players[k],false);
                        players[k].previous_position = 0;
                        view.getFields()[players[k].previous_position].setCar(players[k],true);
                        TestRunExampleGame.sleep(100);
                    }
                    else {
                        view.getFields()[players[k].previous_position].setCar(players[k],false);
                        players[k].previous_position += 1;
                        view.getFields()[players[k].previous_position].setCar(players[k],true);
                        TestRunExampleGame.sleep(100);
                    }
                }

            }
        }



    }


    /**
     * This method is used for getting the players names.
     *
     * @return Returning the players names.
     */
    public Player[] getPlayers() {
        int n;

        while ((n = view.getUserInteger(stringContainer.getString("amount_players"), 1, 4)) <= 0) {
            view.showMessage(stringContainer.getString("invalid_amount_players"));
        }

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {

            String name = view.getUserString(stringContainer.getString("give_player_name") + (i + 1));

            FigureCard figureCard = null;
            while (true) {

                try {
                    figureCard = new FigureCard(Enum.valueOf(FigureCard.cardType.class, view.getUserString(stringContainer.getString("select_card_type"))));
                    break;
                } catch (IllegalArgumentException e) {
                    view.showMessage(stringContainer.getString("illegal_card_type"));
                }
            }

            Player player = new Player(name, 24 - 2 * n, figureCard);
            players[i] = player;
            view.addPlayer(player);
            view.getFields()[0].setCar(player, true);




        }
        return players;
    }



}
