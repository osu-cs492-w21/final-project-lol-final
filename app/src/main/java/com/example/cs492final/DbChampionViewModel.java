package com.example.cs492final;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.cs492final.data.Champion;
import com.example.cs492final.data.DbChampionsRepository;

import java.util.List;

public class DbChampionViewModel extends AndroidViewModel {
    private DbChampionsRepository repository;

    public DbChampionViewModel(@NonNull Application application) {
        super(application);
        this.repository = new DbChampionsRepository(application);
    }

    public void insertChampion(Champion champion) {
        this.repository.insertChampion(champion);
    }

    public LiveData<List<Champion>> getAllChampionsAsc(String sortBy) {
        return this.repository.getAllChampionsAsc(sortBy);
    }

    public LiveData<List<Champion>> getAllChampionsDesc(String sortBy) {
        return this.repository.getAllChampionsDesc(sortBy);
    }
}
