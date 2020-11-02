package com.davidbeltran.mascotas.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.davidbeltran.mascotas.R;
import com.davidbeltran.mascotas.adapter.MascotaAdaptador;
import com.davidbeltran.mascotas.adapter.MascotaAdaptador2;
import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

import android.graphics.drawable.ColorDrawable;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    ImageView imageView;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container,false);


        //Recycler view
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);

        //recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        GridLayoutManager gri= new GridLayoutManager(getActivity(),3);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(gri);
        inicializarListaMascotas();
        inicializarAdaptador();

        return  v;
    }
    public void inicializarAdaptador(){
        MascotaAdaptador2 adaptador = new MascotaAdaptador2(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( R.drawable.perro1,1));
        mascotas.add(new Mascota(R.drawable.perro1,2));
        mascotas.add(new Mascota(R.drawable.perro1,3));
        mascotas.add(new Mascota(R.drawable.perro1,4));
        mascotas.add(new Mascota(R.drawable.perro1,5));
        mascotas.add(new Mascota(R.drawable.perro1,6));
    }
}