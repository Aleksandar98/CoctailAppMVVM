package com.aca.coctailappmvvm.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.aca.coctailappmvvm.api.ApiClient;
import com.aca.coctailappmvvm.models.Coctail;
import com.aca.coctailappmvvm.models.CoctailList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

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

        ApiClient.getClient().getRandomCoctail()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CoctailList>() {
                    @Override
                    public void accept(CoctailList coctail) throws Throwable {
                        mutableLiveData.postValue(coctail.coctailList.get(0));
                    }
                });

        return mutableLiveData;
    }

    public Flowable<CoctailList> refreshRandom(){
        return ApiClient.getClient().getRandomCoctail();
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

    public MutableLiveData<List<Coctail>> searchCoctail(String search){

        MutableLiveData<List<Coctail>> mutableLiveData = new MutableLiveData();

        ApiClient.getClient().getCoctailByName(search)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CoctailList>() {
                    @Override
                    public void accept(CoctailList coctails) throws Throwable {
                         mutableLiveData.postValue(coctails.coctailList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("myTag", "accept: "+throwable.getMessage());
                    }
                });

        return mutableLiveData;
    }
}
