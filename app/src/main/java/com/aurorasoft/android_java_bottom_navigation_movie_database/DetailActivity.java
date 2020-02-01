package com.aurorasoft.android_java_bottom_navigation_movie_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final ImageView iv = (ImageView) findViewById(R.id.toolbarImageDetail);
        final CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarDetail);
        final TextView tx = (TextView) findViewById(R.id.tv_overview);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String id = b.getString("bID");
        String title = b.getString("bTitle");
        String overview = b.getString("bOverview");
        String poster_path = b.getString("bPoster_path");

        ctl.setTitle(title);
        tx.setText(overview);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+poster_path)
                .placeholder(R.drawable.ic_img_holder)
                .into(iv)
        ;

    }
}
