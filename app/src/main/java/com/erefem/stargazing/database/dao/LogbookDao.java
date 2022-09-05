package com.erefem.stargazing.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.erefem.stargazing.database.entitas.Logbook;

import java.util.List;

@Dao
public interface  LogbookDao {
    @Query("SELECT * FROM logbook ")
    List<Logbook> getAll();

    @Query("INSERT INTO logbook (Object,Observer, date,time, instrument,filter,magnification,comment) VALUES(:Object, :Observer, :date, :time, :instrument, :filter, :magnification, :comment)")
    void insertAll(String Object, String Observer,
                    String date, String time,
                   String instrument, String filter, String magnification, String comment);

    @Query("UPDATE logbook SET Object=:Object, Observer=:Observer, date=:date, time=:time, instrument=:instrument, filter=:filter, magnification=:magnification, comment=:comment  WHERE uid=:uid")
    void update(int uid, String Object, String Observer,

                String date, String time,
                String instrument, String filter, String magnification, String comment );

    @Query("SELECT * FROM logbook WHERE uid=:uid")
    Logbook get(int uid);

    @Delete
    void delete(Logbook logbook);

}
