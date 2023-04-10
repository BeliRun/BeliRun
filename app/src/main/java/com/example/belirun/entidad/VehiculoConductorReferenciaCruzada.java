package com.example.belirun.entidad;

import androidx.room.Entity;

@Entity(primaryKeys = {"vehiculoId", "conductorId"})
public class VehiculoConductorReferenciaCruzada {
    public int vehiculoId;
    public int conductorId;
}
