package com.example.pm2025tarea.ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;

public class Activity1_1 extends AppCompatActivity {

    EditText num1, num2;
    Button sumar, restar, multiplicar, dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_1);

        num1 = (EditText) findViewById(R.id.txtnum1);
        num2 = (EditText) findViewById(R.id.txtnum2);
        sumar = (Button) findViewById(R.id.btnSumar);
        restar = (Button) findViewById(R.id.btnRestar);
        multiplicar = (Button) findViewById(R.id.btnMultiplicar);
        dividir = (Button) findViewById(R.id.btnDividir);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { operar("suma"); }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { operar("resta"); }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { operar("multiplicación"); }
        });

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { operar("división"); }
        });
    }

    private void operar(String operacion) {
        double n1 = leerDoubleDefecto(num1);
        double n2 = leerDoubleDefecto(num2);

        Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);

        if (operacion.equals("división") && n2 == 0) {
            intent.putExtra("error", true);
        } else {
            double resultado = 0;
            switch (operacion) {
                case "suma":
                    resultado = n1 + n2; break;
                case "resta":
                    resultado = n1 - n2; break;
                case "multiplicación":
                    resultado = n1 * n2; break;
                case "división":
                    resultado = n1 / n2; break;
            }
            intent.putExtra("resultado", resultado);
            intent.putExtra("error", false);
        }

        intent.putExtra("operacion", operacion);
        startActivity(intent);
    }

    private double leerDoubleDefecto(EditText et) {
        String texto = et.getText().toString().trim();
        return texto.isEmpty() ? 1.0 : Double.parseDouble(texto);
    }
}
