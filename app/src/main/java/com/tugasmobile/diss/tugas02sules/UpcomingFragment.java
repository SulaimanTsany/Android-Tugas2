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


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {
    private RecyclerView rv_main;
    private ProgressBar pb_main;
    private ArrayList<Movie> listMovies = new ArrayList<>();

    public UpcomingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Upcoming Movie");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //listMovies.addAll(MovieData.getListData());
        rv_main = view.findViewById(R.id.rv_main);
        pb_main = view.findViewById(R.id.pb_main);
        loadData();
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

    private void loadData() {
        URL url = Api.getUpcomingMovie(1);
        Log.e("url", url.toString());
        new UpcomingFragment.MovieAsyncTask().execute(url);
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

}
