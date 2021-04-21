package com.aca.coctailappmvvm.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aca.coctailappmvvm.models.Coctail;

import java.util.ArrayList;
import java.util.List;

public class CoctailRepository {

    private static CoctailRepository instance;

    public static CoctailRepository getInstance() {
        if(instance==null)
            instance = new CoctailRepository();
        return instance;
    }

    public MutableLiveData<Coctail> getRandomCoctail(){

        //TODO Get Random coctail using RxJava2

        MutableLiveData<Coctail> mutableLiveData = new MutableLiveData();
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Tequila");
        ingredients.add("Triple sec");
        ingredients.add("Lime juice");
        ingredients.add("Salt");
        mutableLiveData.postValue(new Coctail("11007","Margarita","\"Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass."
        ,"https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg","Alcoholic",ingredients));
        return mutableLiveData;
    }

    public MutableLiveData<List<String>> getmRecentSearches() {

        //TODO Get last 3 searches from Db or savedState

        MutableLiveData<List<String>> mutableLiveData = new MutableLiveData();
        List<String> searches = new ArrayList<>();
        searches.add("Search1");
        searches.add("Search2");
        searches.add("Search3");
        mutableLiveData.postValue(searches);

        return mutableLiveData;

    }
}
