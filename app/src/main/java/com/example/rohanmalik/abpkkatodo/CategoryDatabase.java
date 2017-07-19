package com.example.rohanmalik.abpkkatodo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Rohan Malik on 17-07-2017.
 */
@Database(entities ={Category_Todo.class,Lists.class},version = 4)
public abstract class CategoryDatabase extends RoomDatabase {
    private static CategoryDatabase INSTANCE;
    private static Object LOCK = new Object();
    public static CategoryDatabase getInstance(Context context){
        if(INSTANCE==null){
            synchronized (LOCK){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),CategoryDatabase.class,CategoryDatabase.DB_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
    public static final String DB_NAME="category_db";
    public abstract CategoryDao categoryDao();

    public abstract ListsDao listDao();
}

