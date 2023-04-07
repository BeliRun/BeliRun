package com.example.belirun.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.belirun.entidad.Mantenimiento;

import java.util.List;

@Dao
public interface MantenimientoDao {
    @Insert
    void insertAll(Mantenimiento... mantenimiento);

    @Update
    void updateAll(Mantenimiento... mantenimiento);

    @Delete
    void delete(Mantenimiento mantenimiento);

    @Query("SELECT * FROM Mantenimiento")
    List<Mantenimiento> getAllMantenimiento();

    @Query("SELECT * FROM Mantenimiento WHERE vehiculoId=:id")
    List<Mantenimiento> getMantenimientoByVehiculoId(int id);
}
