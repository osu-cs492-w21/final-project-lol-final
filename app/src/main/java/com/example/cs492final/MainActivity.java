package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.cs492final.data.Champion;
import com.example.cs492final.data.ChampionWTags;
import com.example.cs492final.data.Champions;
import com.example.cs492final.data.ChampionsData;
import com.example.cs492final.data.ChampionsViewModel;
import com.example.cs492final.data.Versions;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private VersionsViewModel versionsViewModel;
    private ChampionsViewModel championsViewModel;
    private DbChampionViewModel dbChampionViewModel;

    String version = null;

    private List<ChampionWTags> realChampions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] tagArray = getResources().getStringArray(R.array.tag_array);
        Spinner tagSpinner = findViewById(R.id.tag_spinner);
        ArrayAdapter<String> tagAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, tagArray);
        tagAdapter.setDropDownViewResource(R.layout.spinner_item);
        tagSpinner.setAdapter(tagAdapter);

        String[] difficultyArray = getResources().getStringArray(R.array.difficulty_array);
        Spinner difficultySpinner = findViewById(R.id.difficulty_spinner);
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, difficultyArray);
        difficultyAdapter.setDropDownViewResource(R.layout.spinner_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        String[] partypeArray = getResources().getStringArray(R.array.partype_array);
        Spinner partypeSpinner = findViewById(R.id.partype_spinner);
        ArrayAdapter<String> partypeAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, partypeArray);
        partypeAdapter.setDropDownViewResource(R.layout.spinner_item);
        partypeSpinner.setAdapter(partypeAdapter);

        this.versionsViewModel = new ViewModelProvider(this).get(VersionsViewModel.class);
        this.versionsViewModel.loadVersions();

        this.championsViewModel = new ViewModelProvider(this).get(ChampionsViewModel.class);

        this.dbChampionViewModel = new ViewModelProvider(
                this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())
        ).get(DbChampionViewModel.class);

        this.versionsViewModel.getPatchVersions().observe(
                this,
                new Observer<Versions>() {
                    @Override
                    public void onChanged(Versions versions) {
                        if(versions != null) {
                            version = versions.getLatestVersion();
                            championsViewModel.loadChampions(version);

                            Log.d(TAG, version);
                        }
                    }
                });

        this.championsViewModel.getChampionsData().observe(
                this,
                new Observer<ChampionsData>() {
                    @Override
                    public void onChanged(ChampionsData championsData) {
                        if(championsData != null) {
                            ChampionsData champsData = championsData;
                            Champions champions = champsData.getData();
                            for(Champion champion : champions.getChampions()) {
                                dbChampionViewModel.insertChampion(champion);
                            }
                            champsData.printNames();
                        }
                    }
                }
        );

        this.dbChampionViewModel.getAllChampionsAsc("name").observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        realChampions = champs.toChampWithTags();
                        for(ChampionWTags i : realChampions) {
                            Log.d(TAG, i.getName());
                        }
                    }
                }
        );
    }
}