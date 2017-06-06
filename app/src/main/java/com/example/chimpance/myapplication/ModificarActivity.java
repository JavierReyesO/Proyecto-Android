package com.example.chimpance.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ChimpancE on 06-06-2017.
 */

public class ModificarActivity extends Activity {

    @BindView(R.id.code)
    TextView CodigoProducto;

    @BindView(R.id.name)
    EditText NombreProducto;

    @BindView(R.id.description)
    EditText DescripcionProducto;

    @BindView(R.id.amount)
    EditText CantidadProducto;

    private String Codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        Codigo = intent.getExtras().getString("Codigo");
        CodigoProducto.setText(String.format(Locale.getDefault(), " Codigo Producto: %s", Codigo));
    }

    @OnClick(R.id.change_button)
    public void buttonChange(){
        Productos producto = new Productos();
        producto.Codigo = Codigo;
        producto.Nombre = String.valueOf(NombreProducto.getText());
        producto.Descripcion = String.valueOf(DescripcionProducto.getText());
        producto.Cantidad = Integer.valueOf(String.valueOf(CantidadProducto.getText()));
        producto.save();

        Toast toast = Toast.makeText(getApplicationContext(), "Guardado con Exito!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
