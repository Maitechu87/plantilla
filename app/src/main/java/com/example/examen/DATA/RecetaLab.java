package com.example.examen.DATA;

//Hace uso de Recetadao e interactúa con la bbdd

import android.annotation.SuppressLint;
import android.content.Context;

import com.first.app.pruebaexamen.MODEL.Receta;

import java.util.List;

import androidx.room.Room;

//Los métodos de RecetaLab hacen llamada a los de la interfaz RecetaDao sin implementarlos

public class RecetaLab {

    @SuppressLint("StaticFieldLeak")
    private static RecetaLab mRecetaLab;

    private RecetaDao mRecetaDao;

    public RecetaLab(Context context){
        RecetaDatabase database = Room.databaseBuilder(context,RecetaDatabase.class,
                "RecetaCocina").allowMainThreadQueries().build();
        mRecetaDao = database.getRecetaDao();
    }

        public static RecetaLab get (Context context){
            if (mRecetaLab == null){
                mRecetaLab = new RecetaLab(context);
            }
            return mRecetaLab;
        }

        public List<Receta>getRecetas(){
            return mRecetaDao.getRecetas();
        }

        public Receta getReceta(String id){
            return mRecetaDao.getReceta(id);
        }

        public void addReceta(Receta recipe){
            mRecetaDao.addReceta(recipe);
        }

        public void deleteReceta(Receta recipe){
            mRecetaDao.deleteReceta(recipe);
        }

        public void updateReceta(Receta recipe){
            mRecetaDao.updateReceta(recipe);
        }
}
