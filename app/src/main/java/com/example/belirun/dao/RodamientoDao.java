package com.example.belirun.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.belirun.entidad.Rodamiento;

import java.util.List;

@Dao
public interface RodamientoDao {
    @Insert
    void insertAll(Rodamiento... rodamiento);

    @Update
    void uptadeAll(Rodamiento... rodamiento);

    @Delete
    void delete(Rodamiento rodamiento);

    @Query("SELECT * FROM Rodamiento")
    List<Rodamiento> getAllRodamientos();

    @Query("SELECT * FROM Rodamiento WHERE vehiculoId=:id")
    List<Rodamiento> getAllRodamientosByVehiculoId(int id);
}
