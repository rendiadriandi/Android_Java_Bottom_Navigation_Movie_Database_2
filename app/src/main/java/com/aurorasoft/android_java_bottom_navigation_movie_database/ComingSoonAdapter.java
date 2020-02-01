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

public class ComingSoonAdapter extends RecyclerView .Adapter<ComingSoonAdapter.CardViewHolder>{

    private List<ComingSoon> comingSoons;
    private Context context;

    public ComingSoonAdapter(Context context, ArrayList<ComingSoon> comingSoons) {
        this.comingSoons = comingSoons;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coming_soon_layout, parent, false);
        CardViewHolder v = new CardViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final String id, poster_path, title, release_date, overview;
        id = comingSoons.get(position).getId();
        poster_path = comingSoons.get(position).getPoster_path();
        title = comingSoons.get(position).getTitle();
        overview = comingSoons.get(position).getOverview();

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
    public int getItemCount() { return comingSoons.size();}

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.coming_tv);
            iv = (ImageView) itemView.findViewById(R.id.coming_img);
        }
    }
}
