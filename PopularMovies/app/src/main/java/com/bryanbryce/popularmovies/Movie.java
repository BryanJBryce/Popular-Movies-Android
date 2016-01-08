package com.bryanbryce.popularmovies;

/**
 * Created by bryan on 1/5/16.
 */
public class Movie {

    private String mID;

    private String mTitle;

    public Movie(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
