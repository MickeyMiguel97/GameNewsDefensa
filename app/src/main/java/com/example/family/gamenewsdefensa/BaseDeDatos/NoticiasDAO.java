package com.example.family.gamenewsdefensa.BaseDeDatos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Noticia;

import java.util.List;

@Dao
public interface NoticiasDAO {
    @Insert
    void insertNew(Noticia noticia);
    @Query("SELECT * FROM noticias")
    List<Noticia> getAllNews();
    @Query("DELETE FROM noticias")
    void deleteAllNews();
}
