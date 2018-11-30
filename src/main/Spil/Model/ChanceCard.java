package main.Spil.Model;

public abstract class ChanceCard {
    private String name;

    public ChanceCard(String name) {
        this.name = name;
    }

    public void invoke(FieldAction action)  { }

    @Override
    public String toString() {
        return name;
    }
}
