package com.aca.coctailappmvvm.api;

import com.aca.coctailappmvvm.models.Coctail;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoctailAPI {

    @GET("random.php")
    Call<Coctail> getRandomCoctail();

    @GET("/search.php?s={name}")
    Call<Coctail> getCoctailByName(
            @Path("name") String name
    );
}
