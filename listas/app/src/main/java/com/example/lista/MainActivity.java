package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lista.database.Persona;
import com.example.lista.database.PersonaLab;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {

    public ArrayList<Persona> listaPersonas=new ArrayList<>();

    public RecyclerView lista;

    public RecyclerAdapter adapter;

    private PersonaLab personaLab;
    //public RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personaLab=new PersonaLab(this);

        lista=(RecyclerView) findViewById(R.id.recyclerview);
        lista.setLayoutManager(new LinearLayoutManager(this));
        getAllPersonas();
        //para contacto
        adapter = new RecyclerAdapter(this, listaPersonas, this);
        lista.setAdapter(adapter);




        Button imageButton = findViewById(R.id.miBoton);

        // Establece un OnClickListener para el ImageButton
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la ActivityForm al hacer clic
                Intent intent = new Intent(MainActivity.this, informacion.class);
                startActivity(intent);
            }
        });
    }

    //para contato
    @Override
    public void onItemClick(int position) {
        // Asegúrate de que position es un índice válido en listaPersonas
        if (position >= 0 && position < listaPersonas.size()) {
            Persona personaSeleccionada = listaPersonas.get(position);

            // Crear un Intent para pasar a la segunda actividad
            Intent intent = new Intent(MainActivity.this, contacto.class);

            // Puedes pasar datos adicionales a la segunda actividad usando el Intent
            intent.putExtra("NOMBRE", personaSeleccionada.getNombre());
            intent.putExtra("APELLIDO", personaSeleccionada.getUrl_foto());
            intent.putExtra("DIRECCION", personaSeleccionada.getDireccion());
            intent.putExtra("TELEFONO", personaSeleccionada.getTelefono());

            // Iniciar la segunda actividad
            startActivity(intent);
        }
    }


    public void getAllPersonas(){
        listaPersonas.clear();
        listaPersonas.addAll(personaLab.getPersonas());

    }

    @Override
    protected void onResume(){
        super.onResume();

        getAllPersonas();
        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_new_contact){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,
                    informacion.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}