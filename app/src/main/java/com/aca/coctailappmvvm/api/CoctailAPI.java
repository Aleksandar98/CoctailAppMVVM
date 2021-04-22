package com.aca.coctailappmvvm.api;

import com.aca.coctailappmvvm.models.Coctail;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoctailAPI {

    @GET("random.php")
    Flowable<Coctail> getRandomCoctail();

    @GET("/search.php?s={name}")
    Flowable<Coctail> getCoctailByName(
            @Path("name") String name
    );
}
