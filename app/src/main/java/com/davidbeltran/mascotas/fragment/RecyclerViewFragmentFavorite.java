package com.davidbeltran.mascotas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidbeltran.mascotas.R;
import com.davidbeltran.mascotas.adapter.MascotaAdaptador;
import com.davidbeltran.mascotas.pojo.Mascota;
import com.davidbeltran.mascotas.presentador.IRecyclerPresenterFavorite;
import com.davidbeltran.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.davidbeltran.mascotas.presentador.RecyclerPresenterFavorite;
import com.davidbeltran.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragmentFavorite extends Fragment implements  IRecyclerViewFavorite {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerPresenterFavorite presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.activity_main2, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas2);
        presenter = new RecyclerPresenterFavorite(this, getContext());
        return  v;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
