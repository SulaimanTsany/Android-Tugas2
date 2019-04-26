package com.tugasmobile.diss.tugas02sules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDescription;
    TextView tvVote;
    TextView tvRelease;
    ImageView ivImage;
    RatingBar rbStar;
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
        rbStar = findViewById(R.id.detail_rb_item_star);

        movie = getIntent().getExtras().getParcelable("MOVIE");
        tvTitle.setText(movie.getTitle());
        tvDescription.setText(movie.getOverview());
        tvVote.setText(String.valueOf(movie.getVote_average()));
        tvRelease.setText(movie.getRelease_date());
        rbStar.setRating(movie.getVote_average()/2);
        Glide.with(this)
                .load(movie.getBackdrop_path())
                .apply(new RequestOptions().override(1200, 840).optionalCenterCrop())
                .into(ivImage);
    }
}
