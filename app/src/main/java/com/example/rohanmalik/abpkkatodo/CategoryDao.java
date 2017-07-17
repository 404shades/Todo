package com.example.rohanmalik.abpkkatodo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Rohan Malik on 17-07-2017.
 */
@Dao
public interface CategoryDao {
   @Query("SELECT * FROM Category")
    List<Category_Todo> getAllCategories();
    @Insert
    void insertNote(Category_Todo category_todo);

}
