package com.example.myrecyclerviewapp;

public class CharacterModel {
    private String name;
    private String shortDescription;
    private String longDescription;
    private int profile;

    public CharacterModel(String name, String shortDescription, String longDescription, int profile) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() { return shortDescription; }

    public String getLongDescription() { return longDescription; }

    public int getProfile() {
        return profile;
    }
}
