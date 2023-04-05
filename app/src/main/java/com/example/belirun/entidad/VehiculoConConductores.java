package com.example.belirun.entidad;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class VehiculoConConductores {
    @Embedded public Vehiculo vehiculo;
    @Relation(
            parentColumn = "vehiculoId",
            entityColumn = "conductorId",
            associateBy = @Junction(VehiculoConductorReferenciaCruzada.class)
    )
    public List<Conductor> conductores;
}
