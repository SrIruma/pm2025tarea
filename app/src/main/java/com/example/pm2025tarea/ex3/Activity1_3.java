package com.example.pm2025tarea.ex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;
import com.example.pm2025tarea.common.Persona;
import com.example.pm2025tarea.common.PersonasDBHelper;

public class Activity1_3 extends AppCompatActivity {

    EditText etNom, etApe, etEdad, etCorreo, etDir;
    Button   btnSalvar, btnListar;

    PersonasDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_3);

        dbHelper   = new PersonasDBHelper(this);

        etNom    = (EditText) findViewById(R.id.etNom);
        etApe    = (EditText) findViewById(R.id.etApe);
        etEdad   = (EditText) findViewById(R.id.etEd);
        etCorreo = (EditText) findViewById(R.id.etCor);
        etDir    = (EditText) findViewById(R.id.etDir);
        btnSalvar= (Button)   findViewById(R.id.btnSalvar);
        btnListar= (Button)   findViewById(R.id.btnListar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPersona();
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);
                startActivity(intent);
            }
        });
    }

    private void guardarPersona() {
        String nom  = etNom.getText().toString().trim();
        String ape  = etApe.getText().toString().trim();
        String edadS= etEdad.getText().toString().trim();
        String cor  = etCorreo.getText().toString().trim();
        String dir  = etDir.getText().toString().trim();

        if (nom.isEmpty() || ape.isEmpty() || edadS.isEmpty()) {
            Toast.makeText(this, "Campos obligatorios vacíos", Toast.LENGTH_SHORT).show();
            return;
        }

        int edad = Integer.parseInt(edadS);
        Persona p = new Persona(nom, ape, edad, cor, dir);
        long id = dbHelper.insertPersona(p);

        Toast.makeText(this, "Guardado con ID: " + id, Toast.LENGTH_LONG).show();
        limpiarCampos();
    }

    private void limpiarCampos() {
        etNom.setText("");
        etApe.setText("");
        etEdad.setText("");
        etCorreo.setText("");
        etDir.setText("");
    }
}
