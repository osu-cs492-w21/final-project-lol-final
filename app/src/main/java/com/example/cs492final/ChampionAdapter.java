package com.example.cs492final;

import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cs492final.data.ChampionWTags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.ViewHolder> {
    //champion data
    private List<ChampionWTags>championData;
    private List<ChampionWTags> championWTags;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView champion_name;
        TextView champion_title;
        TextView champion_tag;
        TextView champion_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            champion_name=itemView.findViewById(R.id.champion_name);
            champion_title=(itemView.findViewById(R.id.champion_title);
            champion_tag=itemView.findViewById(R.id.champion_tag);

        }
    }
    public ChampionAdapter(List<ChampionWTags>championDataList){
        championData=championDataList;
    }
    @NonNull
    @Override
    public ChampionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.champion_list_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChampionAdapter.ViewHolder holder, int position) {
        ChampionWTags championWTags = championData.get(position);
        holder.champion_name.setText(ChampionWTags.getName());
        holder.champion_title.setText(ChampionWTags.getTitle());
        holder.champion_tag.setText(ChampionWTags.getTags());
    }
    public void updateChampionData(List<ChampionWTags> championWTags) {
        // sort data
        Collections.reverse(championWTags);
        this.championWTags = championWTags;
        // update UI
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return championData.size();
    }
}
