package main.Spil.Controller;

import main.Spil.Model.*;
import main.Spil.View.ConsoleView;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is the class that starts the application.
 */
public class DiceGame {
    /**
     * Is a list that holds all the players.
     */
    Player[] players;
    /**
     * Defines GameStringContainer as stringContainer.
     */
    LanguagePack stringContainer;
    GameBoard gameBoard;

    /**
     * Set user interface
     */
    ConsoleView view = new ConsoleView();

    /**
     * This method is creating a new GameStringContainer with a file path and calls the method getPlayers.
     */
    public DiceGame() {

        view.print("Press 1 for english");
        view.print("Tryk 2 for dansk");

        int i = 0;
        while (true) {
            i = view.readInt();
            if (i >= 1 && i <= 2) {
                break;
            }
            System.out.println("Invalid Input! Try again.");
        }

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

        this.gameBoard = new GameBoard(stringContainer);
        this.players = getPlayers();
    }

    /**
     * This method is for starting the game.
     *
     * <p>
     * The method is running the application with turns.
     * That means that one player is playing at a time.
     * This method is also printing out the information for the player with the class view.
     * </p>
     *
     * @throws IOException Is used for...
     */
    public void startGame() throws IOException {

        //Game is running

        boolean gameFinished = false;

        while (!gameFinished) {

            //Runs the game with turns swapping between the players, until the variable "gameFinished" is true.
            for (int i = 0; i < players.length; i++) {
                DiceCup diceCup = new DiceCup();
                view.print("-------------------------------------------------------------------------------------------------------------------------");
                view.print(stringContainer.getString("roll_dice"), players[i].getName());
                System.in.read();

                System.out.println();
                diceCup.rollDice();
                Field fieldLandedOn = gameBoard.getFields()[diceCup.getFaceValue() - 1];

                view.print(stringContainer.getString("field_land"), fieldLandedOn.name);
                view.print(fieldLandedOn.fieldText);

                players[i].changeBalance(fieldLandedOn.value);

                view.print("");
                view.print(stringContainer.getString("balance"), players[i].getBalance());

                if (fieldLandedOn.getsAnotherTurn) {
                    i--;
                    continue;
                }

                if (players[i].getBalance() >= 3000) {
                    gameFinished = true;
                    view.print(stringContainer.getString("player_win"), players[i].getName());
                    break;
                }
            }

        }
    }

    /**
     * This method is used for getting the players names.
     *
     * @return Returning the players names.
     */
    Player[] getPlayers() {
        view.print(stringContainer.getString("amount_players"));
        int n;
        while ((n = view.readInt()) <= 0) {
            view.print(stringContainer.getString("invalid_amount_players"));
        }

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            view.print(stringContainer.getString("give_player_name"), i + 1);

            String name = view.readString();

            FigureCard figureCard = null;
            while (true) {
                view.print(stringContainer.getString("select_card_type"));

                try {
                    figureCard = new FigureCard(Enum.valueOf(FigureCard.cardType.class, view.readString()));
                    break;
                } catch (IllegalArgumentException e) {
                    view.print(stringContainer.getString("illegal_card_type"));
                }
            }
            players[i] = new Player(name, 1000,
                    figureCard
            );
        }

        return players;
    }
}
