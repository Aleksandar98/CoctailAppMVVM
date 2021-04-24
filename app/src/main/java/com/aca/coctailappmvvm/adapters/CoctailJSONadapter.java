package com.aca.coctailappmvvm.adapters;

import android.util.Log;

import com.aca.coctailappmvvm.models.Coctail;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoctailJSONadapter extends TypeAdapter<Coctail> {

    @Override
    public void write(JsonWriter out, Coctail value) throws IOException {
        out.beginObject();
        out.name("idDrink");
        out.value(value.getIdDrink());

        out.name("strDrink");
        out.value(value.getDrinkName());

        out.name("strDrinkThumb");
        out.value(value.getDrinkImg());

        out.name("strAlcoholic");
        out.value(value.getDrinkType());

        out.name("strInstructions");
        out.value(value.getInstructions());
        out.endObject();
    }

    @Override
    public Coctail read(JsonReader in) throws IOException {

        in.beginObject();

        String s = in.nextName();
        in.beginArray();
        in.beginObject();

        String idDrink ="";
        String strDrink ="";
        String strAlcoholic ="";
        String strInstructions ="";
        String strDrinkThumb ="";
        List<String> ingredients = new ArrayList();
        while(in.hasNext()){

            switch (in.nextName()){
                case "idDrink" :idDrink=in.nextString();break;
                case "strDrink" :strDrink=in.nextString();break;
                case "strAlcoholic" :strAlcoholic=in.nextString();break;
                case "strInstructions" :strInstructions=in.nextString();break;
                case "strDrinkThumb" :strDrinkThumb=in.nextString();break;
                case "strIngredient1" :{
                    while(in.peek() != JsonToken.NULL){
                        String ing = in.nextString();
                        ingredients.add(ing);
                        in.nextName();
                    }
                    in.skipValue();
                };break;

                default: in.skipValue();

            }


        }

        in.endObject();
        in.endArray();
        in.endObject();

        return new Coctail(idDrink,strDrink,strInstructions,strDrinkThumb,strAlcoholic,ingredients);
    }
}
