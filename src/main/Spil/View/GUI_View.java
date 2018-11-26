package main.Spil.View;

import gui_fields.GUI_Field;
import gui_main.GUI;
import main.Spil.Model.GameBoard;
import main.Spil.Model.LanguagePack;

import java.io.IOException;
import java.util.Arrays;

public class GUI_View {
    public GUI_View() throws IOException {
        String language = "DA";
        GameBoard board = new GameBoard(new LanguagePack(String.format("resources/DA_game_strings.txt", language)));
        new GUI(board.getGuiFields());

    }

}
