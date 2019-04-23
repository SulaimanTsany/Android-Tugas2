package com.tugasmobile.diss.tugas02sules;

public class Test {
    private float vote_average;
    private int vote_count;
    private long id;
    private String title;
    private long pupularity;
    private String poster_path;
    private String original_title;
    private String backdrop_path;
    private String release_date;

    public Test(float vote_average, int vote_count, long id, String title, long pupularity, String poster_path, String original_title, String backdrop_path, String release_date) {
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.id = id;
        this.title = title;
        this.pupularity = pupularity;
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.release_date = release_date;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPupularity() {
        return pupularity;
    }

    public void setPupularity(long pupularity) {
        this.pupularity = pupularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
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
}
