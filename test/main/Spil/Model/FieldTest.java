package main.Spil.Model;

import gui_fields.GUI_Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {


    @Test
    void toGUI() {

        String name = "Burgerbaren";
        int value = 1;
        String fieldText = "Du er nu landet på Burgerbaren";
        Field.GUI_Type fieldType = Field.GUI_Type.Street_Brown;
        Field field = new Field(name, value, fieldText, fieldType);



        GUI_Field guiField = field.toGUI();


        Assert.assertEquals(guiField.getTitle(),field.name);
        Assert.assertEquals(guiField.getDescription(),fieldText);
        Assert.assertEquals(Integer.parseInt(guiField.getSubText().replace(" ", "")), value);
        Assert.assertTrue(FieldExtensions.isOwnableField(guiField));
        Assert.assertEquals(FieldExtensions.toOwnable(guiField).rentLable, "Leje: ");



    }
}