package com.aca.coctailappmvvm.models;

import java.util.List;

public class Coctail {

    String idDrink;
    String drinkName;
    String instructions;
    String drinkImg;
    String drinkType;
    List<String> ingredients;


    public Coctail(String idDrink, String drinkName, String instructions, String drinkImg, String drinkType, List<String> ingredients) {
        this.idDrink = idDrink;
        this.drinkName = drinkName;
        this.instructions = instructions;
        this.drinkImg = drinkImg;
        this.drinkType = drinkType;
        this.ingredients = ingredients;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getDrinkImg() {
        return drinkImg;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDrinkType() {
        return drinkType;
    }
}
