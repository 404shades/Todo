package com.example.rohanmalik.abpkkatodo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rohan Malik on 15-07-2017.
 */

@Entity(tableName="Category")
public class Category_Todo {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
   private String Title;
    private int thumbNail;
    private int number_category_todo;

    public Category_Todo(Integer id,String Title, int thumbNail, int number_category_todo) {
        this.id=id;
        this.Title = Title;
        this.thumbNail = thumbNail;
        this.number_category_todo = number_category_todo;
    }

    public Category_Todo(String title, int thumbNail, int number_category_todo) {
        Title = title;
        this.thumbNail = thumbNail;
        this.number_category_todo = number_category_todo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(int thumbNail) {
        this.thumbNail = thumbNail;
    }

    public int getNumber_category_todo() {
        return number_category_todo;
    }

    public void setNumber_category_todo(int number_category_todo) {
        this.number_category_todo = number_category_todo;
    }
}
