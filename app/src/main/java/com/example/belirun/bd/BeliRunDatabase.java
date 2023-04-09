package com.example.belirun.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.belirun.dao.ConductorDao;
import com.example.belirun.dao.MantenimientoDao;
import com.example.belirun.dao.ProducidoDao;
import com.example.belirun.dao.RodamientoDao;
import com.example.belirun.dao.VehiculoConConductorDao;
import com.example.belirun.dao.VehiculoDao;
import com.example.belirun.entidad.Conductor;
import com.example.belirun.entidad.Mantenimiento;
import com.example.belirun.entidad.Producido;
import com.example.belirun.entidad.Rodamiento;
import com.example.belirun.entidad.Vehiculo;
import com.example.belirun.entidad.VehiculoConductorReferenciaCruzada;

@Database(entities = {Conductor.class, Vehiculo.class, Mantenimiento.class, Producido.class, Rodamiento.class, VehiculoConductorReferenciaCruzada.class}, version = 1)
abstract class MyAppDatabase extends RoomDatabase {
    public abstract VehiculoDao vehiculoDao();
    public abstract ConductorDao conductorDao();
    public abstract MantenimientoDao mantenimientoDao();
    public abstract ProducidoDao producidoDao();
    public abstract RodamientoDao rodamientoDao();
    public abstract VehiculoConConductorDao vehiculoConConductorDao();
}
