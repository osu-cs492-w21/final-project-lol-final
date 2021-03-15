package com.example.cs492final.data;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class ChampionWTags {
    private String name;
    private String title;
    private String blurb;
    private ChampionInfo info;
    private ArrayList<String> tags;
    private String partype;
    private ChampionStats stats;

    public ChampionWTags() {
        this.name = null;
        this.title = null;
        this.blurb = null;
        this.info = null;
        this.tags = null;
        this.partype = null;
        this.stats = null;
    }

    public ChampionWTags(Champion champion) {
        this.name = champion.getName();
        this.title = champion.getTitle();
        this.blurb = champion.getBlurb();
        this.info = champion.getInfo();
        this.tags = new ArrayList<>();
        this.tags.add(champion.getTag());
        this.partype = champion.getPartype();
        this.stats = champion.getStats();
    }

    public ChampionWTags(String name, String title, String blurb, ChampionInfo info, ArrayList<String> tags,
                    String partype, ChampionStats stats) {
        this.name = name;
        this.title = title;
        this.blurb = blurb;
        this.info = info;
        this.tags = tags;
        this.partype = partype;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getBlurb() {
        return blurb;
    }

    public ChampionInfo getInfo() {
        return info;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getPartype() {
        return partype;
    }

    public ChampionStats getStats() {
        return stats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public void setInfo(ChampionInfo info) {
        this.info = info;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public void setStats(ChampionStats stats) {
        this.stats = stats;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }
}