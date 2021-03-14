package com.example.cs492final.data;

import androidx.lifecycle.ViewModel;

public class ChampionsViewModel extends ViewModel {
    private ChampionsRepository repository;

    public ChampionsViewModel() {
        this.repository = new ChampionsRepository();
    }

    public void loadChampions(String version) {
        this.repository.loadChampions(version);
    }
}
