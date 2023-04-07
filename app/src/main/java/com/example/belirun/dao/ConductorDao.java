package com.example.belirun.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.belirun.entidad.Conductor;

import java.util.List;

@Dao
public interface ConductorDao {
    @Insert
    void insertAll(Conductor... conductor);

    @Update
    void updateAll(Conductor... conductor);

    @Query("UPDATE Conductor SET isDelete=1 WHERE conductorId=:id")
    void delete(int id);

    @Query("SELECT * FROM  Conductor    ")
    List<Conductor> getAll();
}
