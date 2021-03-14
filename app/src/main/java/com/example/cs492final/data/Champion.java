package com.example.cs492final.data;

import com.google.gson.JsonObject;

public class Champion {
    private String name;
    private String title;
    private String blurb;
    private ChampionInfo info;
    private ChampionTags tags;
    private String partype;
    private ChampionStats stats;

    public Champion() {
        this.name = null;
        this.title = null;
        this.blurb = null;
        this.info = null;
        this.tags = null;
        this.partype = null;
        this.stats = null;
    }

    public Champion(String name, String title, String blurb, ChampionInfo info, ChampionTags tags,
                    String partype, ChampionStats stats) {
        this.name = name;
        this.title = title;
        this.blurb = blurb;
        this.info = info;
        this.tags = tags;
        this.partype = partype;
        this.stats = stats;
    }

    public Champion(JsonObject json) {
        this.name = json.getAsJsonPrimitive("name").getAsString();
        this.title = json.getAsJsonPrimitive("title").getAsString();
        this.blurb = json.getAsJsonPrimitive("blurb").getAsString();
        this.info = new ChampionInfo(json.getAsJsonObject("info"));
        this.tags = new ChampionTags(json.getAsJsonArray("tags"));
        this.partype = json.getAsJsonPrimitive("partype").getAsString();
        this.stats = new ChampionStats(json.getAsJsonObject("stats"));
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

    public ChampionTags getTags() {
        return tags;
    }

    public String getPartype() {
        return partype;
    }

    public ChampionStats getStats() {
        return stats;
    }
}