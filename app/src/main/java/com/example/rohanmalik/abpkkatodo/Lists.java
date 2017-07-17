package com.example.rohanmalik.abpkkatodo;

import java.util.Date;

/**
 * Created by Rohan Malik on 16-07-2017.
 */

public class Lists {
    String Title;
//    Date date;
    String Description;

    public Lists(String title,String description) {
        Title = title;
//        this.date = date;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
