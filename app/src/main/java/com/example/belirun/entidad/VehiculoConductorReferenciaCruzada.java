package com.example.belirun.entidad;

import androidx.room.Entity;

@Entity(primaryKeys = {"VehiculoId", "ConductorId"})
public class VehiculoConductorReferenciaCruzada {
    public int vehiculoId;
    public int conductorId;
}
