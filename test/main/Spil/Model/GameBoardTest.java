package main.Spil.Model;

import gui_fields.GUI_Field;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    /**
     * Unit-test of getGuiFields. That when the GUI_Field array creates exactly 24 fields into the GUI
     */

    @Test
    void getGuiFields() {

        //Makes sure that the getGuiFields creates 24 fields

        GameBoard gameBoard = new GameBoard(new LanguagePack());

        GUI_Field[] guiFields = gameBoard.getGuiFields();

        Assert.assertEquals(guiFields.length, 24);

    }

    /**
     * Unit-test of getFields. Makes sure that when the gameBoard calls the method Field[] that the gameBoard consists
     * of 24 fields.
     */
    @Test
    void getFields() {

        //Makes sure that the getFields creates 24 fields


        GameBoard gameBoard = new GameBoard(new LanguagePack());

        Field[] fields = gameBoard.getFields();

        Assert.assertEquals(fields.length, 24);

    }

}