package com.example.examen.DATA;
import com.example.examen.MODEL.Receta;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {Receta.class},version=1)

public abstract class RecetaDatabase extends RoomDatabase {

    public abstract RecetaDao getRecetaDao();
}