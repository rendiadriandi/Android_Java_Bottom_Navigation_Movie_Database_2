package com.aurorasoft.android_java_bottom_navigation_movie_database;

public class Cari {

    String id, poster_path, title, release_date, overview;

    public Cari(String id, String poster_path, String title, String release_date, String overview) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOverview() { return overview; }
}
