package com.example.myrecyclerviewapp;

public class CharacterModel {
    private String name;
    private String description;
    private int profile;

    public CharacterModel(String name, String description, int profile) {
        this.name = name;
        this.description = description;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getProfile() {
        return profile;
    }
}
