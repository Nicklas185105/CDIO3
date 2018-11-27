package main.Spil.Model;

import gui_fields.*;
import java.awt.*;

/**
 * This class is controlling each field.
 *
 * <p>
 * Each field has a name, a value and a description. While one field can give the player another turn.
 * </p>
 */
public class Field {
    /**
     * Defines the name of the field.
     */
    public final String name;
    /**
     * Defines the value of the field.
     *
     * <p> The Value of the field, is how much money the player is getting or how much money the player is losing.</p>
     */
    public final int value;

    /**
     * Defines the fields description.
     */
    public final String fieldText;


    /*
    *
    * */
    public final GUI_Type fieldType;

    /**
     * This method is for creating fields, where the player can't get another turn.
     *
     * @param name      The name of the field.
     * @param value     The value of the field.
     * @param fieldText The description of the field.
     */
    public Field(String name, int value, String fieldText) {
        this(name, value, fieldText, GUI_Type.Street);
    }

    public Field(String name, int value, String fieldText, GUI_Type fieldType) {
        this.name = name;
        this.value = value;
        this.fieldType = fieldType;

        if (fieldText == null) this.fieldText = "";
        else this.fieldText = fieldText;
    }


    public GUI_Field toGUI() {
        String priceTxt = String.format("%d kr", value);

        switch (fieldType) {
            case Street_Brown: return new GUI_Street(name, priceTxt, fieldText, "Leje: 1", new Color(134, 69, 18), Color.BLACK);
            case Street_Cyan: return new GUI_Street(name, priceTxt, fieldText, "Leje: 1", Color.CYAN, Color.BLACK);
            case Street_Purple: return new GUI_Street(name, priceTxt, fieldText, "Leje: 2", Color.MAGENTA, Color.BLACK);
            case Street_Orange: return new GUI_Street(name, priceTxt, fieldText, "Leje: 2", Color.ORANGE, Color.BLACK);
            case Street_Red: return new GUI_Street(name, priceTxt, fieldText, "Leje: 3", Color.RED, Color.BLACK);
            case Street_Yellow: return new GUI_Street(name, priceTxt, fieldText, "Leje: 3", Color.YELLOW, Color.BLACK);
            case Street_Green: return new GUI_Street(name, priceTxt, fieldText, "Leje: 4", Color.GREEN, Color.BLACK);
            case Street_Blue: return new GUI_Street(name, priceTxt, fieldText, "Leje: 5", Color.BLUE, Color.BLACK);
            case Brewery: return new GUI_Brewery("default", name, "", fieldText, "", Color.BLACK, Color.WHITE);
            case Jail: return new GUI_Jail("default", name, "", fieldText, new Color(68, 68, 68), Color.BLACK);
            case Chance: return new GUI_Chance(name, "", fieldText, new Color(204, 182, 0), Color.BLACK);
            case Shipping: return new GUI_Shipping("default", name, "", fieldText, "Leje:  75", Color.WHITE, Color.BLACK);
            case Start: return new GUI_Tax(name, "+2 til dig", fieldText, Color.GRAY, Color.BLACK);
            case Empty: return new GUI_Empty();
        }

        throw new IllegalArgumentException();
    }


    public enum GUI_Type {
        Chance,
        Brewery,
        Jail,
        Shipping,
        Street,
        Street_Brown,
        Street_Cyan,
        Street_Purple,
        Street_Orange,
        Street_Red,
        Street_Yellow,
        Street_Green,
        Street_Blue,
        Start,
        Empty
    }
}

