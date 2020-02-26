package com.example.examen.DATA;

import com.example.examen.MODEL.Receta;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

//Contiene métodos para modificar bbdd y para extraer los datos almacenados
@Dao
interface RecetaDao {
//en el select se pone el nombre de la tabla
    @Query("SELECT * FROM RecetaCocina")
    List<Receta> getRecetas();

    @Query("SELECT * FROM RecetaCocina WHERE id LIKE :uuid")
    Receta getReceta(String uuid);

    @Insert
    void addReceta(Receta recipe);

    @Delete
    void deleteReceta(Receta recipe);

    @Update
    void updateReceta(Receta recipe);
}
