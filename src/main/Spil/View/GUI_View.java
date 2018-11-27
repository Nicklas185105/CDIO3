package main.Spil.View;

import gui_main.GUI;
import main.Spil.Model.GameBoard;
import main.Spil.Model.LanguagePack;

import java.io.FileNotFoundException;

public class GUI_View {
    private GUI gui;

    public GUI_View() throws FileNotFoundException {

        GameBoard board = new GameBoard(new LanguagePack(String.format("resources/%s_game_strings.txt", "DA")));

        gui = new GUI(board.getGuiFields());


    }

    public GUI getGUI() {
        return gui;
    }

}
