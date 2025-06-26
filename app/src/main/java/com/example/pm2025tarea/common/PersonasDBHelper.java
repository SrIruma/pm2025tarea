package com.example.pm2025tarea.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PersonasDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME    = "personas.db";
    private static final int    DB_VERSION = 1;

    // Tabla y columnas
    public static final String TABLE_PERSONAS = "personas";
    public static final String COL_ID        = "_id";
    public static final String COL_NOMBRES   = "nombres";
    public static final String COL_APELLIDOS = "apellidos";
    public static final String COL_EDAD      = "edad";
    public static final String COL_CORREO    = "correo";
    public static final String COL_DIRECCION = "direccion";

    private static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_PERSONAS + " (" +
                    COL_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOMBRES   + " TEXT NOT NULL, " +
                    COL_APELLIDOS + " TEXT NOT NULL, " +
                    COL_EDAD      + " INTEGER, " +
                    COL_CORREO    + " TEXT, " +
                    COL_DIRECCION + " TEXT" +
                    ");";

    public PersonasDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAS);
        onCreate(db);
    }

    // INSERT
    public long insertPersona(Persona p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOMBRES,   p.getNombres());
        values.put(COL_APELLIDOS, p.getApellidos());
        values.put(COL_EDAD,      p.getEdad());
        values.put(COL_CORREO,    p.getCorreo());
        values.put(COL_DIRECCION, p.getDireccion());
        long id = db.insert(TABLE_PERSONAS, null, values);
        p.setId(id);
        db.close();
        return id;
    }

    // UPDATE
    public int updatePersona(Persona p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOMBRES,   p.getNombres());
        values.put(COL_APELLIDOS, p.getApellidos());
        values.put(COL_EDAD,      p.getEdad());
        values.put(COL_CORREO,    p.getCorreo());
        values.put(COL_DIRECCION, p.getDireccion());
        int rows = db.update(TABLE_PERSONAS, values,
                COL_ID + " = ?", new String[]{ String.valueOf(p.getId()) });
        db.close();
        return rows;
    }

    // DELETE
    public int deletePersona(long id) {
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(TABLE_PERSONAS,
                COL_ID + " = ?", new String[]{ String.valueOf(id) });
        db.close();
        return rows;
    }

    // SELECT 1
    public Persona getPersona(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_PERSONAS, null,
                COL_ID + " = ?", new String[]{ String.valueOf(id) },
                null, null, null);
        Persona p = null;
        if (c.moveToFirst()) {
            p = cursorToPersona(c);
        }
        c.close();
        db.close();
        return p;
    }

    // SELECT *
    public List<Persona> getAllPersonas() {
        List<Persona> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_PERSONAS, null);
        if (c.moveToFirst()) {
            do {
                lista.add(cursorToPersona(c));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return lista;
    }

    /* Utilidad */
    private Persona cursorToPersona(Cursor c) {
        Persona p = new Persona();
        p.setId(         c.getLong (c.getColumnIndexOrThrow(COL_ID)));
        p.setNombres(    c.getString(c.getColumnIndexOrThrow(COL_NOMBRES)));
        p.setApellidos(  c.getString(c.getColumnIndexOrThrow(COL_APELLIDOS)));
        p.setEdad(       c.getInt   (c.getColumnIndexOrThrow(COL_EDAD)));
        p.setCorreo(     c.getString(c.getColumnIndexOrThrow(COL_CORREO)));
        p.setDireccion(  c.getString(c.getColumnIndexOrThrow(COL_DIRECCION)));
        return p;
    }
}
