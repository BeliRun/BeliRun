package com.example.belirun.entidad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Conductor {
    @PrimaryKey(autoGenerate = true)
    public int conductorId;

    @ColumnInfo(name="nombres")
    public String nombres;

    @ColumnInfo(name="apellidos")
    public String apellidos;

    @ColumnInfo(name="telefono")
    public String telefono;

    @ColumnInfo(name="isDelete")
    public boolean isDelete;

    @ColumnInfo(name="vehiculoId")
    public int vehiculoId;
}
