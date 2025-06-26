package com.example.pm2025tarea.ex2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;
import com.example.pm2025tarea.common.Persona;

public class ActivityResultado extends AppCompatActivity {

    TextView tvTitulo, tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_2_res);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvDatos  = (TextView) findViewById(R.id.tvDatos);

        Persona persona = (Persona) getIntent().getSerializableExtra("persona");

        if (persona != null) {
            tvTitulo.setText("Información recibida");
            String info =  "Nombre: "   + persona.getNombres()    + "\n" +
                    "Apellidos: " + persona.getApellidos() + "\n" +
                    "Edad: "      + persona.getEdad()      + "\n" +
                    "Correo: "    + persona.getCorreo();
            tvDatos.setText(info);
        } else {
            tvTitulo.setText("No se recibió información");
        }
    }
}