package com.example.belirun.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.belirun.entidad.VehiculoConConductor;

import java.util.List;

@Dao
public interface VehiculoConConductorDao {

    @Transaction
    @Query("SELECT * FROM Vehiculo")
    List<VehiculoConConductor> getVehiculosConConductor();

    @Transaction
    @Query("SELECT * FROM Vehiculo WHERE vehiculoId = :vehiculoId")
    VehiculoConConductor getVehiculoConConductorById(int vehiculoId);

    @Transaction
    @Query("SELECT * FROM Conductor WHERE conductorId = :conductorId")
    VehiculoConConductor getConductorConVehiculosById(int conductorId);

}

