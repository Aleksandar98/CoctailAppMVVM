package com.aca.coctailappmvvm.viewmodels;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aca.coctailappmvvm.MainActivity;
import com.aca.coctailappmvvm.models.Coctail;
import com.aca.coctailappmvvm.models.CoctailList;
import com.aca.coctailappmvvm.repositories.CoctailRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Coctail> mRandomCoctail;
    private MutableLiveData<List<Coctail>> mCoctailSearch;
    private MutableLiveData<List<String>> mRecentSearches;
    private CoctailRepository coctailRepository;
    private MutableLiveData<Boolean> isLoading;

    public void init(){
        if(mRandomCoctail!=null)
            return;
        coctailRepository = CoctailRepository.getInstance();
        mRandomCoctail = coctailRepository.getRandomCoctail();
        mRecentSearches = coctailRepository.getmRecentSearches();
        isLoading = new MutableLiveData<>(false);
    }

    public LiveData<Coctail> getRandomCoctail(){
        return  mRandomCoctail;
    }

    public LiveData<List<String>> getmRecentSearches() {
        return mRecentSearches;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<List<Coctail>> getSearchedCoctails(){ return mCoctailSearch; }

    public void refreshCoctail() {

        //PORVERI MOZDA MOZE I NESTO SA ADD SOURCE princip
        coctailRepository.refreshRandom()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CoctailList>() {
                    @Override
                    public void accept(CoctailList coctailList) throws Throwable {
                        mRandomCoctail.postValue(coctailList.coctailList.get(0));
                    }
                });

    }

    public void searchCoctail(String pretraga) {
        isLoading.postValue(true);
        mCoctailSearch = coctailRepository.searchCoctail(pretraga);


        List<String> searches = mRecentSearches.getValue();
        searches.set(2,searches.get(1));
        searches.set(1,searches.get(0));
        searches.set(0,pretraga);
        mRecentSearches.postValue(searches);

        isLoading.postValue(false);
    }
}
