package com.example.family.gamenewsdefensa.BaseDeDatos;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Noticia;

@Database(entities = {Noticia.class}, version = 1)
public abstract class RoomDB extends RoomDatabase{
    public abstract NoticiasDAO noticiaDAO();
    private static RoomDB INSTANCE;

    public static RoomDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomDB.class){
                if(INSTANCE == null){
                    INSTANCE= android.arch.persistence.room.Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class,"NoticiasDeJuegos_DataBase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
