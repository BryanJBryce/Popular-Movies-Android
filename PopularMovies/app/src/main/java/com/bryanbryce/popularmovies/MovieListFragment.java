package com.bryanbryce.popularmovies;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bryan on 1/5/16.
 */
public class MovieListFragment extends Fragment {

    private static final String LOG_TAG = MovieListFragment.class.getSimpleName();
    private final String URL_DISCOVER_API = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        return view;
    }

    public URL buildImageUrl(String imagePath) {
        // EXAMPLE: http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
        final String MOVIEDB_BASE_URL = "http://image.tmdb.org/t/p/";
        final String SIZE_PATH = "w185";

        Uri builtUri = Uri.parse(MOVIEDB_BASE_URL).buildUpon()
                .appendPath(SIZE_PATH)
                .appendPath(imagePath)
                .build();
        try {
            URL url = new URL(builtUri.toString());
            return url;
        } catch (MalformedURLException e) {
            Log.d(LOG_TAG, "buildImageUrl: MALFORMED URL EXCEPTION THROWN!");

            return null;
        }
    }
}