package main.Spil.Model;

import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Start;

/**
 * StartFieldActionListener's main responsibility is to determine if we crossed the starting field and reward the Player accordingly
 * */
public class StartFieldActionListener implements FieldActionListener {
    public void onFieldLandedOn(FieldAction action) {
        if (action.player.getPosition() - action.faceValue < 0) {
            action.player.setBalance(action.player.getBalance() + 2);
        }
    }
}
