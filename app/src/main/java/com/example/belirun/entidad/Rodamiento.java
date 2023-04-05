package com.example.belirun.entidad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rodamiento {
    @PrimaryKey(autoGenerate = true)
    public int rodamientoId;

    @ColumnInfo(name="empresa")
    public String empresa;

    @ColumnInfo(name="valor")
    public double valor;

    @ColumnInfo(name="vehiculoId")
    public int vehiculoId;
}
