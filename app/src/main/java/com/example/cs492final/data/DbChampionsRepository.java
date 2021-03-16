package com.example.cs492final.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DbChampionsRepository {
    private ChampionDao dao;

    public DbChampionsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        this.dao = db.championDao();
    }

    public void insertChampion(Champion champion) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(champion);
            }
        });
    }

    public LiveData<List<Champion>> getAllChampionsAsc(String sortBy) {
        return this.dao.getAllChampionsAsc(sortBy);
    }

    public LiveData<List<Champion>> getAllChampionsDesc(String sortBy) {
        return this.dao.getAllChampionsDesc(sortBy);
    }
}
