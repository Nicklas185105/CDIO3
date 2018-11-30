package main.Spil.Model;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

/**
 * This class is for creating the players.
 */
public class Player extends GUI_Player {

    /**
     * Defines the balance.
     */
    private int balance = 0;
    private int position = 0;

    /**
     * This method is setting a name for the player and creating balance for the player.
     *
     * @param name Is used for defining the name of the player.
     */
    public Player(String name, int balance, String type) {

        super(name, balance, new GUI_Car(null, null, (GUI_Car.Type) Enum.valueOf(GUI_Car.Type.class, type.toString().toUpperCase()), GUI_Car.Pattern.FILL));
    }

    /**
     * This method is used for seeing the name of the player.
     *
     * @return Returning the name of the player.
     */
    public String getName() {
        return super.getName();
    }



    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
