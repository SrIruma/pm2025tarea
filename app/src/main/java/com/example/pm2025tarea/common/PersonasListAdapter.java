package com.example.pm2025tarea.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pm2025tarea.R;

import java.util.List;

public class PersonasListAdapter extends ArrayAdapter<Persona> {

    public PersonasListAdapter(Context ctx, List<Persona> datos) {
        super(ctx, 0, datos);
    }

    @NonNull
    @Override
    public View getView(int pos, @Nullable View convertView,@NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_persona, parent, false);
        }

        Persona p = getItem(pos);

        TextView tvNom = v.findViewById(R.id.tvRowNombre);
        TextView tvCor = v.findViewById(R.id.tvRowCorreo);

        if (p != null) {
            tvNom.setText(p.getNombres() + " " + p.getApellidos());
            tvCor.setText(p.getCorreo());
        }

        return v;
    }
}
