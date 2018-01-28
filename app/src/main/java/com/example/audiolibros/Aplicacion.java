package com.example.audiolibros;

import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by vicch on 26/01/2018.
 */

public class Aplicacion extends Application{

    private List<Libro> listaLibros;
    private AdaptadorLibrosFiltro adaptador;

    private static RequestQueue colaPeticiones;
    private static ImageLoader lectorImagenes;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(){
        colaPeticiones = Volley.newRequestQueue(this);
        lectorImagenes = new ImageLoader(colaPeticiones, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<>(10);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });

        listaLibros = Libro.ejemploLibros();
        adaptador = new AdaptadorLibrosFiltro(this,listaLibros);
    }

    public AdaptadorLibrosFiltro getAdaptador(){
        return adaptador;
    }

    public List<Libro> getListaLibros(){
        return listaLibros;
    }

    public static RequestQueue getColaPeticiones() {
        return colaPeticiones;
    }

    public static void setColaPeticiones(RequestQueue colaPeticiones) {
        Aplicacion.colaPeticiones = colaPeticiones;
    }

    public static ImageLoader getLectorImagenes() {
        return lectorImagenes;
    }

    public static void setLectorImagenes(ImageLoader lectorImagenes) {
        Aplicacion.lectorImagenes = lectorImagenes;
    }
}
