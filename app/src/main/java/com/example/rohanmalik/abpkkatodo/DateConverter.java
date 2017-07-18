package com.example.rohanmalik.abpkkatodo;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import java.util.Date;

/**
 * Created by Rohan Malik on 18-07-2017.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timeStamp)
    {
    return timeStamp ==null ? null : new Date(timeStamp);
    }
    @TypeConverter
    public static Long toTimeStamp(Date date){
        return date == null ? null : date.getTime();
    }
}
