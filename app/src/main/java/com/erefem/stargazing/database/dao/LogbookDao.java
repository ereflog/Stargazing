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

    @Query("INSERT INTO logbook (object, observer, latitude, longitude, date, time, seeing, instrument, magnification, filter, comment) VALUES(:object, :observer, :latitude, :longitude, :date, :time, :seeing, :instrument, :magnification, :filter, :comment)")
    void insertAll(String object, String observer, String latitude, String longitude,
                   String date, String time, String seeing, String instrument,
                   String magnification, String filter, String comment);

    @Query("UPDATE logbook SET object=:object, observer=:observer, latitude=:latitude, longitude=:longitude, date=:date, time=:time, seeing=:seeing, instrument=:instrument, magnification=:magnification, filter=:filter, comment=:comment  WHERE uid=:uid")
    void update(int uid, String object, String observer, String latitude, String longitude,
                String date, String time, String seeing, String instrument,
                String magnification, String filter, String comment );

    @Query("SELECT * FROM logbook WHERE uid=:uid")
    Logbook get(int uid);

    @Delete
    void delete(Logbook logbook);
}
