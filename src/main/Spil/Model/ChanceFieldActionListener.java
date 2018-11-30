package main.Spil.Model;

import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;

public class ChanceFieldActionListener implements FieldActionListener {
    public void onFieldLandedOn(FieldAction action) {
        if (isChanceField(action.guiField)) {
            //Krydset feltet
            boolean X = false;
            action.player.setBalance(action.player.getBalance() + 2);
        }
    }
    private boolean isChanceField(GUI_Field guiField) {
        return guiField instanceof GUI_Chance;
    }
}
