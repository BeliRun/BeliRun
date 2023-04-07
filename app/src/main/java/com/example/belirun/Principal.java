package com.example.belirun;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Principal extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
