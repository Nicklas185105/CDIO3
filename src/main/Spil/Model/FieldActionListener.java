package main.Spil.Model;

/**
 * Any class the implements a FieldActionListener must have the method onFieldLandedOn(FieldAction action).
 * Classes the extend this interface expects to have the "onFieldLandedOn" method invoked when a player lands on a field
 * */
public interface FieldActionListener {
    void onFieldLandedOn(FieldAction action);
}
