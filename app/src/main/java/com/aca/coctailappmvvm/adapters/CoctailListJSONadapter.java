package com.aca.coctailappmvvm.adapters;

import com.aca.coctailappmvvm.models.Coctail;
import com.aca.coctailappmvvm.models.CoctailList;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoctailListJSONadapter extends TypeAdapter<CoctailList> {
    @Override
    public void write(JsonWriter out, CoctailList value) throws IOException {

    }

    @Override
    public CoctailList read(JsonReader in) throws IOException {
        CoctailList coctailList = new CoctailList();
        in.beginObject();

        String s = in.nextName();
        in.beginArray();
        while (in.hasNext()) {
            in.beginObject();

            String idDrink = "";
            String strDrink = "";
            String strAlcoholic = "";
            String strInstructions = "";
            String strDrinkThumb = "";
            List<String> ingredients = new ArrayList();
            while (in.hasNext()) {

                switch (in.nextName()) {
                    case "idDrink":
                        idDrink = in.nextString();
                        break;
                    case "strDrink":
                        strDrink = in.nextString();
                        break;
                    case "strAlcoholic":
                        strAlcoholic = in.nextString();
                        break;
                    case "strInstructions":
                        strInstructions = in.nextString();
                        break;
                    case "strDrinkThumb":
                        strDrinkThumb = in.nextString();
                        break;
                    case "strIngredient1": {
                        while (in.peek() != JsonToken.NULL) {
                            String ing = in.nextString();
                            ingredients.add(ing);
                            in.nextName();
                        }
                        in.skipValue();
                    }
                    ;
                    break;

                    default:
                        in.skipValue();

                }


            }

            in.endObject();
           coctailList.coctailList.add( new Coctail(idDrink,strDrink,strInstructions,strDrinkThumb,strAlcoholic,ingredients));
        }
        in.endArray();
        in.endObject();

        return coctailList;
    }
}
