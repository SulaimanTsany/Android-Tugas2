package com.tugasmobile.diss.tugas02sules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_main;
    private ArrayList<Movie> listMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMovies.addAll(MovieData.getListData());
        rv_main = findViewById(R.id.rv_main);
        showRecyclerList();
    }

    private void showRecyclerList(){
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(this);
        listMovieAdapter.setListMovie(listMovies);
        rv_main.setAdapter(listMovieAdapter);
    }
}
