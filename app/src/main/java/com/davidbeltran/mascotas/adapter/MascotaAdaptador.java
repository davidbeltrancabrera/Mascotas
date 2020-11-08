package com.davidbeltran.mascotas.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.davidbeltran.mascotas.R;
import com.davidbeltran.mascotas.db.ConstructorMascotas;
import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder , int position) {
       final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikeCV.setText(Integer.toString(mascota.getLike()));
        //mascotaViewHolder.tvLikeCV.setText(String.valueOf(mascota.getLike()));

       mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               Toast.makeText(activity,"Diste Like a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();

               ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
               constructorMascotas.darLikeMascota(mascota);

               mascotaViewHolder.tvLikeCV.setText(Integer.toString(constructorMascotas.obtenerLikesMascota(mascota)));
           }
       });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private  ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikeCV;
        private ImageView btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikeCV = (TextView) itemView.findViewById(R.id.tvLikeCV);
            btnLike = (ImageView) itemView.findViewById(R.id.btnLike);

        }

    }
}
