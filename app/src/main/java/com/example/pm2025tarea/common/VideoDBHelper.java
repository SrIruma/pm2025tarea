package com.example.pm2025tarea.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class VideoDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "videos.db";
    public static final int DB_VERSION = 1;

    public VideoDBHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE videos(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, path TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS videos");
        onCreate(db);
    }

    public void insertar(String titulo, String path) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("titulo", titulo);
        cv.put("path", path);
        db.insert("videos", null, cv);
    }

    public List<VideoModel> getAllVideos() {
        SQLiteDatabase db = getReadableDatabase();
        List<VideoModel> lista = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM videos", null);
        while (c.moveToNext()) {
            lista.add(new VideoModel(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2)
            ));
        }
        c.close();
        return lista;
    }
}
