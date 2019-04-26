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

    public static URL getPoster(String poster_path, String size){
        // https://image.thdb.org/t/p/{poster_size}/{porter_path}
        Uri uri = Uri.parse("https://image.tmdb.org/t/p").buildUpon()
                .appendPath(size)
                .appendPath(poster_path)
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