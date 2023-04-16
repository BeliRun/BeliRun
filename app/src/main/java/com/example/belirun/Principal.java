package com.example.belirun;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.room.Room;

import com.example.belirun.bd.BeliRunDatabase;
import com.example.belirun.dao.ConductorDao;
import com.example.belirun.dao.MantenimientoDao;
import com.example.belirun.dao.ProducidoDao;
import com.example.belirun.dao.RodamientoDao;
import com.example.belirun.dao.VehiculoConConductorDao;
import com.example.belirun.dao.VehiculoDao;
import com.example.belirun.entidad.Conductor;
import com.example.belirun.entidad.Vehiculo;
import com.google.gson.Gson;

import java.util.List;
/* importacion de carpertas */


public class Principal extends Activity {
    private BeliRunDatabase db;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = Room.databaseBuilder(this, BeliRunDatabase.class, "belirun-db").build();
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        JavaScriptInterface JsInterface = new JavaScriptInterface(this);
        webView.addJavascriptInterface(JsInterface, "Android");
        webView.loadUrl("file:///android_asset/index.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //String data = "Hola mundo!";
                //String js = "setData('" + data + "')"; // llama a la función "setData" con el dato a enviar
                //webView.evaluateJavascript(js, null); // ejecuta el código JavaScript y no espera ningún resultado
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
        public VehiculoConConductorDao vehiculoConConductorDao;
        public JavaScriptInterface(Context context){ /* Constructor */
            this.context = context;
            this.vehiculoDao = db.vehiculoDao();
            this.conductorDao = db.conductorDao();
            this.mantenimientoDao = db.mantenimientoDao();
            this.producidoDao = db.producidoDao();
            this.rodamientoDao = db.rodamientoDao();
            this.vehiculoConConductorDao = db.vehiculoConConductorDao();
        }

        /* Acciones de Vehiculo */
        @JavascriptInterface
        public void showToast(String message) {
            Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
            Log.d("MIRAMEEEEE!!!!!", "ENTRO AL TOAST");
        }
        @JavascriptInterface
        public void AgregarVehiculo(String placa, String marca, String numero){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            Vehiculo buseta = new Vehiculo();
                            buseta.placa = placa;
                            buseta.marca = marca;
                            buseta.numero = numero;
                            buseta.isDelete = false;
                            vehiculoDao.insertAll(buseta);
                        }
                    }
            ).start();
        }

        @JavascriptInterface
        public void EditarVehiculo(String placa, String marca, String numero){
            Vehiculo vehiculoExistente = vehiculoDao.search(placa);
            if (vehiculoExistente != null) {
                vehiculoExistente.marca = marca;
                vehiculoExistente.numero = numero;
                vehiculoDao.updateAll(vehiculoExistente);
            } else {
                // El vehículo no fue encontrado en la base de datos
            }
        }

        @JavascriptInterface
        public void MostrarVehiculo() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Vehiculo> vehiculos = vehiculoDao.getAllVehiculos();
                    String vehiculosJson = new Gson().toJson(vehiculos);
                    Log.d("DATOS PARA VER: ", vehiculosJson);
                    webView.post(new Runnable() {
                        @Override
                        public void run() {
                            webView.evaluateJavascript("mostrarVehiculo(" + vehiculosJson + ")", null);
                        }
                    });
                }

            }).start();
        }

        @JavascriptInterface
        public void ObtenerDatos(String placa){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Vehiculo vehiculo = vehiculoDao.search(placa);
                    if(vehiculo!=null){
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                String vehiculoJson = new Gson().toJson(vehiculo);
                                webView.evaluateJavascript("mostrarDatos("+vehiculoJson+")", null);
                            }
                        });
                    }
                }
            }).start();
        }
        
        @JavascriptInterface
        public void ObtenerVehiculo(boolean esEditar){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Vehiculo> vehiculos = vehiculoDao.getAllVehiculos();
                    String vehiculosJson = new Gson().toJson(vehiculos);
                    Log.d("VEHICULOS REGISTRADOS: ", vehiculosJson);
                    webView.post(new Runnable() {
                        @Override
                        public void run() {
                            webView.evaluateJavascript("mostrarBusetica(" + vehiculosJson + ", " + esEditar + ")", null);
                        }
                    });
                }

            }).start();
        }

        @JavascriptInterface
        public void EliminarVehiculo(String placa){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int id = vehiculoDao.searchId(placa);
                    if (id>0){
                        vehiculoDao.delete(id);
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                webView.evaluateJavascript("Android.MostrarVehiculo()", null);
                            }
                        });
                    }
                }
            }).start();
        }


        @JavascriptInterface
        public void BuscarVehiculo(String placa){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Vehiculo vehiculo = vehiculoDao.search(placa);
                    if(vehiculo!=null){
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                String vehiculoJson = new Gson().toJson(vehiculo);
                                webView.evaluateJavascript("mostrarVehiculo(["+vehiculoJson+",])", null);
                            }
                        });
                    }else{
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                webView.evaluateJavascript("mostrarVehiculo(null)", null);
                            }
                        });
                    }
                }
            }).start();
        }
        /* Acciones del conductor */

        @JavascriptInterface
        public void AgregarConductor(String nombres, String apellidos, String telefono, int vehiculo){
             new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            Conductor persona = new Conductor();
                            persona.nombres = nombres;
                            persona.apellidos = apellidos;
                            persona.telefono = telefono;
                            persona.vehiculoId = vehiculo;
                            persona.isDelete = false;
                            conductorDao.insertAll(persona);
                        }
                    }
            ).start();
        }

        @JavascriptInterface
        public void EditarConductor(String nombres, String apellidos, String telefono, int vehiculo){
            Conductor conductorExistente = conductorDao.search(telefono);
            Log.d("DATOS PARA EDITAR: ", new Gson().toJson(conductorExistente));
            if (conductorExistente != null) {
                conductorExistente.telefono = telefono;
                conductorExistente.vehiculoId = vehiculo;
                conductorDao.updateAll(conductorExistente);
            } else {
                // El vehículo no fue encontrado en la base de datos
            }
        }

        @JavascriptInterface
        public void MostrarConductor(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String datos = new Gson().toJson(vehiculoConConductorDao.getVehiculosConConductor());
                    Log.d("DATOS PARA VER: ", datos);
                    webView.post(new Runnable() {
                        @Override
                        public void run() {
                            webView.evaluateJavascript("mostrarConductor("+datos+")", null);
                        }
                    });
                }

                }).start();
        }

        @JavascriptInterface
        public void ObtenerDatosConductor(String telefono){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("Telefono que llega: ", telefono);
                    String datos = new Gson().toJson(vehiculoConConductorDao.getVehiculoConConductorById(telefono));
                    Log.d("Datos Del Conductor", datos);
                    if(datos!=null){
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                webView.evaluateJavascript("mostrarDatos("+datos+")", null);
                            }
                        });
                    }
                }
            }).start();
        }


        @JavascriptInterface
        public void EliminarConductor(String telefono){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int id = conductorDao.searchId(telefono);
                    if (id>0){
                        conductorDao.delete(id);
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                webView.evaluateJavascript("Android.MostrarConductor()", null);
                            }
                        });
                    }
                }
            }).start();
        }

        @JavascriptInterface
        public void BuscarConductor(String telefono){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Conductor conductor = conductorDao.search(telefono);
                    if(conductor!=null){
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                String conductorJson = new Gson().toJson(conductor);
                                webView.evaluateJavascript("mostrarConductor(["+conductorJson+",])", null);
                            }
                        });
                    }else{
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                webView.evaluateJavascript("mostrarConductor(null)", null);
                            }
                        });
                    }
                }
            }).start();
        }
    }
}