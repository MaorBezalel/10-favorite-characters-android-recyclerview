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
    private final IRecyclerView iRecyclerView;

    public CharacterAdapter(ArrayList<CharacterModel> dataSet, IRecyclerView iRecyclerView) {
        this.dataSet = dataSet;
        this.iRecyclerView = iRecyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final CardView CHARACTER_CARD;
        public final ImageView CHARACTER_PROFILE;
        public final TextView CHARACTER_NAME;
        public final TextView CHARACTER_SHORT_DESCRIPTION;

        public ViewHolder(View itemView, IRecyclerView iRecyclerView) {
            super(itemView);

            CHARACTER_CARD = (CardView) itemView.findViewById(R.id.cv_character);
            CHARACTER_PROFILE = (ImageView) itemView.findViewById(R.id.iv_character_profile);
            CHARACTER_NAME = (TextView) itemView.findViewById(R.id.tv_character_name);
            CHARACTER_SHORT_DESCRIPTION = (TextView) itemView.findViewById(R.id.tv_character_short_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iRecyclerView != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            iRecyclerView.onCharacterCardClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.character_card_item, viewGroup, false);

        return new ViewHolder(view, iRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CharacterModel character = dataSet.get(position);

        viewHolder.CHARACTER_PROFILE.setImageResource(character.getProfile());
        viewHolder.CHARACTER_NAME.setText(character.getName());
        viewHolder.CHARACTER_SHORT_DESCRIPTION.setText(character.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
