package com.mirea.kt.datastorageapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {
    private List<Plant> plantList;

    public PlantAdapter(List<Plant> plantList) {
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new PlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant plant = plantList.get(position);
        holder.nameTextView.setText(plant.getName());
        holder.varietyTextView.setText(plant.getVariety());
        holder.greenhouseTextView.setText(plant.isGreenhousePlant() ? "Greenhouse Plant" : "Outdoor Plant");
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    static class PlantViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView varietyTextView;
        TextView greenhouseTextView;

        public PlantViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            varietyTextView = itemView.findViewById(R.id.varietyTextView);
            greenhouseTextView = itemView.findViewById(R.id.greenhouseTextView);
        }
    }
}
