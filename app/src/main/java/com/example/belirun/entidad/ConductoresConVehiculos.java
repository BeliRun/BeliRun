package com.example.belirun.entidad;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class ConductoresConVehiculos {
    @Embedded public Conductor conductor;
    @Relation(
            parentColumn = "conductorId",
            entityColumn = "vehiculoId",
            associateBy = @Junction(VehiculoConductorReferenciaCruzada.class)
    )
    public List<Vehiculo> vehiculos;
}
