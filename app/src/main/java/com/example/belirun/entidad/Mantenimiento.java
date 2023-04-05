package com.example.belirun.entidad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mantenimiento {
    @PrimaryKey(autoGenerate = true)
    public int mantenimientoId;

    @ColumnInfo(name = "valor")
    public double valor;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "vehiculoId")
    public int vehiculoId;
}
