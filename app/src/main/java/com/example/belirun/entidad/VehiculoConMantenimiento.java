package com.example.belirun.entidad;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class VehiculoConMantenimiento {
    @Embedded public Vehiculo vehiculo;
    @Relation(
            parentColumn = "mantenimientoId",
            entityColumn = "vehiculoId"
    )
    public List<Mantenimiento> mantenimientos;
    
}
