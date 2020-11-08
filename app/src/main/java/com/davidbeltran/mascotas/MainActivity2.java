package com.davidbeltran.mascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.davidbeltran.mascotas.adapter.MascotaAdaptador;
import com.davidbeltran.mascotas.db.ConstantesBaseDatos2;
import com.davidbeltran.mascotas.db.ConstructorMascotas;
import com.davidbeltran.mascotas.fragment.IRecyclerViewFavorite;
import com.davidbeltran.mascotas.fragment.IRecyclerViewFragmentView;
import com.davidbeltran.mascotas.pojo.Mascota;
import com.davidbeltran.mascotas.presentador.IRecyclerPresenterFavorite;
import com.davidbeltran.mascotas.presentador.RecyclerPresenterFavorite;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    private IRecyclerViewFavorite iRecyclerViewFavorite;

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Context context;
    private ConstructorMascotas constructorMascotas;

    private RecyclerPresenterFavorite re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //RecyclerPresenterFavorite rg = new RecyclerPresenterFavorite();
        //rg.obtenerDatosMascotasFavoritas();

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        //RecyclerPresenterFavorite ff = new  RecyclerPresenterFavorite();
        //ff.mostrarMascotasFav();
        //obtenerDatosMascotasFavoritas();

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Felipe",R.drawable.perro1,6));
        mascotas.add(new Mascota("Homero",R.drawable.perro2,5));
        mascotas.add(new Mascota("Cachuchin",R.drawable.perro3,4));
        mascotas.add(new Mascota("Cr7",R.drawable.perro5,3));
        mascotas.add(new Mascota("Messi",R.drawable.perro4,2));

        //obtenerDatosMascotasFavoritas();
    }
}