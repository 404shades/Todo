package com.example.rohanmalik.abpkkatodo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Rohan Malik on 18-07-2017.
 */
@Dao
public interface ListsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItems(Lists lists);
    @Query("SELECT * FROM Lists INNER JOIN Category ON Lists.category_id=Category.id WHERE Category.TITLE = :query")
    List<Lists> getLists(String query);
}
