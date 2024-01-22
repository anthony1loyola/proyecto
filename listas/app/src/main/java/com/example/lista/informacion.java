package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lista.database.Persona;
import com.example.lista.database.PersonaLab;

import java.util.List;

public class informacion extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNombre;
    private EditText editTextUrlFoto;
    private EditText editTextDireccion;
    private EditText editTextTelefono;

    // Instancia de PersonaLab para interactuar con la base de datos
    private PersonaLab personaLab;
    Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);



        btnguardar =(Button) findViewById(R.id.agregar);
        editTextNombre = findViewById(R.id.txt_nombre);
        editTextDireccion = findViewById(R.id.txt_direccion);
        editTextTelefono = findViewById(R.id.txt_numero);
        personaLab=new PersonaLab(this);

        btnguardar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==btnguardar){
            insertPersonas();
            getAllPersonas();

        }
    }

    public void insertPersonas() {

        // Obtener datos del formulario
        String nombre = editTextNombre.getText().toString();
        //String urlFoto = editTextUrlFoto.getText().toString();
        String direccion = editTextDireccion.getText().toString();
        String telefono = editTextTelefono.getText().toString();

        // Crear una instancia de Persona con los datos del formulario

        if (nombre.equals("")) {
            editTextNombre.setError("Ingrese el nombre");
        } else {
            Persona persona = new Persona();
            persona.setNombre(nombre);

            persona.setDireccion(direccion);
            persona.setTelefono(telefono);

            // Agregar la nueva persona a la base de datos utilizando PersonaLab
            personaLab.addPersona(persona);

            editTextNombre.setText("");

            editTextDireccion.setText("");
            editTextTelefono.setText("");

        }
    }

        public void getAllPersonas(){
            PersonaLab personaLab= PersonaLab.get(getApplicationContext());
            List<Persona> personas=personaLab.getPersonas();
            for(Persona p:personas){
                Log.d("InserData","Id:"+p.getId()+"Nombre: "+p.getNombre()+
                        " Url Foto: "+p.getUrl_foto()+" Direccion: "+p.getDireccion()+
                        " Telefono: "+p.getTelefono());
            }
        }

    }
