package com.example.family.gamenewsdefensa.TodoLoDeLaAPI;

import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Noticia;
import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface NoticiasJuegosAPI {
    //Obteniendo token
    @POST("/login")
    @FormUrlEncoded
    //Call<Token> savePost(@Field("User") String user, @Field("Password") String pass);

    //Nuevo
    Call<Token> savePost(@Field("user") String user, @Field("password") String pass);

    @GET("/news")
    Call<List<Noticia>> getNews(
            @Header("Authorization:") String Token
    );
}
