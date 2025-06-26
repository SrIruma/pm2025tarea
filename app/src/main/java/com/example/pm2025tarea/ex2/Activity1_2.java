package com.example.pm2025tarea.ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;
import com.example.pm2025tarea.common.Persona;

public class Activity1_2 extends AppCompatActivity {

    EditText etNombre, etApellidos, etEdad, etCorreo;
    Button   btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_2);

        etNombre    = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellido);
        etEdad      = (EditText) findViewById(R.id.etEdad);
        etCorreo    = (EditText) findViewById(R.id.etCorreo);
        btnEnviar   = (Button)   findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarInformacion();
            }
        });
    }

    private void enviarInformacion() {
        String nombre    = etNombre.getText().toString().trim();
        String apellidos = etApellidos.getText().toString().trim();
        String edadStr   = etEdad.getText().toString().trim();
        String correo    = etCorreo.getText().toString().trim();

        if (nombre.isEmpty() || apellidos.isEmpty() || edadStr.isEmpty() || correo.isEmpty()) {
            Toast.makeText(this, "¡Por favor completa todos los campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Edad no válida", Toast.LENGTH_SHORT).show();
            return;
        }

        Persona persona = new Persona(nombre, apellidos, edad, correo, "");

        Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);
        intent.putExtra("persona", persona);
        startActivity(intent);
    }
}