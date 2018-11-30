package main.Spil.View;

import gui_fields.GUI_Empty;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;
import main.Spil.Model.GameBoard;
import main.Spil.Model.LanguagePack;

import java.awt.*;
import java.io.FileNotFoundException;

public class GUI_View {
    public GUI gui;

    public GUI_View()
    {
        GameBoard board = new GameBoard(new LanguagePack());
        gui = new GUI(board.getGuiFields());
    }

    public GUI getGUI() {
        return gui;
    }
}
