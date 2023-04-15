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

    @Query("SELECT conductorId FROM Conductor WHERE telefono=:telefono")
    int searchId(String telefono);

    @Query("SELECT * FROM Conductor WHERE telefono=:telefono AND isDelete=0")
    Conductor search(String telefono);

    @Query("SELECT * FROM  Conductor WHERE isDelete=0 ")
    List<Conductor> getAllConductor();
}
