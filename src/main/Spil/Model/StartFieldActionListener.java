package main.Spil.Model;

import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Start;

public class StartFieldActionListener implements FieldActionListener {
    public void onFieldLandedOn(FieldAction action) {
        if (action.player.getPosition() - action.faceValue < 0) {
            //Krydset feltet
            boolean X = false;
            action.player.setBalance(action.player.getBalance() + 2);
        }
    }
}
