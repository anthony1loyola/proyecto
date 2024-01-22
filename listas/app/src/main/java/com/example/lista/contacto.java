package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Recuperar datos del Intent
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("NOMBRE");
        String apellido = intent.getStringExtra("APELLIDO");
        String direccion = intent.getStringExtra("DIRECCION");
        String telefono = intent.getStringExtra("TELEFONO");

        // Mostrar los datos en TextViews u otros elementos de tu interfaz
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        TextView textViewApellido = findViewById(R.id.textViewApellido);
        TextView textViewDireccion = findViewById(R.id.textViewDireccion);
        TextView textViewTelefono = findViewById(R.id.textViewTelefono);

        textViewNombre.setText(nombre);
        textViewApellido.setText(apellido);
        textViewDireccion.setText(direccion);
        textViewTelefono.setText(telefono);
    }
}