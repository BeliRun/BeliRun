package com.example.belirun.entidad;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class VehiculoConRodamiento {
    @Embedded public Vehiculo vehiculo;
    @Relation(
            parentColumn = "rodamientoId",
            entityColumn = "vehiculoId"
    )
    public List<Rodamiento> rodamientos;
}
