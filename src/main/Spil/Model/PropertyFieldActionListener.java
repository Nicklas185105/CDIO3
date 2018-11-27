package main.Spil.Model;

import gui_fields.GUI_Ownable;

public class PropertyFieldActionListener implements FieldActionListener {
    public void onFieldLandedOn(FieldAction action) {
        if (Field.isOwnableField(action.field)) {
            // Retrieve field
            GUI_Ownable ownableField = Field.toOwnable(action.guiField);

            // Check if the field is for sale?
            if (ownableField.getOwnerName() == null) {
                // Prompt dialog to buy property?
                if (action.gui.getUserSelection(String.format("Denne bolig er til salg! Vil %s købe denne bolig?", action.player.getName()), "yes", "no").equals("yes")) {
                    ownableField.setOwnerName(action.player.getName());
                }
            }

            // Require rent from other players
            else if (!ownableField.getOwnerName().equals(action.player.getName())) {
                action.gui.showMessage(String.format("%s er landet på et felt som er ejet af %s. Du skulle betale %s til ham!",
                        action.player.getName(),
                        ownableField.getOwnerName(),
                        ownableField.getRent()));
            }
        }
    }
}