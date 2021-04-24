package com.aca.coctailappmvvm.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aca.coctailappmvvm.MainActivity;
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
        coctailRepository = CoctailRepository.getInstance();
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

        //TODO post value to mRandomCoctail somehow

    }

    public void searchCoctail(String pretraga) {
        List<String> searches = mRecentSearches.getValue();
        searches.set(2,searches.get(1));
        searches.set(1,searches.get(0));
        searches.set(0,pretraga);
        mRecentSearches.postValue(searches);
    }
}
