package com.davidbeltran.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.davidbeltran.mascotas.pojo.Mascota;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class BaseDatos2 extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos2(@Nullable Context context) {
        super(context, ConstantesBaseDatos2.DATABASE_NAME, null, ConstantesBaseDatos2.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

                String query1= "CREATE TABLE " + ConstantesBaseDatos2.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos2.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos2.TABLE_MASCOTAS_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos2.TABLE_MASCOTAS_FOTO     + " INTEGER " +
                ")";

                String query2 = "CREATE TABLE " +ConstantesBaseDatos2.TABLE_LIKES_MASCOTAS + "(" +
                ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID_MASCOTA     + " INTEGER, " +
                ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_NUMERO_LIKES   + " INTEGER, " +
                "FOREIGN KEY ("+ ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES "+ ConstantesBaseDatos2.TABLE_MASCOTAS + "(" +ConstantesBaseDatos2.TABLE_MASCOTAS_ID +")" +
                ")";

        db.execSQL(query1);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos2.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos2.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }
    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ConstantesBaseDatos2.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String querylike = "SELECT COUNT("+ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos2.TABLE_LIKES_MASCOTAS +
                    " WHERE " +ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" +mascotaActual.getId();

            Cursor registroslikes = db.rawQuery(querylike,null);
            if(registroslikes.moveToNext()){
                mascotaActual.setLike(registroslikes.getInt(0));
            }else{
                mascotaActual.setLike(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos2.TABLE_MASCOTAS, null,contentValues);
        db.close();
    }
    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos2.TABLE_LIKES_MASCOTAS, null,contentValues);
        db.close();
    }
    public int obtenerLikesM(Mascota mascota){
        int likes = 0;
        String querylike = "SELECT COUNT("+ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDatos2.TABLE_LIKES_MASCOTAS +
                " WHERE " +ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" +mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registroslikes = db.rawQuery(querylike,null);

        while (registroslikes.moveToNext()){
            likes = registroslikes.getInt(0);
        }
        db.close();
        return likes;
    }
    public ArrayList<Mascota> obtenerTodosLasMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

         int inicio=0;
         int fin=4;
        String query = "SELECT * FROM "+ConstantesBaseDatos2.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String querylike = "SELECT TOP 5 COUNT("+ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos2.TABLE_LIKES_MASCOTAS +
                    " WHERE " +ConstantesBaseDatos2.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" +mascotaActual.getId();

            Cursor registroslikes = db.rawQuery(querylike,null);
            if(registroslikes.moveToNext()){
                mascotaActual.setLike(registroslikes.getInt(0));
            }else{
                mascotaActual.setLike(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
}
