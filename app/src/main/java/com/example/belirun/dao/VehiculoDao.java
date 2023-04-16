package com.example.belirun.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.belirun.entidad.Vehiculo;

import java.util.List;

@Dao
public interface VehiculoDao {
    @Insert
    void insertAll(Vehiculo... vehiculo);

    @Update
    void updateAll(Vehiculo... vehiculo);

    @Query("UPDATE Vehiculo SET isDelete=1 WHERE vehiculoId=:id")
    void delete(int id);

    @Query("SELECT vehiculoId FROM Vehiculo WHERE placa=:placa")
    int searchId(String placa);

    @Query("SELECT * FROM Vehiculo WHERE placa=:placa AND isDelete=0")
    Vehiculo search(String placa);

    @Query("SELECT * FROM Vehiculo WHERE vehiculoId=:vehiculo AND isDelete=0")
    Vehiculo searchVehiculo(int vehiculo);

    @Query("SELECT * FROM Vehiculo WHERE isDelete=0")
    List<Vehiculo> getAllVehiculos();
}
