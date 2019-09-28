package com.aurorasoft.android_java_bottom_navigation_movie_database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.CardViewHolder> {

    private List<NowPlaying> nowPlayings;
    private Context context;

    public NowPlayingAdapter(Context context, ArrayList<NowPlaying> nowPlayings) {
        this.nowPlayings = nowPlayings;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.now_playing_layout, parent, false);
        CardViewHolder v = new CardViewHolder(view);
        return v;
    }


    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        String id, poster_path, title, release_date;
        id = nowPlayings.get(position).getId();
        poster_path = nowPlayings.get(position).getPoster_path();
        title = nowPlayings.get(position).getTitle();

        holder.tv.setText(title);
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+poster_path)
                .placeholder(R.drawable.ic_img_holder)
                .into(holder.iv)
        ;
    }

    @Override
    public int getItemCount() {
        return nowPlayings.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
