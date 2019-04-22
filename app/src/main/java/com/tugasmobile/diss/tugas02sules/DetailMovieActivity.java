package com.tugasmobile.diss.tugas02sules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDescription;
    TextView tvVote;
    TextView tvRelease;
    ImageView ivImage;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.detail_title);
        tvDescription = findViewById(R.id.detail_description);
        tvVote = findViewById(R.id.detail_star);
        tvRelease = findViewById(R.id.detail_release_date);
        ivImage = findViewById(R.id.detail_image);

        movie = getIntent().getParcelableExtra("MOVIE");
        tvTitle.setText(movie.getName());
        tvDescription.setText(movie.getDescription());
        tvVote.setText(String.valueOf(movie.getVote_average()));
        tvRelease.setText(movie.getRelease_date());
        Glide.with(this)
                .load(Integer.valueOf(movie.getPhoto()))
                .apply(new RequestOptions().override(70,100))
                .into(ivImage);
    }
}
