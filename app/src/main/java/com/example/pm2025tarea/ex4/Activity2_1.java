package com.example.pm2025tarea.ex4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.pm2025tarea.R;
import com.example.pm2025tarea.common.VideoDBHelper;
import com.example.pm2025tarea.common.VideoModel;
import com.example.pm2025tarea.ex3.Activity1_3;

import java.io.File;
import java.util.List;

public class Activity2_1 extends AppCompatActivity {

    static final int REQUEST_VIDEO = 101;
    Uri videoUri;
    File videoFile;
    Button btnGrabar;
    EditText etTitulo;

    ListView lvVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_1);
        etTitulo = findViewById(R.id.etTitulo);
        btnGrabar = findViewById(R.id.btnGrabar);
        lvVideos = findViewById(R.id.lvVideos);
        btnGrabar.setOnClickListener(v -> grabarVideo());
        CargarLista();
    }

    private void CargarLista() {
        List<VideoModel> lista = new VideoDBHelper(this).getAllVideos();

        ArrayAdapter<VideoModel> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        lista);
        lvVideos.setAdapter(adapter);

        lvVideos.setOnItemClickListener((parent, view, pos, id) -> {
            VideoModel vid = lista.get(pos);
            Intent i = new Intent(this, ActivityVerVideo.class);
            i.putExtra("path", vid.path);
            startActivity(i);
        });
    }

    private void grabarVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        videoFile = new File(getExternalFilesDir(Environment.DIRECTORY_MOVIES),
                "vid_" + System.currentTimeMillis() + ".mp4");
        videoUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", videoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
        startActivityForResult(intent, REQUEST_VIDEO);
    }

    @Override
    protected void onActivityResult(int req, int res, Intent data) {
        super.onActivityResult(req, res, data);
        if (req == REQUEST_VIDEO && res == RESULT_OK) {
            String titulo = etTitulo.getText().toString();
            if (titulo.isEmpty()) titulo = "Video sin título";
            new VideoDBHelper(this).insertar(titulo, videoFile.getAbsolutePath());
            Toast.makeText(this, "Video guardado", Toast.LENGTH_SHORT).show();
            CargarLista();
        }
    }
}