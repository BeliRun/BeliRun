package com.example.belirun.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.belirun.entidad.VehiculoConductorReferenciaCruzada;

@Dao
public interface VehiculoConductorReferenciaCruzadaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(VehiculoConductorReferenciaCruzada vehiculoConductorReferenciaCruzada);

    @Query("SELECT * FROM VehiculoConductorReferenciaCruzada WHERE vehiculoId = :vehiculoId AND conductorId = :conductorId")
    VehiculoConductorReferenciaCruzada get(int vehiculoId, int conductorId);

    @Update
    void update(VehiculoConductorReferenciaCruzada vehiculoConductorReferenciaCruzada);

    @Delete
    void delete(VehiculoConductorReferenciaCruzada vehiculoConductorReferenciaCruzada);
}
