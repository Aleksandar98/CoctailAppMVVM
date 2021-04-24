package com.aca.coctailappmvvm.repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aca.coctailappmvvm.api.ApiClient;
import com.aca.coctailappmvvm.models.Coctail;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                .subscribe(new Consumer<Coctail>() {
                    @Override
                    public void accept(Coctail coctail) throws Throwable {
                        Log.d("myTag", "accept: "+coctail);
                        mutableLiveData.postValue(coctail);
                    }
                });

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
