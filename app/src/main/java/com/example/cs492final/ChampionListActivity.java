package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.cs492final.data.AppDatabase;
import com.example.cs492final.data.ChampionWTags;

import java.util.List;

public class ChampionListActivity extends AppCompatActivity implements List<ChampionWTags> {
    private static final String TAG = ChampionListActivity.class.getSimpleName();
    public static final String EXTRA_CHAMPIONS_DATA = "ChampionListActivity.Champions";

    private List<ChampionWTags> championsData;
    private RecyclerView recyclerView;
    private ChampionAdapter championAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_list);

        Intent intent = getIntent();
        LinearLayout linearLayout = findViewById(R.id.item_layout);
        if(intent != null && intent.hasExtra(EXTRA_CHAMPIONS_DATA)) {
            this.championsData = (List<ChampionWTags>) intent.getSerializableExtra(EXTRA_CHAMPIONS_DATA);
            for(ChampionWTags champion : championsData) {
                Log.d(TAG,champion.getName());
            }
        }
        this.recyclerView = findViewById(R.id.champion_recycle);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.championAdapter = new ChampionAdapter(this);
        this.recyclerView.setAdapter(this.championAdapter);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "champions.db").allowMainThreadQueries().build();
        this.championAdapter.updateChampionData(new List<>(db.championDao().getAll()));
        this.championAdapter.notifyDataSetChanged();
    }
}