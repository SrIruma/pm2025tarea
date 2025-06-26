package com.example.pm2025tarea.ex3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;
import com.example.pm2025tarea.common.Persona;
import com.example.pm2025tarea.common.PersonasDBHelper;
import com.example.pm2025tarea.common.PersonasListAdapter;

import java.util.List;

public class ActivityResultado extends AppCompatActivity {
    ListView listView;
    TextView tvNom, tvEdad, tvCor, tvDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_3_res);

        listView = findViewById(R.id.listPersonas);
        tvNom = findViewById(R.id.tvDetNombre);
        tvEdad = findViewById(R.id.tvDetEdad);
        tvCor = findViewById(R.id.tvDetCorreo);
        tvDir = findViewById(R.id.tvDetDir);

        PersonasDBHelper db = new PersonasDBHelper(getApplicationContext());
        final List<Persona> datos = db.getAllPersonas();

        PersonasListAdapter adapter =
                new PersonasListAdapter(getApplicationContext(), datos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Persona p = datos.get(pos);
                mostrarDetalles(p);
            }
        });
    }

    private void mostrarDetalles(Persona p) {
        tvNom.setText(p.getNombres() + " " + p.getApellidos());
        tvEdad.setText("Edad: " + p.getEdad());
        tvCor.setText("Correo: " + p.getCorreo());
        tvDir.setText("Dirección: " + p.getDireccion());
    }
}