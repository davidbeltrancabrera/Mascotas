package com.davidbeltran.mascotas.fragment;

import com.davidbeltran.mascotas.adapter.MascotaAdaptador;
import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFavorite {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
