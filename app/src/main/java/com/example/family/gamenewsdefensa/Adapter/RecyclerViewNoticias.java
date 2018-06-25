package com.example.family.gamenewsdefensa.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Noticia;
import com.example.family.gamenewsdefensa.PlainOldJavaObjects.NoticiaDefensa;
import com.example.family.gamenewsdefensa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class RecyclerViewNoticias extends RecyclerView.Adapter<RecyclerViewNoticias.MyViewHolder>{

    //private List<Noticia> noticia;

    //Nuevo
    private List<NoticiaDefensa> noticia;
    private Context miContexto;

    public RecyclerViewNoticias(Context miContexto,List<NoticiaDefensa> noticia){ //Se cambio de Noticia a NoticiaDefensa
        this.miContexto = miContexto;//nuevo
        this.noticia = noticia;
    }

    @Override
    public int getItemCount(){
        return noticia.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //View view = LayoutInflater.from(miContexto).inflate(R.layout.cardview_noticias,parent,false);
        //return new MyViewHolder(view);

        //Nuevo
        View view;
        LayoutInflater inflater = LayoutInflater.from(miContexto);
        view = inflater.inflate(R.layout.cardview_noticias, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        /*holder.Titulo.setText(noticia.get(position).getTitulo());
        Picasso.get()
                .load(noticia.get(position).getCoverImage())
                .fit().into(holder.JuegoImg);*/

        //Nuevo
        holder.Titulo.setText(noticia.get(position).getTitle());
        holder.JuegoImg.setImageResource(noticia.get(position).getJuegoImg());
        holder.Descripcion.setText(" ");
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Titulo;
        ImageView JuegoImg;

        //Nuevo
        TextView Descripcion;
        ImageButton btn_fav;

        public MyViewHolder(View itemView){
            super(itemView);

            Titulo = itemView.findViewById(R.id.txt_title);
            JuegoImg = itemView.findViewById(R.id.img_game);

            //Nuevo
            Descripcion =itemView.findViewById(R.id.descripcion);
            btn_fav = itemView.findViewById(R.id.imgbtn_fav);
        }
    }
}
