package main.Spil.Model;


import gui_fields.GUI_Field;

public class GameBoard {
    private LanguagePack stringContainer;

    public GameBoard(LanguagePack stringContainer) {
        this.stringContainer = stringContainer;
    }

    public GUI_Field[] getGuiFields() {
        Field[] fields = getFields();
        GUI_Field[] gui_fields = new GUI_Field[fields.length];
        for (int i = 0; i < fields.length; i++){
            gui_fields[i] = fields[i].toGUI();
        }
        return gui_fields;
    }

    public Field[] getFields() {
         return new Field[]{
                new Field("TestField", 0, "Test"),
                new Field("Tower", 250, stringContainer.getString("field_tower")),
                new Field("Crater", -100, stringContainer.getString("field_crater")),
                new Field("Palace gates", 100, stringContainer.getString("field_palace_gates")),
                new Field("Cold Desert", -20, stringContainer.getString("field_cold_desert")),
                new Field("Walled City", 180, stringContainer.getString("field_walled_city")),
                new Field("Monastary", 0, stringContainer.getString("field_monastary")),
                new Field("Black Cave", -70, stringContainer.getString("field_black_cave")),
                new Field("Huts in the mountain", 60, stringContainer.getString("field_huts_in_the_mountain")),
                new Field("The Werewall", -80, stringContainer.getString("field_the_werewall")),
                new Field("The Pit", -50, stringContainer.getString("field_the_pit")),
                new Field("Goldmine", 650, stringContainer.getString("field_goldmine"))
        };
    }


}
