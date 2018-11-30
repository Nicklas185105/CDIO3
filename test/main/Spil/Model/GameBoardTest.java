package main.Spil.Model;

import gui_fields.GUI_Field;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void getGuiFields() {

        //Makes sure that the getGuiFields creates 24 fields

        GameBoard gameBoard = new GameBoard(new LanguagePack());

        GUI_Field[] guiFields = gameBoard.getGuiFields();

        Assert.assertEquals(guiFields.length, 24);

    }

    @Test
    void getFields() {

        //Makes sure that the getFields creates 24 fields


        GameBoard gameBoard = new GameBoard(new LanguagePack());

        Field[] fields = gameBoard.getFields();

        Assert.assertEquals(fields.length, 24);

    }

}