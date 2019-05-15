package com.tugasmobile.diss.tugas02sules;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements android.widget.SearchView.OnQueryTextListener, SearchView.OnQueryTextListener {
    private RecyclerView rv_main;
    private ProgressBar pb_main;
    private ArrayList<Movie> listMovies = new ArrayList<>();
    private ListMovieAdapter listMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search Movie");
        rv_main = findViewById(R.id.rv_main);
        pb_main = findViewById(R.id.pb_main);
        loadData();
    }

    private void showRecyclerList(){
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        listMovieAdapter = new ListMovieAdapter(this);
        listMovieAdapter.setListMovie(listMovies);
        rv_main.setAdapter(listMovieAdapter);
    }

    private void loadData() {
        URL url = Api.getListMovie();
        Log.e("url", url.toString());
        new MovieAsyncTask().execute(url);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    protected class MovieAsyncTask extends AsyncTask<URL, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb_main.setVisibility(View.VISIBLE);
            rv_main.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String result = null;
            try {
                result = Network.getFromNetwork(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("result", result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i=0; i<jsonArray.length(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    Movie movie = new Movie(object);
                    listMovies.add(movie);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (listMovies.size() != 0) {
                rv_main.setVisibility(View.VISIBLE);
                pb_main.setVisibility(View.GONE);
                showRecyclerList();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search_activity);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener( this);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                String userInput = newText.toLowerCase();
//                ArrayList<Movie> newListMovie = new ArrayList<>();
//                for (int i=0; i<listMovies.size(); i++) {
//                    if (listMovies.get(i).getTitle().toLowerCase().contains(userInput));
//                        newListMovie.add(listMovies.get(i));
//                }
//                listMovieAdapter.updateList(newListMovie);
//                return false;
//            }
//        });
        return true;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        ArrayList<Movie> newListMovie = new ArrayList<>();
        for (int i=0; i<listMovies.size(); i++) {
            if (listMovies.get(i).getTitle().toLowerCase().contains(userInput)) {
                newListMovie.add(listMovies.get(i));
            }
        }
        listMovieAdapter.updateList(newListMovie);
        return true;
    }
}
