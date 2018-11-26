package main.Spil.Model;

import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;

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
        this.name = name;
        this.value = value;
        this.fieldText = fieldText;
        this.fieldType = GUI_Type.Street;
    }

    public GUI_Field toGUI() {
        String priceTxt = String.format("%d kr", value);

        if (fieldType == GUI_Type.Street) {
            return new GUI_Street(name, priceTxt, fieldText, "Leje: 50", Color.YELLOW, Color.BLACK);
        }

        if (fieldType == GUI_Type.Brewery) {
            //return new GUI_Brewery("default", name, priceTxt, fieldText, Color.black);
        }

        throw new IllegalArgumentException();
    }


    public enum GUI_Type {
        Board,
        Brewery,
        Car,
        Chance,
        Empty,
        Jail,
        Shipping,
        Start,
        Street,
        Tax
    }
}

