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
                new Field("Start", 0, "Start"),
                new Field("Burgerbaren", 1, stringContainer.getString("field_tower"), Field.GUI_Type.Street),
                new Field("Pizzariaet", 1, stringContainer.getString("field_crater"), Field.GUI_Type.Street),
                new Field("Chance", 0, stringContainer.getString("field_crater"), Field.GUI_Type.Chance),
                new Field("Slikbutikken", 1, stringContainer.getString("field_palace_gates"), Field.GUI_Type.Street),
                new Field("Isbutikken", 1, stringContainer.getString("field_cold_desert"), Field.GUI_Type.Street),
                new Field("Fængsel", 0, stringContainer.getString("field_walled_city"), Field.GUI_Type.Jail),
                new Field("Museet", 2, stringContainer.getString("field_monastary"), Field.GUI_Type.Street),
                new Field("Biblioteket", 2, stringContainer.getString("field_black_cave"), Field.GUI_Type.Street),
                new Field("Chance", 0, stringContainer.getString("field_huts_in_the_mountain"), Field.GUI_Type.Chance),
                new Field("Skaterparken", 2, stringContainer.getString("field_the_werewall"), Field.GUI_Type.Street),
                new Field("Swimmingpool", 2, stringContainer.getString("field_the_pit"), Field.GUI_Type.Street),
                new Field("Parkering", 0, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Spillehallen", 3, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Biografen", 3, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Chance", 0, stringContainer.getString("field_goldmine"), Field.GUI_Type.Chance),
                new Field("Legetøjsbutikken", 3, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Dyrehandlen", 3, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Gå i fængsel", 0, stringContainer.getString("field_goldmine"), Field.GUI_Type.Jail),
                new Field("Bowlinghallen", 4, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Zoo", 4, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Chance", 0, stringContainer.getString("field_goldmine"), Field.GUI_Type.Chance),
                new Field("Vandlandet", 0, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
                new Field("Strandpromenaden", 5, stringContainer.getString("field_goldmine"), Field.GUI_Type.Street),
        };
    }


}
