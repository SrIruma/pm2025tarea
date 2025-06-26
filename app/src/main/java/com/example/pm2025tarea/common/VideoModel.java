package com.example.pm2025tarea.common;

public class VideoModel {
    public int id;
    public String titulo;
    public String path;

    public VideoModel(int id, String titulo, String path) {
        this.id = id;
        this.titulo = titulo;
        this.path = path;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
