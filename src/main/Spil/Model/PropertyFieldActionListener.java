package main.Spil.Model;

import gui_fields.GUI_Ownable;

/**
 * PropertyFieldActionListener's main responsibility is to determine if you landed on a field that is "ownable"
 * If that field IS ownable, but doesnt have an owner then prompt player asking if they wish to purchase it.
 * If the field IS ownable, and does have an owner then charge the rent of that property from the user
 * */
public class PropertyFieldActionListener implements FieldActionListener {
    public void onFieldLandedOn(FieldAction action) {
        try {
            if (Field.isOwnableField(action.field)) {
                // Retrieve field
                GUI_Ownable ownableField = Field.toOwnable(action.guiField);

                int rent = Integer.parseInt(
                        ownableField.getRent()
                                .split(":")[1]
                                .replace(" ", "")
                );

                // Check if the field is for sale?
                if (ownableField.getOwnerName() == null && action.player.getBalance() >= rent) {
                    // Prompt dialog to buy property?
                    if (action.gameState.getView().getUserSelection(String.format("Denne bolig er til salg! Vil %s købe denne bolig?", action.player.getName()), "yes", "no").equals("yes")) {
                        ownableField.setOwnerName(action.player.getName());
                        action.player.setBalance(action.player.getBalance() - rent);
                    }
                }

                // Require rent from other players
                else if (!ownableField.getOwnerName().equals(action.player.getName())) {
                    action.gameState.getView().showMessage(String.format("%s er landet på et felt som er ejet af %s. Du skulle betale %s til ham!",
                            action.player.getName(),
                            ownableField.getOwnerName(),
                            ownableField.getRent()));

                    // Remove money from player pocket
                    action.player.setBalance(action.player.getBalance() - rent);
                    Player owner = findPlayer(action.gameState.getPlayers(), ownableField.getOwnerName());
                    owner.setBalance(owner.getBalance() + rent);
                }
            }
        } catch (NullPointerException npe) {

        }
    }

    private Player findPlayer(Player[] players, String name) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getName().equals(name)) return players[i];
        }
        return null;
    }
}