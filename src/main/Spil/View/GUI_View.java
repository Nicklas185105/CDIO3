package main.Spil.View;

import gui_main.GUI;
import main.Spil.Model.FigureCard;
import main.Spil.Model.GameBoard;
import main.Spil.Model.LanguagePack;
import main.Spil.Model.Player;

import java.io.IOException;

public class GUI_View {
    private GUI gui;
    public GUI_View() throws IOException {
        String language = "DA";
        GameBoard board = new GameBoard(new LanguagePack(String.format("resources/DA_game_strings.txt", language)));

        gui = new GUI(board.getGuiFields());

        gui.addPlayer(new Player("John", 1000));


    }

    public GUI getGUI(){
        return gui;
    }

}
