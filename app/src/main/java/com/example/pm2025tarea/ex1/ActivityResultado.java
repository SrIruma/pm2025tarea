package com.example.pm2025tarea.ex1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;

public class ActivityResultado extends AppCompatActivity {

    TextView title, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_1_res);

        title = (TextView) findViewById(R.id.txtTR);
        resultado = (TextView) findViewById(R.id.txtResultado);

        String operacion = getIntent().getStringExtra("operacion");
        boolean error = getIntent().getBooleanExtra("error", false);

        if (error && operacion.equals("división")) {
            title.setText("¡Error! No se puede dividir entre 0.");
            resultado.setText("¡Imposible!");
        } else {
            double res = getIntent().getDoubleExtra("resultado", 0);
            title.setText("El resultado de su " + operacion + " es");
            resultado.setText(String.valueOf(res));
        }
    }
}
