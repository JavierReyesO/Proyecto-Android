package com.example.chimpance.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ChimpancE on 06-06-2017.
 */

public class BuscarActivity extends Activity{

    @BindView(R.id.searched)
    TextView ProductoBuscado;

    @BindView(R.id.nombreBuscado)
    TextView NombreBuscado;

    @BindView(R.id.codigoBuscado)
    TextView CodigoBuscado;

    @BindView(R.id.descripcionBuscada)
    TextView DescripcionBuscada;

    @BindView(R.id.cantidadBuscada)
    TextView CantidadBuscada;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.searched_button)
    public void buttonSearched(){
        Productos producto = new Select().from(Productos.class).where("Nombre = ?", String.valueOf(ProductoBuscado.getText())).executeSingle();





        if (producto != null) {
            NombreBuscado.setText(producto.Nombre);
            CodigoBuscado.setText(producto.Codigo);
            DescripcionBuscada.setText(producto.Descripcion);
            CantidadBuscada.setText(String.valueOf(producto.Cantidad));
        }

        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Producto no Encontrado!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
