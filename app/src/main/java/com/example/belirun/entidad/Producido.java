package com.example.belirun.entidad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.belirun.convertidores.ConvertidorFecha;

import java.util.Date;

@Entity
public class Producido {
    @PrimaryKey(autoGenerate = true)
    public int producidoId;

    @ColumnInfo(name = "fecha")
    @TypeConverters({ConvertidorFecha.class})
    public Date fecha;

    @ColumnInfo(name = "valor")
    public double valor;

    @ColumnInfo(name = "ruta")
    public String ruta;

    @ColumnInfo(name = "vehiculoId")
    public int vehiculoId;
}
