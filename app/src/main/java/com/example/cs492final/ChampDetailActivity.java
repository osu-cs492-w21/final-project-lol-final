package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.cs492final.data.ChampionWTags;

import org.w3c.dom.Text;

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
//            for(ChampionWTags champion : championsData) {
//                Log.d("TAGs",champion.getName());
//            }
            TextView nameTV = findViewById(R.id.detail_name);
            TextView titleTV = findViewById(R.id.detail_title);
            TextView tagsTV = findViewById(R.id.detail_tags);
            TextView descriptionTV = findViewById(R.id.detail_description);

            String names = championsData.get(0).getName();
            nameTV.setText(names);
//            titleTV.setText(championsData.);


        }


    }
}