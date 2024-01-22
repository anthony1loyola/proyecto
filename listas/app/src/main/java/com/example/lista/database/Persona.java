package com.example.lista.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity (tableName = "persona")
public class Persona {

        @PrimaryKey(autoGenerate = true)
        @NonNull
        private int id;

        @ColumnInfo(name = "nombre")
        @NonNull
        private String nombre;

        @ColumnInfo(name = "url_foto")
        private  String url_foto;

        @ColumnInfo(name = "direccion")
        private String direccion;

        @ColumnInfo(name = "telefono")
        private String telefono;

        public String getDireccion(){
            return  direccion;
        }

        public void setDireccion(String direccion){
            this.direccion=direccion;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre( String nombre) {
            this.nombre = nombre;
        }

        public String getUrl_foto() {
            return url_foto;
        }

        public void setUrl_foto(String url_foto) {
            this.url_foto = url_foto;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
}
