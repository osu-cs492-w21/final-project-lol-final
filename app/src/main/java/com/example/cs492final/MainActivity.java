package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.cs492final.data.ChampionsViewModel;
import com.example.cs492final.data.Versions;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private VersionsViewModel versionsViewModel;
    private ChampionsViewModel championsViewModel;
//    private static final String LEAGUE_API_KEY = BuildConfig.LEAGUE_API_KEY;

    String version = null;

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
    }
}