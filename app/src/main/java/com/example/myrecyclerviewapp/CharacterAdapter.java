package com.example.myrecyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private ArrayList<CharacterModel> dataSet;

    public CharacterAdapter(ArrayList<CharacterModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final CardView CHARACTER_CARD;
        public final ImageView CHARACTER_PROFILE;
        public final TextView CHARACTER_NAME;
        public final TextView CHARACTER_DESCRIPTION;

        public ViewHolder(View view) {
            super(view);
            CHARACTER_CARD = (CardView) view.findViewById(R.id.cv_character);
            CHARACTER_PROFILE = (ImageView) view.findViewById(R.id.iv_character_profile);
            CHARACTER_NAME = (TextView) view.findViewById(R.id.tv_character_name);
            CHARACTER_DESCRIPTION = (TextView) view.findViewById(R.id.tv_character_description);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.character_card_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        CharacterModel character = dataSet.get(position);

        viewHolder.CHARACTER_PROFILE.setImageResource(character.getProfile());
        viewHolder.CHARACTER_NAME.setText(character.getName());
        viewHolder.CHARACTER_DESCRIPTION.setText(character.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
