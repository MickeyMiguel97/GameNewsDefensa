package com.example.family.gamenewsdefensa.PlainOldJavaObjects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "noticias")
public class Noticia {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id")
    private int Id;
    private String Titulo;
    private int CoverImage;
    @ColumnInfo(name = "create_date")
    private String CreateDate;
    private String Descripcion;

    public Noticia(){}

    public Noticia( String Titulo, int CoverImage, String CreateDate, String Descripcion) {
        this.Titulo = Titulo;
        this.CoverImage = CoverImage;
        this.CreateDate = CreateDate;
        this.Descripcion = Descripcion;
    }

    @NonNull
    public int getId() {
        return Id;
    }

    public void setId(@NonNull int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getCoverImage() {
        return CoverImage;
    }

    public void setCoverImage(int coverImage) {
        CoverImage = coverImage;
    }

    public String getCreateDate() {return CreateDate;}

    public void setCreateDate(String createDate){CreateDate = createDate;}

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
