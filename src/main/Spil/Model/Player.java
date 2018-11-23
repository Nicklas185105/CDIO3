package main.Spil.Model;

/**
 * This class is for creating the players.
 */
public class Player {
    /**
     * Defines the name of the player.
     */
    private String name;

    /**
     * Defines the balance.
     */
    private int balance = 0;


    /**
     * This method is setting a name for the player and creating balance for the player.
     * @param name Is used for defining the name of the player.
     */
    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    /**
     * This method is used for seeing the name of the player.
     * @return Returning the name of the player.
     */
    public String getName() {
        return this.name;
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


}
