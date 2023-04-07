package com.example.belirun.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.belirun.entidad.Producido;

import java.util.List;

@Dao
public interface ProducidoDao {
    @Insert
    void insertAll(Producido... producido);

    @Update
    void updateAll(Producido... producido);

    @Delete
    void delete(Producido producido);

    @Query("SELECT * FROM Producido")
    List<Producido> getAllProducido();

    @Query("SELECT * FROM producido WHERE vehiculoId=:id")
    List<Producido> getAllProducidoByVehiculoId(int id);
}
