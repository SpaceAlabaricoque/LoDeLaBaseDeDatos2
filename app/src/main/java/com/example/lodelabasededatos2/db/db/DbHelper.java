package com.example.lodelabasededatos2.db.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static String nombreDb;
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "reciclaje.db";
    private static final String TABLE_USUARIOS = "t_usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE if exists " + TABLE_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists " + TABLE_USUARIOS);
        //sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USUARIOS);
        //onCreate(sqLiteDatabase);
    }

    public void createTable(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIOS +
                //"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "(nombre TEXT NOT NULL," +
                "apellidos TEXT NOT NULL,"+
                "contraseña TEXT NOT NULL,"+
                "correo_electronico TEXT NOT NULL)"
        );
    }

    public boolean insert(String name, String surName, String password, String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nombre", name);
        values.put("apellidos", surName);
        values.put("contraseña", password);
        values.put("correo_electronico", email);

        long result = db.insert(TABLE_USUARIOS, null,values);
        Log.d("HOLA :", String.valueOf(result));
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean searchUser(String userName, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USUARIOS + " WHERE nombre = '"+userName+"' AND contraseña = '"+ password +"'" , null);
        cursor.moveToFirst();
        Log.d("Haber si fufa el cursor",cursor.getString(0));

        if(!cursor.getString(0).equals(userName)){
            return false;
        }else if(!cursor.getString(1).equals(password)){
            return false;
        }else{
            return true;
        }

    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_USUARIOS, null);
        cursor.moveToFirst();


        return cursor;
    }
}
