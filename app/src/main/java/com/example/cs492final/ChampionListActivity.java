package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cs492final.data.Champion;
import com.example.cs492final.data.ChampionWTags;
import com.example.cs492final.data.Champions;

import java.util.List;

public class ChampionListActivity extends AppCompatActivity {
    private static final String TAG = ChampionListActivity.class.getSimpleName();
    public static final String EXTRA_TAG_TEXT = "ChampionListActivity.Tag";
    public static final String EXTRA_DIFFICULTY_TEXT = "ChampionListActivity.Difficulty";
    public static final String EXTRA_PARTYPE_TEXT = "ChampionListActivity.Partype";


    private String tag;
    private String difficulty;
    private String partype;
    private String orderBy = "attackdamage"; // Add Sort by option to preference and make this string reflect that value instead of hard coding
    private List<ChampionWTags> championsData;

    private DbChampionViewModel dbChampionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_list);

        Intent intent = getIntent();

        if(intent != null && intent.hasExtra(EXTRA_TAG_TEXT) && intent.hasExtra(EXTRA_DIFFICULTY_TEXT)
            && intent.hasExtra(EXTRA_PARTYPE_TEXT)) {
            this.dbChampionViewModel = new ViewModelProvider(
                    this,
                    new ViewModelProvider.AndroidViewModelFactory(getApplication())
            ).get(DbChampionViewModel.class);
            this.tag = intent.getStringExtra(EXTRA_TAG_TEXT);
            this.difficulty = intent.getStringExtra(EXTRA_DIFFICULTY_TEXT);
            this.partype = intent.getStringExtra(EXTRA_PARTYPE_TEXT);
            getChampionsData();
        }
    }

    private void getChampionsData() {
        if(!this.tag.equals("All") && this.difficulty.equals("All") && this.partype.equals("All")) {
            getChampionsByTag(this.tag, orderBy);
        } else if(this.tag.equals("All") && !this.difficulty.equals("All") && this.partype.equals("All")) {
            getChampionsByDifficulty(Integer.parseInt(this.difficulty), orderBy);
        } else if(this.tag.equals("All") && this.difficulty.equals("All") && !this.partype.equals("All")) {
            getChampionsByPartype(this.partype, orderBy);
        } else if(!this.tag.equals("All") && !this.difficulty.equals("All") && this.partype.equals("All")) {
            getChampionsByTagDifficulty(this.tag, Integer.parseInt(this.difficulty), orderBy);
        } else if(!this.tag.equals("All") && this.difficulty.equals("All") && !this.partype.equals("All")) {
            getChampionsByTagPartype(this.tag, this.partype, orderBy);
        } else if(this.tag.equals("All") && !this.difficulty.equals("All") && !this.partype.equals("All")) {
            getChampionsByDifficultyPartype(Integer.parseInt(this.difficulty), this.partype, orderBy);
        } else if(!this.tag.equals("All") && !this.difficulty.equals("All") && !this.partype.equals("All")) {
            getChampionsByAllQuery(this.tag, Integer.parseInt(this.difficulty), this.partype, orderBy);
        } else if(this.tag.equals("All") && this.difficulty.equals("All") && this.partype.equals("All")) {
            getAllChampionsOrderBy(orderBy);
        }
    }

    private void printChampsWithTags() {
        for(ChampionWTags champion : championsData) {
            Log.d(TAG, champion.getName() + " " + champion.getTags());
        }
    }

    private void getAllChampionsOrderBy(String column) {
        this.dbChampionViewModel.getAllChampionsOrderBy(column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByTag(String tag, String column) {
        this.dbChampionViewModel.getChampionsByTag(tag, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByDifficulty(int difficulty, String column) {
        this.dbChampionViewModel.getChampionsByDifficulty(difficulty, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByPartype(String partype, String column) {
        this.dbChampionViewModel.getChampionsByPartype(partype, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByTagDifficulty(String tag, int difficulty, String column) {
        this.dbChampionViewModel.getChampionsByTagDifficulty(tag, difficulty, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByTagPartype(String tag, String partype, String column) {
        this.dbChampionViewModel.getChampionsByTagPartype(tag, partype, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByDifficultyPartype(int difficulty, String partype, String column) {
        this.dbChampionViewModel.getChampionsByDifficultyPartype(difficulty, partype, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }

    private void getChampionsByAllQuery(String tag, int difficulty, String partype, String column) {
        this.dbChampionViewModel.getChampionsByAllQuery(tag, difficulty, partype, column).observe(
                this,
                new Observer<List<Champion>>() {
                    @Override
                    public void onChanged(List<Champion> champions) {
                        Champions champs = new Champions(champions);
                        championsData = champs.toChampWithTags();
                        printChampsWithTags();
                    }
                }
        );
    }
}