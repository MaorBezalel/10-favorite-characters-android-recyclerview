package com.example.myrecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<CharacterModel> dataSet;
    private CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLinearLayoutManager();
        initializeRecyclerView();
        initializeDataSet();
        initializeCharacterAdapter();
    }

    private void initializeLinearLayoutManager() {
        linearLayoutManager = new LinearLayoutManager(this);
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
            String description = CharactersData.DESCRIPTIONS[i];
            int profile = CharactersData.PROFILES[i];

            CharacterModel character = new CharacterModel(name, description, profile);

            dataSet.add(character);
        }
    }

    private void initializeCharacterAdapter() {
        characterAdapter = new CharacterAdapter(dataSet);
        recyclerView.setAdapter(characterAdapter);
    }
}