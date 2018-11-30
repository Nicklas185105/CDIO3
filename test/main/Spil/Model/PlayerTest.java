package main.Spil.Model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /**
     * Makes sure that the getName method is working correctly, it creates a new player and checks if the player have
     * the correct name when the method is called.
     */
    @Test
    void getName() {
        String name = "Jens";
        int balance = 0;
        String type = "Car";

        Player player = new Player(name, balance, type);

        Assert.assertEquals(player.getName(), name);

    }

    /**
     * Makes sure that our getPosition and setPosition is working correctly, sets the position of  player and then it
     * makes sures when the getPosition is called that the method return the correct position.
     */
    @Test
    void testPosition() {
        int position = 0;
        String name = "Jens";
        int balance = 0;
        String type = "Car";

        Player player = new Player(name, balance, type);

        player.setPosition(position);


        Assert.assertEquals(player.getPosition(), position);


    }
}