package com.aca.coctailappmvvm.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aca.coctailappmvvm.models.Coctail;
import com.aca.coctailappmvvm.repositories.CoctailRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Coctail> mRandomCoctail;
    private MutableLiveData<List<String>> mRecentSearches;

    private CoctailRepository coctailRepository;

    public void init(Context context){
        if(mRandomCoctail!=null)
            return;
        coctailRepository = CoctailRepository.getInstance(context);
        mRandomCoctail = coctailRepository.getRandomCoctail();
        mRecentSearches = coctailRepository.getmRecentSearches();
    }

    public LiveData<Coctail> getRandomCoctail(){
        return  mRandomCoctail;
    }

    public LiveData<List<String>> getmRecentSearches() {
        return mRecentSearches;
    }

    public void refreshCoctail() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Bacardi Limon");
        ingredients.add("Coca-Cola");
        Coctail coctail = new Coctail("17135","Citrus Coke","Pour half of coke in a glass. Then add Bacardi and top it off with the remaining coke. Stir and drink up!"
        , "https://www.thecocktaildb.com/images/media/drink/uyrvut1479473214.jpg","Alcoholic",ingredients);
        mRandomCoctail.postValue(coctail);
    }

    public void searchCoctail(String pretraga) {
        List<String> searches = mRecentSearches.getValue();
        searches.set(2,searches.get(1));
        searches.set(1,searches.get(0));
        searches.set(0,pretraga);
        mRecentSearches.postValue(searches);
    }
}
