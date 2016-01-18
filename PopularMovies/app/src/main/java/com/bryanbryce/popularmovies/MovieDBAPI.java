package com.bryanbryce.popularmovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bryan on 1/15/16.
 */

public interface MovieDBAPI {
        @GET("discover/movie")
        Call<List<Movie>> listMovies(@Query("sort_by") String sort, @Query("api_key") String key);

        @GET("discover/movie?sort_by=popularity.desc&api_key=" + R.string.API_KEY)
        Call<List<Movie>> listMoviesBy();
}



