package com.example.myrecyclerviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements IRecyclerView {
    private TextView failedSearchMessage;
    private SearchView characterSearchBar;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<CharacterModel> dataSet;
    private ArrayList<CharacterModel> currentUsedDataSet;

    private CharacterAdapter characterAdapter;
    private Dialog characterPopupDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLinearLayoutManager();
        initializeCharacterSearchBar();
        initializeRecyclerView();
        initializeDataSet();
        initializeCharacterAdapter();
        initializeCharacterPopupDialog();
    }

    private void initializeLinearLayoutManager() {
        linearLayoutManager = new LinearLayoutManager(this);
    }

    private void initializeCharacterSearchBar() {
        characterSearchBar = findViewById(R.id.sv_character_search_bar);
        characterSearchBar.clearFocus(); // Some devices show the keyboard by default when the activity starts
        characterSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterAndDisplayTheCorrectCharactersAccordingToTheSearch(newText);
                return true;
            }
        });

        failedSearchMessage = findViewById(R.id.tv_failed_search_message);
        failedSearchMessage.setVisibility(View.GONE); // Hide the message by default
    }

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.rv_container);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initializeDataSet() {
        dataSet = new ArrayList<CharacterModel>(CharactersData.CHARACTERS_COUNT);

        for (int i = 0; i < CharactersData.CHARACTERS_COUNT; i++) {
            String name = CharactersData.NAMES[i];
            String shortDescription = CharactersData.SHORT_DESCRIPTIONS[i];
            String longDescription = CharactersData.LONG_DESCRIPTIONS[i];
            int profile = CharactersData.PROFILES[i];

            CharacterModel character = new CharacterModel(name, shortDescription, longDescription, profile);
            dataSet.add(character);
        }

        currentUsedDataSet = new ArrayList<CharacterModel>(dataSet);
    }

    private void initializeCharacterAdapter() {
        characterAdapter = new CharacterAdapter(dataSet, this);
        recyclerView.setAdapter(characterAdapter);
    }

    private void initializeCharacterPopupDialog() {
        characterPopupDialog = new Dialog(this);
        characterPopupDialog.setContentView(R.layout.dialog_character_popup);
        Objects.requireNonNull(characterPopupDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
    }

    private void filterAndDisplayTheCorrectCharactersAccordingToTheSearch(@NonNull String newText) {
        if (newText.isEmpty()) {
            failedSearchMessage.setVisibility(View.GONE);
            currentUsedDataSet = new ArrayList<CharacterModel>(dataSet);
            characterAdapter = new CharacterAdapter(dataSet, this);
            recyclerView.setAdapter(characterAdapter);
        } else {
            ArrayList<CharacterModel> filteredDataSet = new ArrayList<CharacterModel>(CharactersData.CHARACTERS_COUNT);

            for (CharacterModel character : dataSet) {
                String lowerCaseName = character.getName().toLowerCase();

                if (lowerCaseName.contains(newText.toLowerCase())) {
                    filteredDataSet.add(character);
                }
            }

            if (filteredDataSet.isEmpty()) {
                failedSearchMessage.setVisibility(View.VISIBLE);
            } else {
                failedSearchMessage.setVisibility(View.GONE);
            }

            currentUsedDataSet = new ArrayList<CharacterModel>(filteredDataSet);
            characterAdapter = new CharacterAdapter(currentUsedDataSet, this);
            recyclerView.setAdapter(characterAdapter);
        }
    }

    @Override
    public void onCharacterCardClick(int position) {
        ImageView characterProfile = characterPopupDialog.findViewById(R.id.iv_character_popup_profile);
        characterProfile.setImageResource(currentUsedDataSet.get(position).getProfile());

        TextView characterName = characterPopupDialog.findViewById(R.id.tv_character_popup_name);
        characterName.setText(currentUsedDataSet.get(position).getName());

        TextView characterLongDescription = characterPopupDialog.findViewById(R.id.tv_character_popup_description);
        characterLongDescription.setText(currentUsedDataSet.get(position).getLongDescription());

        characterPopupDialog.show();
    }

    public void closeCharacterPopup(View view) {
        characterPopupDialog.dismiss();
        characterSearchBar.clearFocus();
    }
}