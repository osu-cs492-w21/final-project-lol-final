package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cs492final.data.ChampionWTags;

import java.util.List;

public class ChampDetailActivity extends AppCompatActivity {
    public static final String EXTRA_GITHUB_REPO = "Champions";
    private List<ChampionWTags> championsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champ_detail_activity);

        Intent intent = getIntent();
        if(intent != null&&intent.hasExtra(EXTRA_GITHUB_REPO)){
            this.championsData = (List<ChampionWTags>) intent.getSerializableExtra(EXTRA_GITHUB_REPO);
            for(ChampionWTags champion : championsData) {
                Log.d("TAGs",champion.getName());
            }

        }


    }
}