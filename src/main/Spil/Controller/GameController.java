package main.Spil.Controller;

import gui_main.GUI;
import main.Spil.Model.*;
import main.Spil.View.GUI_View;

import java.io.FileNotFoundException;


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

        addPlayers();
    }


    /**
     * This method is used for getting the players names.
     *
     * @return Returning the players names.
     */
    public void addPlayers() {
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
        }
    }
}
