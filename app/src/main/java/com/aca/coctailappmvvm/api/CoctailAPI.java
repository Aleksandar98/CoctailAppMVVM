package com.aca.coctailappmvvm.api;

import com.aca.coctailappmvvm.adapters.CoctailListJSONadapter;
import com.aca.coctailappmvvm.models.Coctail;
import com.aca.coctailappmvvm.models.CoctailList;
import com.google.gson.annotations.JsonAdapter;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CoctailAPI {

    @GET("random.php")
    Flowable<CoctailList> getRandomCoctail();
    
    @GET("search.php")
    Flowable<CoctailList> getCoctailByName(
            @Query("s") String name
    );
}
