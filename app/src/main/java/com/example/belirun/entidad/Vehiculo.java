package com.example.belirun.entidad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Vehiculo{
    @PrimaryKey(autoGenerate = true)
    public int vehiculoId;

    @ColumnInfo(name = "numero")
    public String numero;

    @ColumnInfo(name="placa")
    public String placa;

    @ColumnInfo(name="marca")
    public String marca;
}
