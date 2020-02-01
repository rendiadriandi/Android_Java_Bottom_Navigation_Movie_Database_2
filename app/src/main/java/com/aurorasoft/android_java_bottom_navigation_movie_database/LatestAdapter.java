package com.aurorasoft.android_java_bottom_navigation_movie_database;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class LatestAdapter extends RecyclerView .Adapter<LatestAdapter.CardViewHolder>{

    private List<Latest> latests;
    private Context context;

    public LatestAdapter(Context context, ArrayList<Latest> latests) {
        this.latests = latests;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.latest_layout, parent, false);
        CardViewHolder v = new CardViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final String id, poster_path, title, release_date, overview;
        id = latests.get(position).getId();
        poster_path = latests.get(position).getPoster_path();
        title = latests.get(position).getTitle();
        overview = latests.get(position).getOverview();

        holder.tv.setText(title);
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+poster_path)
                .placeholder(R.drawable.ic_img_holder)
                .into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("bID",id);
                bundle.putString("bTitle",title);
                bundle.putString("bOverview",overview);
                bundle.putString("bPoster_path", poster_path);

                Intent i = new Intent(context,DetailActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() { return latests.size();}

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.latest_tv);
            iv = (ImageView) itemView.findViewById(R.id.latest_img);
        }
    }
}
