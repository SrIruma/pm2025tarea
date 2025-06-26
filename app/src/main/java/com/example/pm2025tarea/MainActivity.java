package com.example.pm2025tarea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.ex1.Activity1_1;
import com.example.pm2025tarea.ex2.Activity1_2;
import com.example.pm2025tarea.ex3.Activity1_3;
import com.example.pm2025tarea.ex4.Activity2_1;

public class MainActivity extends AppCompatActivity {

    Button ex1, ex2, ex3, ex4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ex1 = (Button) findViewById(R.id.btntarea1);
        ex2 = (Button) findViewById(R.id.btntarea2);
        ex3 = (Button) findViewById(R.id.btntarea3);
        ex4 = (Button) findViewById(R.id.btntarea4);

        ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity1_1.class);
                startActivity(intent);
            }
        });
        ex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity1_2.class);
                startActivity(intent);
            }
        });
        ex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity1_3.class);
                startActivity(intent);
            }
        });
        ex4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2_1.class);
                startActivity(intent);
            }
        });
    }
}
