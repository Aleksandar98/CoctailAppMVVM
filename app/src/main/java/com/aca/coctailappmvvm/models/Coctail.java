package com.aca.coctailappmvvm.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.aca.coctailappmvvm.adapters.CoctailJSONadapter;
import com.aca.coctailappmvvm.adapters.CoctailListJSONadapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@JsonAdapter(CoctailListJSONadapter.class)
public class Coctail implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idDrink);
        parcel.writeString(drinkName);
        parcel.writeString(instructions);
        parcel.writeString(drinkImg);
        parcel.writeString(drinkType);
        parcel.writeList(ingredients);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Coctail createFromParcel(Parcel in) {
            return new Coctail(in.readString(),in.readString(),in.readString(),in.readString(),in.readString(),in.readArrayList(ClassLoader.getSystemClassLoader()));
        }

        public Coctail[] newArray(int size) {
            return new Coctail[size];
        }
    };
}
