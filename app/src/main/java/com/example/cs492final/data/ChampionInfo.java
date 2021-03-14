package com.example.cs492final.data;

import com.google.gson.JsonObject;

public class ChampionInfo {
    private int attack;
    private int defense;
    private int magic;
    private int difficulty;

    public ChampionInfo() {
        this.attack = 0;
        this.defense = 0;
        this.magic = 0;
        this.difficulty = 0;
    }

    public ChampionInfo(int attack, int defense, int magic, int difficulty) {
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.difficulty = difficulty;
    }

    public ChampionInfo(JsonObject json) {
        this.attack = json.getAsJsonPrimitive("attack").getAsInt();
        this.defense = json.getAsJsonPrimitive("defense").getAsInt();
        this.magic = json.getAsJsonPrimitive("magic").getAsInt();
        this.difficulty = json.getAsJsonPrimitive("difficulty").getAsInt();
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagic() {
        return magic;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
