package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cs492final.data.ChampionWTags;

import java.util.List;

public class ChampionListActivity extends AppCompatActivity {
    private static final String TAG = ChampionListActivity.class.getSimpleName();
    public static final String EXTRA_CHAMPIONS_DATA = "ChampionListActivity.Champions";

    private List<ChampionWTags> championsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_list);

        Intent intent = getIntent();

        if(intent != null && intent.hasExtra(EXTRA_CHAMPIONS_DATA)) {
            this.championsData = (List<ChampionWTags>) intent.getSerializableExtra(EXTRA_CHAMPIONS_DATA);
            for(ChampionWTags champion : championsData) {
                Log.d(TAG,champion.getName());
            }
        }
    }
}