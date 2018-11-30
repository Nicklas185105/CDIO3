package main.Spil.Model;

import java.util.Random;

/**
 * ChanceFieldActionListener's main responsibility is to determine if you landed on a ChanceCard and if you have draw & invoke it!
 * */
public class ChanceFieldActionListener implements FieldActionListener {
    ChanceCard[] cards;

    public ChanceFieldActionListener(LanguagePack pack) {
        cards = new ChanceCard[] {
            new ChanceCardPoints(pack.getString("chance_point", 4), 4),
            new ChanceCardPoints(pack.getString("chance_point", 2), 2),
            new ChanceCardMove(pack.getString("chance_move", 5), 5)
        };
    }

    public void onFieldLandedOn(FieldAction action) {
        if (action.field.fieldType == Field.GUI_Type.Chance) {
            ChanceCard chanceCard = drawRandomCard();
            action.gameState.getView().showMessage(chanceCard.toString());
            chanceCard.invoke(action);
        }
    }

    private ChanceCard drawRandomCard(){
        Random r = new Random();
        return cards[r.nextInt(cards.length)];
    }
}