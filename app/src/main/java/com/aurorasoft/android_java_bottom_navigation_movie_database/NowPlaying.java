package com.aurorasoft.android_java_bottom_navigation_movie_database;

public class NowPlaying {

    String id, poster_path, title, release_date;

    public NowPlaying(String id, String poster_path, String title, String release_date) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
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
}
