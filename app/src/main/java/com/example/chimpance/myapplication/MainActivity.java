package com.example.chimpance.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.activeandroid.ActiveAndroid;
import com.google.zxing.Result;

import butterknife.OnClick;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView escanerView  = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActiveAndroid.initialize(this); //Inicia la BD

        /**Button btn = (Button) findViewById(R.id.search_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), BuscarActivity.class);
                startActivity(intent);
            }
        });**/
    }

    public void ESCANEAR(View view){
        escanerView = new ZXingScannerView(this);
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();
    }

    public void BUSCAR(View view){
        Intent intent =  new Intent(getApplicationContext(), BuscarActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(escanerView != null){
            escanerView.stopCamera();
            setContentView(R.layout.activity_main);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(escanerView != null){
            escanerView.stopCamera();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(escanerView != null){
            escanerView.stopCamera();
        }
    }

    @Override
    public void handleResult(Result result) {

        String Codigo = result.getText();

        escanerView.stopCamera();

        Intent ModificarProducto = new Intent(getApplicationContext(), ModificarActivity.class);
        ModificarProducto.putExtra("Codigo", Codigo);
        startActivity(ModificarProducto);

    }
}
