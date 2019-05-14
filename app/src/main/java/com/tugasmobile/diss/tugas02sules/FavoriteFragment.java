package com.tugasmobile.diss.tugas02sules;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private RecyclerView rv_main;
    private ProgressBar pb_main;
    private ArrayList<Movie> listMovies = new ArrayList<>();
    private RealmResults<Movie> movies;
    private Realm realm;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment
        getActivity().setTitle("Favorite");
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        rv_main = view.findViewById(R.id.rv_main);
        pb_main = view.findViewById(R.id.pb_main);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Realm.init(getActivity());

        try {
            realm = Realm.getDefaultInstance();
        } catch (RealmMigrationNeededException r) {
            Realm.deleteRealm(realm.getDefaultConfiguration());
            realm = Realm.getDefaultInstance();
        }

        movies = realm.where(Movie.class).findAll();
//        realm.beginTransaction();
//        movies.deleteAllFromRealm();
//        realm.commitTransaction();
        listMovies.addAll(realm.copyFromRealm(movies));
        showRecyclerList();
    }

    private void showRecyclerList(){
        if (listMovies.size() != 0) {
            rv_main.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
            ListMovieAdapter listMovieAdapter = new ListMovieAdapter(getActivity().getBaseContext());
            listMovieAdapter.notifyDataSetChanged();
            listMovieAdapter.setListMovie(listMovies);
            rv_main.setAdapter(listMovieAdapter);
            pb_main.setVisibility(View.GONE);
        } else {
            pb_main.setVisibility(View.VISIBLE);
        }

    }

}
