package com.example.examen.MODEL;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.examen.DATA.RecetaDatabase;
import com.example.examen.DATA.RecetaLab;


/*Esta anotación hace referencia a que es una instancia de esta clase lo que vamos a
 guardar en la base de datos*/

@Entity(tableName = "RecetaCocina")

public class Receta {
    //Identifica cada objeto y no puede ser null
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    //Columnas
    @ColumnInfo(name = "Vegano")
    private boolean esVegano;

    @ColumnInfo(name="Tiempo preparacion")
    private String tiempo;

    @ColumnInfo(name="ingredientes")
    private String ingredientes;

    @ColumnInfo(name="nombre")
    private String nombre;

    public Receta(){    }

    public Receta(String name, String ingred, String time, boolean vegan){
        nombre = name;
        ingredientes = ingred;
        tiempo = time;
        esVegano = vegan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean esVegano() {
        return esVegano;
    }

    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
