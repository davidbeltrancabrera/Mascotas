package com.davidbeltran.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidbeltran.mascotas.R;
import com.davidbeltran.mascotas.adapter.MascotaAdaptador;
import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragment extends Fragment {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        //Recycler view
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return  v;

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Felipe", R.drawable.perro1,1));
        mascotas.add(new Mascota("Mbape",R.drawable.perro2,2));
        mascotas.add(new Mascota("Cachu",R.drawable.perro3,3));
        mascotas.add(new Mascota("Scot",R.drawable.perro4,4));
        mascotas.add(new Mascota("Zorro",R.drawable.perro5,5));
        mascotas.add(new Mascota("Homero",R.drawable.perro6,6));
    }
}
