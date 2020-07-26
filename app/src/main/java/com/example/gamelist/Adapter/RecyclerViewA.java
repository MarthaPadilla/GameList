package com.example.gamelist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamelist.Modelo.Games;
import com.example.gamelist.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewA extends RecyclerView.Adapter<RecyclerViewA.ItemsViewHolder> {
    private Context mCon;
    private ArrayList<Games> lsitaGame;

    public RecyclerViewA(Context mCon, ArrayList<Games> listagame){
        this.mCon=mCon;
        this.lsitaGame=listagame;
    }
    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCon).inflate(R.layout.games_item, parent, false);
        return new ItemsViewHolder(view);
    }
@Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position){
        Games cItem = lsitaGame.get(position);

        String released = cItem.getReleased();
        String name=cItem.getName();
        String slug=cItem.getSlug();
        String rating=cItem.getRating();
        String urlImage=cItem.getBackground_image();


    holder.tv_name.setText(name);
    holder.tv_rating.setText(rating);
    holder.tv_slug.setText(slug);
    holder.tv_released.setText(released);

    Picasso.get().load(urlImage).into(holder.img_thumbnall);
}

    @Override
    public int getItemCount() {
        return lsitaGame.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_name;
        public TextView tv_released;
        public TextView tv_slug;
        public TextView tv_rating;
        public ImageView img_thumbnall;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
            tv_released =itemView.findViewById(R.id.released);
            tv_slug = itemView.findViewById(R.id.slug);
            tv_rating = itemView.findViewById(R.id.rating);
            img_thumbnall =itemView.findViewById(R.id.imgthumbnail);

        }
    }
}
