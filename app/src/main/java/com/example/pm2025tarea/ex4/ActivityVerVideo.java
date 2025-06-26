package com.example.pm2025tarea.ex4;


import android.widget.MediaController;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm2025tarea.R;

import android.net.Uri;
import android.widget.Toast;

public class ActivityVerVideo extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_1_ver);

        videoView = findViewById(R.id.videoView);

        String path = getIntent().getStringExtra("path");

        if (path == null || path.isEmpty()) {
            Toast.makeText(this, "No se encontró el video", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }
}
