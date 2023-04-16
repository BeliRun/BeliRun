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
    @Query("SELECT *  FROM Vehiculo  v INNER JOIN Conductor  c ON v.vehiculoId=c.vehiculoId  ")
    List<VehiculoConConductor> getVehiculosConConductor();

    @Transaction
    @Query("SELECT c.nombres, c.apellidos, c.telefono, v.vehiculoId, v.numero  FROM Conductor  c INNER JOIN Vehiculo v ON c.vehiculoId=v.vehiculoId WHERE c.telefono=:telefonoConductor")
    VehiculoConConductor getVehiculoConConductorById(String telefonoConductor);

    @Transaction
    @Query("SELECT * FROM Conductor WHERE conductorId =:conductorId")
    VehiculoConConductor getConductorConVehiculosById(int conductorId);

}

