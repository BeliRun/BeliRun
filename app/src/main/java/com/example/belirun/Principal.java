package com.example.belirun;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.room.Room;

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
}
