package com.example.pm2025tarea.common;

import java.io.Serializable;

public class Persona implements Serializable {

    private long   id;
    private String nombres;
    private String apellidos;
    private int    edad;
    private String correo;
    private String direccion;

    public Persona() { }

    public Persona(String nombres, String apellidos,
                   int edad, String correo, String direccion) {
        this.nombres    = nombres;
        this.apellidos  = apellidos;
        this.edad       = edad;
        this.correo     = correo;
        this.direccion  = direccion;
    }

    // Getters y Setters
    public long   getId()          { return id; }
    public void   setId(long id)   { this.id = id; }

    public String getNombres()     { return nombres; }
    public void   setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos()   { return apellidos; }
    public void   setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int    getEdad()        { return edad; }
    public void   setEdad(int edad){ this.edad = edad; }

    public String getCorreo()      { return correo; }
    public void   setCorreo(String correo) { this.correo = correo; }

    public String getDireccion()   { return direccion; }
    public void   setDireccion(String direccion) { this.direccion = direccion; }
}
