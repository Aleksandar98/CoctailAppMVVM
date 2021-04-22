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
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class CoctailRepository {

    private static CoctailRepository instance;
    private Context context;

    public static CoctailRepository getInstance(Context context) {
        if(instance==null)
            instance = new CoctailRepository(context);
        return instance;
    }

    public CoctailRepository(Context context){
        this.context = context;
    }

    public MutableLiveData<Coctail> getRandomCoctail(){

        //TODO Get Random coctail using RxJava2

        ApiClient.getClient(context).getRandomCoctail()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<Coctail>() {
                    @Override
                    public void onNext(Coctail coctail) {
                        Log.d("myTag", "onNext: "+coctail.getDrinkName());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


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
