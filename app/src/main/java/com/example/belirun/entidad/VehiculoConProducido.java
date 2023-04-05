package com.example.belirun.entidad;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class VehiculoConProducido {
    @Embedded Vehiculo vehiculo;
    @Relation(
            parentColumn = "producidoId",
            entityColumn = "vehiculoId"
    )
    public List<Producido> producidos;
}
