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
            case Street: return new GUI_Street(name, priceTxt, fieldText, "Leje: 50", Color.YELLOW, Color.BLACK);
            case Brewery: return new GUI_Brewery("default", name, priceTxt, fieldText, "10 x [Terningslag]", Color.BLACK, Color.WHITE);
            case Jail: return new GUI_Jail("default", name, priceTxt, fieldText, new Color(125, 125, 125), Color.BLACK);
            case Chance: return new GUI_Chance(name, priceTxt, fieldText, new Color(204, 204, 204), Color.BLACK);
            case Shipping: return new GUI_Shipping("default", name, priceTxt, fieldText, "Leje:  75", Color.WHITE, Color.BLACK);
            case Tax: return new GUI_Tax(name, priceTxt, fieldText, Color.GRAY, Color.BLACK);
        }

        throw new IllegalArgumentException();
    }


    public enum GUI_Type {
        Chance,
        Brewery,
        Jail,
        Shipping,
        Street,
        Tax
    }
}

