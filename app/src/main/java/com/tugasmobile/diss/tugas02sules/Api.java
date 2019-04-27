package com.tugasmobile.diss.tugas02sules;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class Api {
    private static final String API_KEY = BuildConfig.API_KEY;
    private static final String BASE_URL = BuildConfig.BASE_URL;
//    private static final String LOOKUP_ALL_TEAM = "lookup_all_teams.php";
    private static final String KEY = "api_key";
//    private static final String PREMIERE_LEAGUE_ID = "4328";

    public static URL getListMovie(){
        // https://api.themoviedb.org/3/movie/now_playing?api_key=a229
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendPath("movie")
                .appendPath("now_playing")
                .appendQueryParameter(KEY, API_KEY)
                .build();

        URL url = null;
        try{
            url = new URL(uri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        return url;
    }

    public static URL getUpcomingMovie(int page){
        // https://api.themoviedb.org/3/movie/upcoming?api_key=a229
        Uri uri = Uri.parse("https://api.themoviedb.org/3").buildUpon()
                .appendPath("movie")
                .appendPath("upcoming")
                .appendQueryParameter("page", String.valueOf(page))
                .appendQueryParameter(KEY, API_KEY)
                .build();
        URL url = null;
        try{
            url = new URL(uri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static URL getPopularMovie(int page){
        // https://api.themoviedb.org/3/movie/popular?api_key=a229
        Uri uri = Uri.parse("https://api.themoviedb.org/3").buildUpon()
                .appendPath("movie")
                .appendPath("popular")
                .appendQueryParameter("page", String.valueOf(page))
                .appendQueryParameter(KEY, API_KEY)
                .build();
        URL url = null;
        try{
            url = new URL(uri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

}