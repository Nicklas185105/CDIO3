package main.Spil.Model;

import gui_fields.GUI_Field;
import gui_main.GUI;
import main.Spil.View.GUI_View;

public class FieldAction {
    public final Field field;
    public final GUI_Field guiField;
    public final Player player;
    public final GUI gui;
    public final Player[] players;

    public  FieldAction(Field field, GUI_Field guiField, Player player, Player[] players, GUI gui) {
        this.field = field;
        this.guiField = guiField;
        this.player = player;
        this.gui = gui;
        this.players = players;
    }
}
