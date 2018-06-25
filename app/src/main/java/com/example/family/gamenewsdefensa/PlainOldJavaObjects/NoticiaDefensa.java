package com.example.family.gamenewsdefensa.PlainOldJavaObjects;

public class NoticiaDefensa {
    private String title;
    private String descripcion;
    private int JuegoImg;

    public NoticiaDefensa(String descripcion, String title,int JuegoImg) {
        this.descripcion = descripcion;
        this.title = title;
        this.JuegoImg = JuegoImg;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getJuegoImg() {
        return JuegoImg;
    }

    public void setJuegoImg(int juegoImg) {
        JuegoImg = juegoImg;
    }
}
