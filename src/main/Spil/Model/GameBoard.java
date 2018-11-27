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
                new Field(stringContainer.getString("field_start_titel"), 1, "Start",Field.GUI_Type.Start),
                new Field(stringContainer.getString("field_burgerbar_titel"), 1, stringContainer.getString("field_burger_baren"), Field.GUI_Type.Street_Brown),
                new Field("Pizzariaet", 1, stringContainer.getString("field_pizzariaet"), Field.GUI_Type.Street_Brown),
                new Field("C", 0, stringContainer.getString("field_prøv_lykken"), Field.GUI_Type.Chance),
                new Field("Slikbutikken", 1, stringContainer.getString("field_slik_butikken"), Field.GUI_Type.Street_Cyan),
                new Field("Isbutikken", 1, stringContainer.getString("field_is_kiosken"), Field.GUI_Type.Street_Cyan),
                new Field("Fængsel", 0, stringContainer.getString("field_fængsel"), Field.GUI_Type.Jail),
                new Field("Museet", 2, stringContainer.getString("field_museet"), Field.GUI_Type.Street_Purple),
                new Field("Biblioteket", 2, stringContainer.getString("field_biblioteket"), Field.GUI_Type.Street_Purple),
                new Field("C", 1, stringContainer.getString("field_prøv_lykken"), Field.GUI_Type.Chance),
                new Field("Skaterparken", 2, stringContainer.getString("field_skate_parken"), Field.GUI_Type.Street_Orange),
                new Field("Swimmingpool", 2, stringContainer.getString("field_swimming_poolen"), Field.GUI_Type.Street_Orange),
                new Field("Parkering", 0, stringContainer.getString("field_parkering"), Field.GUI_Type.Brewery),
                new Field("Spillehallen", 3, stringContainer.getString("field_spille_hallen"), Field.GUI_Type.Street_Red),
                new Field("Biografen", 3, stringContainer.getString("field_kinoen"), Field.GUI_Type.Street_Red),
                new Field("C", 0, stringContainer.getString("field_prøv_lykken"), Field.GUI_Type.Chance),
                new Field("Legetøjsbutikken", 3, stringContainer.getString("field_legetøjs_butikken"), Field.GUI_Type.Street_Yellow),
                new Field("Dyrehandlen", 3, stringContainer.getString("field_dyre_butikken"), Field.GUI_Type.Street_Yellow),
                new Field("Gå i fængsel", 0, stringContainer.getString("field_gå_fængsel"), Field.GUI_Type.Jail),
                new Field("Bowlinghallen", 4, stringContainer.getString("field_bowling_hallen"), Field.GUI_Type.Street_Green),
                new Field("Zoo", 4, stringContainer.getString("field_zoo"), Field.GUI_Type.Street_Green),
                new Field("C", 0, stringContainer.getString("field_prøv_lykken"), Field.GUI_Type.Chance),
                new Field("Vandlandet", 5, stringContainer.getString("field_vandlandet"), Field.GUI_Type.Street_Blue),
                new Field("Strandpromenaden", 5, stringContainer.getString("field_strand_promenaden"), Field.GUI_Type.Street_Blue),
        };
    }


}
