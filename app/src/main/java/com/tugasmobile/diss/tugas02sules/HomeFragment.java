package com.tugasmobile.diss.tugas02sules;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rv_main;
    private ArrayList<Movie> listMovies = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listMovies.addAll(MovieData.getListData());
        rv_main = view.findViewById(R.id.rv_main);
        showRecyclerList();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void showRecyclerList(){
        rv_main.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(getActivity().getBaseContext());
        listMovieAdapter.setListMovie(listMovies);
        rv_main.setAdapter(listMovieAdapter);
    }
}
