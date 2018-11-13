package main.Spil;

public class GameBoard {
    Field[] fields;
    GameStringContainer stringContainer;

    GameBoard(GameStringContainer stringContainer) {
        fields = getFields();
        this.stringContainer = stringContainer;
    }

    private Field[] getFields() {
        return new Field[] {
            new Field("TestField", 0, stringContainer.getString("SampleField"))
        };
    }
}
