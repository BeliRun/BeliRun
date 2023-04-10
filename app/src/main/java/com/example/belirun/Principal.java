package com.example.belirun;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.room.Room;
/* importacion de carpertas */
import com.exmaple.belirun.entidad;
import com.exmaple.belirun.dao;
import com.example.belirun.bd.BeliRunDatabase;


public class Principal extends Activity {
    private BeliRunDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = Room.databaseBuilder(getApplicationContext(),
                        BeliRunDatabase.class, "belirun-db")
                .build();
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/main.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                String data = "Hola mundo!";
                String js = "setData('" + data + "')"; // llama a la función "setData" con el dato a enviar
                webView.evaluateJavascript(js, null); // ejecuta el código JavaScript y no espera ningún resultado
            }
        });

    }

    public class JavaScriptInterface {

        private Context context;
        public VehiculoDao vehiculoDao;
        public ConductorDao conductorDao;
        public MantenimientoDao mantenimientoDao;
        public ProducidoDao producidoDao;
        public RodamientoDao rodamientoDao;
        
        public JavaScriptInterface(Context context){ /* Constructor */
            this.context = context;
            this.vehiculoDao = db.vehiculoDao();
            this.conductorDao = db.conductorDao();
            this.mantenimientoDao = db.mantenimientoDao();
            this.producidoDao = producidoDao();
            this rodamientoDao = rodamientoDao();
        }

        /* Acciones de Vehiculo */

        @JavaScriptInterface
        public void AgregarVehiculo(String placa, String marca, int numero){
            Vehiculo buseta = new Vehiculo();
            buseta.placa = placa;
            buseta.marca = marca;
            buseta.numero = numero;
            buseta.isDelete = false;
            vehiculoDao.insertAll(buseta);
        }
        
        @JavaScriptInterface
        public void EditarVehiculo(String placa, String marca, int numero){
            Vehiculo vehiculoExistente = VehiculoDao.search(placa);
            if (vehiculoExistente != null) {
                vehiculoExistente.marca = marca;
                vehiculoExistente.numero = numero;
                VehiculoDao.updateAll(vehiculoExistente);
            } else {
                // El vehículo no fue encontrado en la base de datos
            }
        }
    
        @JavaScriptInterface
        public void BuscarVehiculoId(String placa){
            vehiculoDao.searchId(placa);
        }
        
        @JavaScriptInterface
        public List<Vehiculo> MostrarVehiculo(){
            return vehiculoDao.getAll();
        }
        
        @JavaScriptInterface
        public void EliminarVehiculo(String placa){
            int id = vehiculoDao.BuscarVehiculoId(placa);
            vehiculoDao.delete(id);
        }
    
        @JavaScriptInterface
        public Vehiculo BuscarVehiculo(String placa){
            return vehiculoDao.search(placa);
        }
        
        /* Acciones del conductor */

        @JavaScriptInterface
        public void AgregarConductor(String nombres, String apellidos, String telefono){
            Conductor persona = new Conductor();
            persona.nombres = nombres;
            persona.apellidos = apellidos;
            persona.telefono = telefono;
            persona.isDelete = false;
            conductorDao.insertAll(persona);
        }
        
        @JavaScriptInterface
        public void EditarConductor(String nombres, String apellidos, String telefono){
            Vehiculo conductorExistente = conductorDao.search(telefono);
            if (conductorExistente != null) {
                conductorExistente.nombres = nombres;
                conductorExistente.apellidos = apellidos;
                conductorDao.updateAll(conductorExistente);
            } else {
                // El vehículo no fue encontrado en la base de datos
            }
        }
    
        @JavaScriptInterface
        public void BuscarConductorId(String telefono){
            conductorDao.searchId(telefono);
        }
        
        @JavaScriptInterface
        public List<Conductor> MostrarConductor(){
            return conductorDao.getAll();
        }
        
        @JavaScriptInterface
        public void EliminarConductor(String telefono){
            int id = conductorDao.BuscarConductorId(telefono);
            conductorDao.delete(id);
        }
    
        @JavaScriptInterface
        public Vehiculo BuscarConductor(String telefono){
            return conductorDao.search(telefono);
        }
    }
    
}
