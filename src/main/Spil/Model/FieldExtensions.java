package main.Spil.Model;

import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;

public class FieldExtensions {
    public static boolean isOwnableField(Field field) {
        return isOwnableField(field.toGUI());
    }

    public static boolean isOwnableField(GUI_Field guiField) {
        return guiField instanceof GUI_Ownable;
    }

    public static GUI_Ownable toOwnable(GUI_Field guiField) {
        if (isOwnableField(guiField)) { return (GUI_Ownable)guiField; }
        throw new IllegalArgumentException("Field is not of type GUI_Ownable");
    }
}
