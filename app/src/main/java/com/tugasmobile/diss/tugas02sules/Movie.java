package com.tugasmobile.diss.tugas02sules;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Movie extends RealmObject implements Parcelable {
    @Required
    @PrimaryKey
    private String id;
    @Required
    private String title;
    private String overview;
    @Required
    private String poster_path;
    private String release_date;
    @Required
    private String backdrop_path;
    private String poster;
    private String backdrop;
    private float vote_average;
    private int vote_count;
    private boolean favorited;

    public Movie () {}

    public Movie(JSONObject object){
        try {
            this.id = object.getString("id");
            this.title = object.getString("title");
            this.overview = object.getString("overview");
            this.poster_path = object.getString("poster_path");
            this.release_date = object.getString("release_date");
            this.backdrop_path = object.getString("backdrop_path");
            this.vote_average = Float.valueOf(object.getString("vote_average"));
            this.vote_count = object.getInt("vote_count");
            removeSlashImage();
            release_date = (new DateParser(release_date)).dateHumanist();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Movie (Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.overview = in.readString();
        this.poster_path = in.readString();
        this.release_date = in.readString();
        this.backdrop_path = in.readString();
        this.vote_average = in.readFloat();
        this.vote_count = in.readInt();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }


    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.poster_path);
        dest.writeString(this.release_date);
        dest.writeString(this.backdrop_path);
        dest.writeFloat(this.vote_average);
        dest.writeInt(this.vote_count);
    }
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public void removeSlashImage() {
        if (poster_path != null) {
            String[] arr = poster_path.split("/");
            poster_path = "https://image.tmdb.org/t/p/w154/" +arr[1];
        }
        if (backdrop_path != null) {
            backdrop_path = "https://image.tmdb.org/t/p/w500" + backdrop_path;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
