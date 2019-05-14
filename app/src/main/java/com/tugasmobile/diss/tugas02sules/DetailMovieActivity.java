package com.tugasmobile.diss.tugas02sules;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import io.realm.Realm;
import io.realm.exceptions.RealmMigrationNeededException;

public class DetailMovieActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDescription;
    TextView tvVote;
    TextView tvRelease;
    ImageView ivImage;
    RatingBar rbStar;
    Movie movie;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Realm.init(this);

        try {
            realm = Realm.getDefaultInstance();
        } catch (RealmMigrationNeededException r) {
            Realm.deleteRealm(realm.getDefaultConfiguration());
            realm = Realm.getDefaultInstance();
        }

        tvTitle = findViewById(R.id.detail_title);
        tvDescription = findViewById(R.id.detail_description);
        tvVote = findViewById(R.id.detail_star);
        tvRelease = findViewById(R.id.detail_release_date);
        ivImage = findViewById(R.id.detail_image);
        rbStar = findViewById(R.id.detail_rb_item_star);

        movie = getIntent().getExtras().getParcelable("MOVIE");
        Movie movieInRealm = realm.where(Movie.class).equalTo("id", movie.getId()).findFirst();
        if (movieInRealm != null) {
            if (movieInRealm.isFavorited()) {
//                setFavorite();
                ImageView favoriteButton = findViewById(R.id.likeButton);
                favoriteButton.setImageResource(R.drawable.ic_love_24dp);
            } else {
                setUnfavorite(movieInRealm);
            }
        } else {
            ImageView favoriteButton = findViewById(R.id.likeButton);
            favoriteButton.setImageResource(R.drawable.ic_love_border_24dp);
        }
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

    public void favoriteButton(View view) {
        Movie movieInRealm = realm.where(Movie.class).equalTo("id", movie.getId()).findFirst();
        if (movieInRealm == null) {
            setFavorite();
        } else {
            setUnfavorite(movieInRealm);
        }
    }

    void setFavorite() {
        ImageView favoriteButton = findViewById(R.id.likeButton);

        Movie movieToSave = realm.where(Movie.class).equalTo("id", movie.getId()).findFirst();
        if (movieToSave == null) {
            movie.setFavorited(true);
            realm.beginTransaction();
            realm.copyToRealm(movie);
            realm.commitTransaction();
            favoriteButton.setImageResource(R.drawable.ic_love_24dp);
            Toast.makeText(this, movie.getTitle()+" add to favorite list", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, movieToSave.getTitle()+" already in favorite", Toast.LENGTH_SHORT).show();
        }
    }
    void setUnfavorite(Movie movie) {
        ImageView favoriteButton = findViewById(R.id.likeButton);
        favoriteButton.setImageResource(R.drawable.ic_love_border_24dp);
        Movie movieInRealm = realm.where(Movie.class).equalTo("id", movie.getId()).findFirst();
        if (movieInRealm != null) {
            realm.beginTransaction();
            movieInRealm.deleteFromRealm();
            realm.commitTransaction();
        } else {
            Toast.makeText(this, movie.getTitle()+" not in favorite", Toast.LENGTH_SHORT).show();
        }

    }
}
