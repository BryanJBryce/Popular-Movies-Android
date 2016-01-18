package com.bryanbryce.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    MovieDBAPI movieAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_top);

        if (fragment == null) {
            fragment = new MovieListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_top, fragment)
                    .commit();
        }
//        http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=[YOUR API KEY]
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieAPI = retrofit.create(MovieDBAPI.class);

//        http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=[YOUR API KEY]
        Call<List<Movie>> movies = movieAPI.listMovies("popularity.desc", R.string.API_KEY);
        movies.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Response<List<Movie>> response) {
                Log.d("NETWORKING", "onResponse: " + response.toString());
            }

            @Override
            public void onFailure(Throwable t) {
               Log.d("NETWORKING", "FAIL", t);

            }
        });
    }

}
