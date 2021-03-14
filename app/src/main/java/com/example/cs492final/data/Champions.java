package com.example.cs492final.data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Champions implements Serializable {
    private static final String TAG = Champions.class.getSimpleName();
    private ArrayList<Champion> champions;

    public Champions() {
        this.champions = null;
    }

    public Champions(ArrayList<Champion> champions) {
        this.champions = champions;
    }


    public ArrayList<Champion> getChampions() {
        return champions;
    }

    public static class JsonDeserializer implements com.google.gson.JsonDeserializer<Champions> {
        @Override
        public Champions deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject dataObj = json.getAsJsonObject();
            Set<String> keySet = dataObj.keySet();
            List<String> listKeySet = new ArrayList<>(keySet);
            ArrayList<Champion> champions = new ArrayList<>();

            Log.d(TAG, "dataObj: " + dataObj);
            Log.d(TAG, "size: " + dataObj.size());
            for(String key : listKeySet) {
                JsonObject champObj = dataObj.getAsJsonObject(key);
                champions.add(new Champion(champObj));
                Log.d(TAG, "Champobj: " + champObj);
            }
            return new Champions(champions);
        }
    }
}