package com.erefem.stargazing.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Logbook {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "object")
    public String object;
    public String observer;
    public String latitude;
    public String longitude;
    public String date;
    public String time;
    public String seeing;
    public String instrument;
    public String magnification;
    public String filter;
    public String comment;


}
