package main.Spil.Model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        String name = "Skedeklaskeren";
        int balance = 0;
        String type = "Car";

        Player player = new Player(name, balance, type);

        Assert.assertEquals(player.getName(), name);

    }

    @Test
    void getGUIPlayer() {


    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }
}