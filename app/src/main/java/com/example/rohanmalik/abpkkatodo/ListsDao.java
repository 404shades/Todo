package com.example.rohanmalik.abpkkatodo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

/**
 * Created by Rohan Malik on 18-07-2017.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface ListsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItems(Lists lists);
    @Query("SELECT * FROM Lists")
    List<Lists> getLists();
//    @Query("SELECT * FROM Lists "  +
//            "INNER JOIN Category ON Category.id = Lists.category_id "
//    )
//    List<Lists> getItems();
}
