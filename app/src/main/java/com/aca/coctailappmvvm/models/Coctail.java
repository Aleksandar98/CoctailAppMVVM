package com.aca.coctailappmvvm.models;

import com.aca.coctailappmvvm.adapters.CoctailJSONadapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonAdapter(CoctailJSONadapter.class)
public class Coctail {
    @SerializedName("idDrink")
    @Expose
    String idDrink;

    @SerializedName("strDrink")
    @Expose
    String drinkName;

    @SerializedName("strInstructions")
    @Expose
    String instructions;

    @SerializedName("strDrinkThumb")
    @Expose
    String drinkImg;

    @SerializedName("strAlcoholic")
    @Expose
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

    @Override
    public String toString() {
        return "Coctail{" +
                "idDrink='" + idDrink + '\'' +
                ", drinkName='" + drinkName + '\'' +
                ", instructions='" + instructions + '\'' +
                ", drinkImg='" + drinkImg + '\'' +
                ", drinkType='" + drinkType + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
