package main.Spil.Model;

public class FigureCard {
    private final cardType TYPE;

    public FigureCard(cardType type) {
        TYPE = type;
    }

    public enum cardType {
        Racecar,
        Car
    }

    @Override
    public String toString() {
        return TYPE.toString();
    }
}
