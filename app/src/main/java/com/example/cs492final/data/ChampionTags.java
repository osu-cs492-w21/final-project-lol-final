package com.example.cs492final.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class ChampionTags {
    ArrayList<String> tags;

    public ChampionTags() {
        this.tags = null;
    }

    public ChampionTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ChampionTags(JsonArray json) {
        this.tags = new ArrayList<>();
        for(int i = 0; i < json.size(); i++) {
            tags.add(json.get(i).getAsString());
        }
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
