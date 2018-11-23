package main.Spil;

import main.Spil.Model.LanguagePack;

public class GameBoard {
    Field[] fields;
    LanguagePack stringContainer;

    GameBoard(LanguagePack stringContainer) {
        fields = getFields();
        this.stringContainer = stringContainer;
    }

    private Field[] getFields() {
        return new Field[] {
            new Field("TestField", 0, stringContainer.getString("SampleField"))
        };
    }
}
