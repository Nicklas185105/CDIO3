package main.Spil.Model;

/**
 * This is an abstract implementation of the ChanceCard. Extend this to create a ChanceCard with special defined rules.
 * The ChanceCard's "invoke" method is called when the special rules are applied
 * */
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
