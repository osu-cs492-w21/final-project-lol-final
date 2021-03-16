package com.example.cs492final.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChampionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Champion champion);

    @Query("SELECT * FROM champions ORDER BY :sortBy ASC")
    LiveData<List<Champion>> getAllChampionsAsc(String sortBy);

    @Query("SELECT * FROM champions ORDER BY :sortBy DESC")
    LiveData<List<Champion>> getAllChampionsDesc(String sortBy);

    Object getAll();
}
