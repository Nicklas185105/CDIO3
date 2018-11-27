package main.Spil.View;

import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_tests.TestRunExampleGame;
import main.Spil.Controller.DiceCup;
import main.Spil.Model.*;

import java.io.IOException;
import java.util.Random;

public class GUI_View {
    private GUI gui;
    public GUI_View() throws IOException {
        String language = "DA";
        GameBoard board = new GameBoard(new LanguagePack(String.format("resources/DA_game_strings.txt", language)));

        GUI_Player mn = new GUI_Player("Jens", 20);
        gui = new GUI(board.getGuiFields());
        gui.addPlayer(mn);
        gui.getFields()[0].setCar(mn, true);
        gui.setDice(1,1);
        TestRunExampleGame.sleep();
        gui.getFields()[0].setCar(mn, false);
        gui.getFields()[1].setCar(mn, true);
        TestRunExampleGame.sleep();
        gui.getFields()[1].setCar(mn, false);
        gui.getFields()[2].setCar(mn, true);
        TestRunExampleGame.sleep();
        gui.getFields()[2].setCar(mn, false);
        gui.getFields()[3].setCar(mn, true);
        TestRunExampleGame.sleep();
        gui.getFields()[3].setCar(mn, false);
        gui.getFields()[4].setCar(mn, true);
        TestRunExampleGame.sleep();
    }

    public GUI getGUI(){
        return gui;
    }

}
