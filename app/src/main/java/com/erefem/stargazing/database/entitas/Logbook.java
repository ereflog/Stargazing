package com.erefem.stargazing.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Logbook {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "Object")
    public String Object;
    public String Observer;
    public String longitude;
    public String latitude;
    public String date;
    public String time;
    public String instrument;
    public String magnification;
    public String filter;
    public String comment;
    public String seeing;

}
