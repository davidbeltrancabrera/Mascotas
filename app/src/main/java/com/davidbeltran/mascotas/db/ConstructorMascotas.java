package com.davidbeltran.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.davidbeltran.mascotas.R;
import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context= context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos2 db = new BaseDatos2(context);
        insertarTresMascotas(db);
        return db.obtenerTodosLasMascotas();
    }
    public ArrayList<Mascota> obtenerDatosFavoritos(){
        BaseDatos2 db = new BaseDatos2(context);
        return db.obtenerTodosLasMascotasFavoritas();
    }

    private void insertarTresMascotas(BaseDatos2 db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos2.TABLE_MASCOTAS_NOMBRE,"Felipe");
        contentValues.put(ConstantesBaseDatos2.TABLE_MASCOTAS_FOTO, R.drawable.perro1);

        db.insertarMascota(contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(ConstantesBaseDatos2.TABLE_MASCOTAS_NOMBRE,"Homero");
        contentValues2.put(ConstantesBaseDatos2.TABLE_MASCOTAS_FOTO,R.drawable.perro2);

        db.insertarMascota(contentValues2);

        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(ConstantesBaseDatos2.TABLE_MASCOTAS_NOMBRE,"Cachuchin");
        contentValues3.put(ConstantesBaseDatos2.TABLE_MASCOTAS_FOTO,R.drawable.perro3);

        db.insertarMascota(contentValues3);

        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(ConstantesBaseDatos2.TABLE_MASCOTAS_NOMBRE,"Messi");
        contentValues4.put(ConstantesBaseDatos2.TABLE_MASCOTAS_FOTO,R.drawable.perro4);

        db.insertarMascota(contentValues4);

        ContentValues contentValues5 = new ContentValues();
        contentValues5.put(ConstantesBaseDatos2.TABLE_MASCOTAS_NOMBRE,"Cr7");
        contentValues5.put(ConstantesBaseDatos2.TABLE_MASCOTAS_FOTO,R.drawable.perro5);

        db.insertarMascota(contentValues5);
    }
    public void darLikeMascota(Mascota mascota){
        BaseDatos2 db = new BaseDatos2(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }
    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos2 db = new BaseDatos2(context);
        return db.obtenerLikesM(mascota);

    }
}
