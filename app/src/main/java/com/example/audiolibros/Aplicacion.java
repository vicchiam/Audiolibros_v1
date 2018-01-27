package com.example.audiolibros;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.List;

/**
 * Created by vicch on 26/01/2018.
 */

public class Aplicacion extends Application{

    private List<Libro> listaLibros;
    private AdaptadorLibrosFiltro adaptador;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(){
        listaLibros = Libro.ejemploLibros();
        adaptador = new AdaptadorLibrosFiltro(this,listaLibros);
    }

    public AdaptadorLibrosFiltro getAdaptador(){
        return adaptador;
    }

    public List<Libro> getListaLibros(){
        return listaLibros;
    }




}
