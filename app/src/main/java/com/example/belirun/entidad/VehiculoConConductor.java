package com.example.belirun.entidad;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class VehiculoConConductor {
    @Embedded public Vehiculo vehiculo;
    @Relation(
            parentColumn = "vehiculoId",
            entityColumn = "conductorId"
    )
    public List<Conductor> conductores;
}
