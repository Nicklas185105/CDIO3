package main.Spil.Controller;

import gui_fields.GUI_Field;
import gui_main.GUI;
import gui_tests.TestRunExampleGame;
import main.Spil.Model.*;
import main.Spil.View.GUI_View;

import java.io.IOException;
import java.util.ArrayList;


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
    GameState state;

    ArrayList<FieldActionListener> actionEvents;

    public GameController() {
        state = new GameState();

        try {
            state.setView(new GUI_View().getGUI());

            String language = state.getView().getUserSelection("Choose language/Vælg sprog", "English", "Danish");
            LanguagePackWrapper languagePackWrapper = new LanguagePackWrapper(Enum.valueOf(LanguagePackWrapper.LanguageType.class, language));
            state.setBoard(languagePackWrapper.getBoard());
            stringContainer = languagePackWrapper.getLanguagePack();

            if (!language.equals("English")) { languagePackWrapper.updateGUI(state.getView()); }
        } catch (IOException e) {
            e.printStackTrace();
        }

        state.setStateMananger(new GameStateMananger());
        actionEvents = new ArrayList<FieldActionListener>();
        actionEvents.add(new PropertyFieldActionListener());

        state.setPlayers(getPlayers());
        Dice die = new Dice(6);

        while (true) {
            for (int k = 0; k < state.getPlayers().length; k++) {
                TestRunExampleGame.sleep(500);

                int dieValue = die.roll();
                state.getView().setDie(dieValue);
                Player currentPlayer = state.getPlayers()[k];

                moveCar(currentPlayer, dieValue);

                invokeLandEvents(
                    state.getBoard().getFields()[currentPlayer.getPosition()],
                    state.getView().getFields()[currentPlayer.getPosition()],
                    currentPlayer
                );
            }
        }
    }

    // Kalder alle FieldActionListeners
    private void invokeLandEvents(Field field, GUI_Field guiField, Player player) {
        for (int i = 0; i < actionEvents.size(); i++) {
            actionEvents.get(i).onFieldLandedOn(new FieldAction(field, guiField, player, state));
        }
    }

    // Recursive function that ensures that the car position is between 0 and 23 (i.e. on board)
    private int clampPosition(int position) {
        if (position < 0) { return clampPosition(position + 24); }
        if (position < 24) return position;
        return clampPosition(position - 24);
    }

    // Moves the player's car with amount equvivalent to delta
    private void moveCar(Player currentPlayer, int delta) {
        for (int q = 0; q < delta; q++) {
            currentPlayer.setPosition(clampPosition(currentPlayer.getPosition() + 1));
            updateCar(currentPlayer);
            TestRunExampleGame.sleep(100);
        }
    }

    // Updates the car position based on currentPlayer's position.
    private void updateCar(Player currentPlayer) {
        view.getFields()[clampPosition(currentPlayer.getPosition() - 1)].setCar(currentPlayer, false);
        view.getFields()[currentPlayer.getPosition()].setCar(currentPlayer, true);
    }

    public Player[] getPlayers() {
        int n;

        while ((n = Integer.parseInt(view.getUserSelection(stringContainer.getString("amount_players"), "2", "3", "4"))) <= 0) {
            view.showMessage(stringContainer.getString("invalid_amount_players"));
        }

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {

            String name = view.getUserString(stringContainer.getString("give_player_name", (i + 1)));

            String type = view.getUserSelection(stringContainer.getString("select_card_type"), "Car", "Racecar", "Tractor", "UFO");

            Player player = new Player(name, 24 - 2 * n, type);
            players[i] = player;
            view.addPlayer(player);
            view.getFields()[0].setCar(player, true);


        }
        return players;
    }
}