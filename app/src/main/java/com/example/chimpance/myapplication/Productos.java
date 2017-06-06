package com.example.chimpance.myapplication;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by ChimpancE on 06-06-2017.
 */
@Table(name = "Productos")
public class Productos extends Model{
    @Column(name = "Codigo")
    public String Codigo;

    @Column (name = "Nombre")
    public String Nombre;

    @Column (name = "Descripcion")
    public String Descripcion;

    @Column (name = "Cantidad")
    public Integer Cantidad;


    public Productos(){
        super();
    }

    public Productos(String Codigo, String Nombre){
        super();
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }
}
