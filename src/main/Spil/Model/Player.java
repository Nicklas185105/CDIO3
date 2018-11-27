package main.Spil.Model;

import gui_fields.GUI_Player;

/**
 * This class is for creating the players.
 */
public class Player extends GUI_Player{
    /**
     * Defines the name of the player.
     */
    private FigureCard figureCard;

    /**
     * Defines the balance.
     */
    private int balance = 0;
    int currentField = 0;
    public int previous_position;
    public int current_position = 0;


    /**
     * This method is setting a name for the player and creating balance for the player.
     * @param name Is used for defining the name of the player.
     */
    public Player(String name, int balance, FigureCard figureCard){
        this(name, balance);
        this.figureCard = figureCard;
    }

    public Player(String name, int balance) {
        super(name, balance);
    }

    /**
     * This method is used for seeing the name of the player.
     * @return Returning the name of the player.
     */
    public String getName() {
        return super.getName();
    }


    /**
     * This method is changing the balance with a specific value.
     *
     * @param amount Is a specific value to change the balance with.
     */
    public void changeBalance(int amount) {
        if (balance < 0) this.balance = 0;
        balance += amount;
    }

    /**
     * @return Returns the balance
     */
    public int getBalance() {
        return balance;
    }

    public GUI_Player getGUIPlayer(){
        return new GUI_Player(super.getName(), balance);
    }

    public void setCurrent_position(int l,int o) {
        current_position += l+o;
    }

    public int getCurrent_position() {
        return current_position;
    }

    public void setPrevious_position(int l,int o) {
        previous_position += l+o;
    }

    public int getPrevious_position() {
        return previous_position;
    }

}
