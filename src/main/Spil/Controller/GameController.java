package main.Spil.Controller;

import gui_fields.GUI_Field;
import main.Spil.Model.*;
import main.Spil.View.GUI_View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


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

    /**
     * actionEvents represents a list of classes that implements FieldActionListener, i.e. when a player land on a field each field is invoked
     */
    ArrayList<FieldActionListener> actionEvents;

    LanguagePackWrapper languagePackWrapper = null;

    /**
     * Creates a new GameController that is dependant on a GUI_View class (used for prompting dialogs).
     * GameController is used for controlling game states
     * @param guiView
     */
    public GameController(GUI_View guiView) {
        state = new GameState();

        try {
            state.setView(guiView.getGUI());

            String language = state.getView().getUserSelection("Choose language/Vælg sprog", "English", "Danish");
            languagePackWrapper = new LanguagePackWrapper(Enum.valueOf(LanguagePackWrapper.LanguageType.class, language));
            state.setBoard(languagePackWrapper.getBoard());
            stringContainer = languagePackWrapper.getLanguagePack();

            languagePackWrapper.updateGUI(state.getView());
        } catch (IOException e) {
            e.printStackTrace();
        }

        state.setStateMananger(new GameStateMananger());
        actionEvents = new ArrayList<FieldActionListener>();
        actionEvents.add(new PropertyFieldActionListener());
        actionEvents.add(new JailFieldActionListener());
        actionEvents.add(new StartFieldActionListener());
        actionEvents.add(new ChanceFieldActionListener(languagePackWrapper.getLanguagePack()));

        state.setPlayers(new RetrievePlayerDialog(state, stringContainer).showPlayerDialog());
    }

    /**
     * Begins the game
     */
    public void startGame() {
        Dice die = new Dice(6);

        while (state.getStateMananger().getState() == GameStateMananger.GameStateType.Running) {
            for (int k = 0; k < state.getPlayers().length; k++) {
                sleep(100);

                Player currentPlayer = state.getPlayers()[k];
                state.getView().getUserButtonPressed(stringContainer.getString("die_roll", currentPlayer.getName()),stringContainer.getString("die_roll_two"));

                int dieValue = die.roll();
                state.getView().setDie(dieValue);

                moveCar(currentPlayer, dieValue);

                invokeLandEvents(
                    state.getBoard().getFields()[currentPlayer.getPosition()],
                    state.getView().getFields()[currentPlayer.getPosition()],
                    currentPlayer,
                        dieValue
                );

                state.getStateMananger().determineState(state);
                if (state.getStateMananger().getState() == GameStateMananger.GameStateType.Done)
                    break;
            }
        }

        Arrays.sort(state.getPlayers());
        state.getView().showMessage(languagePackWrapper.getLanguagePack().getString("winner", state.getPlayers()[0].getName()));
    }

    /**
     * Calls "onFieldLandedOn" for every action event
     * @param field
     * @param guiField
     * @param player
     * @param faceValue
     */
    private void invokeLandEvents(Field field, GUI_Field guiField, Player player, int faceValue) {
        for (int i = 0; i < actionEvents.size(); i++) {
            actionEvents.get(i).onFieldLandedOn(new FieldAction(field, guiField, player, state, faceValue));
        }
    }

    // Recursive function that ensures that the car position is between 0 and 23 (i.e. on board)

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

    // Moves the player's car with amount equvivalent to delta

    /**
     * moveCar takes an player as an input argument and moves him by delta amount forward. (If delta is negative the car will be moved backwards)
     * @param currentPlayer
     * @param delta
     */
    private void moveCar(Player currentPlayer, int delta) {
        for (int q = 0; q < delta; q++) {
            currentPlayer.setPosition(clampPosition(currentPlayer.getPosition() + 1));
            updateCar(currentPlayer);
            sleep(100);
        }
    }

    /**
     * Updates the cars position on the game board (UI)
     * */
    private void updateCar(Player currentPlayer) {
        state.getView().getFields()[clampPosition(currentPlayer.getPosition() - 1)].setCar(currentPlayer, false);
        state.getView().getFields()[currentPlayer.getPosition()].setCar(currentPlayer, true);
    }

    /**
     * Creates a timeout of n miliseconds. Calling this will make the program stop and wait for n miliseconds and then allow further execution.
     * This method has no lock so prevent calling it from multiple threads.
     * */
    public static void sleep(int n) {
        long t0 = System.currentTimeMillis();

        long t1;
        do {
            t1 = System.currentTimeMillis();
        } while(t1 - t0 < (long)n);

    }
}