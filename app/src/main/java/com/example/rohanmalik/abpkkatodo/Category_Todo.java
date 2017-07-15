package com.example.rohanmalik.abpkkatodo;

/**
 * Created by Rohan Malik on 15-07-2017.
 */

public class Category_Todo {
   private String Title;
    private int thumbNail;
    private int number_category_todo;

    public Category_Todo(String title, int thumbNail, int number_category_todo) {
        Title = title;
        this.thumbNail = thumbNail;
        this.number_category_todo = number_category_todo;
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
