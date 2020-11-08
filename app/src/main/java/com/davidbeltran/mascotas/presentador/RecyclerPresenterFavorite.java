package com.davidbeltran.mascotas.presentador;

import android.content.Context;

import com.davidbeltran.mascotas.db.ConstructorMascotas;
import com.davidbeltran.mascotas.fragment.IRecyclerViewFavorite;
import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerPresenterFavorite implements IRecyclerPresenterFavorite {

    private IRecyclerViewFavorite iRecyclerViewFavorite;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerPresenterFavorite(IRecyclerViewFavorite iRecyclerViewFavorite, Context context) {
        this.iRecyclerViewFavorite = iRecyclerViewFavorite;
        this.context=context;
        obtenerDatosMascotasFavoritas();
    }

    public RecyclerPresenterFavorite() {

    }

    @Override
    public void obtenerDatosMascotasFavoritas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosFavoritos();
        mostrarMascotasFav();
    }

    @Override
    public void mostrarMascotasFav() {
        iRecyclerViewFavorite.inicializarAdaptadorRV(iRecyclerViewFavorite.crearAdaptador(mascotas));
        iRecyclerViewFavorite.generarLinearLayoutVertical();
    }
}
