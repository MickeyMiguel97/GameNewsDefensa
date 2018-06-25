package com.example.family.gamenewsdefensa.API_DB;

import android.app.Application;
import android.os.AsyncTask;

import com.example.family.gamenewsdefensa.BaseDeDatos.NoticiasDAO;
import com.example.family.gamenewsdefensa.BaseDeDatos.RoomDB;
import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Noticia;
import com.example.family.gamenewsdefensa.TodoLoDeLaAPI.NoticiasJuegosAPI;

import java.util.List;

public class ConexionApiConDB {
    private NoticiasDAO MiNoticiaDao;
    private List<Noticia> TodasLasNoti;
    private NoticiasJuegosAPI api;

    public ConexionApiConDB(Application application){
        RoomDB db = RoomDB.getDatabase(application);
        MiNoticiaDao = db.noticiaDAO();
        TodasLasNoti = MiNoticiaDao.getAllNews();
    }
    public List<Noticia> getAllNews(){
        return TodasLasNoti;
    }
    public void insertNew(Noticia news){        new insertNewAsyncTask(MiNoticiaDao).execute(news);    }
    private static class insertNewAsyncTask extends AsyncTask<Noticia,Void,Void>{
        private NoticiasDAO newDAO;

        public insertNewAsyncTask(NoticiasDAO newDAO){this.newDAO = newDAO;    }

        @Override
        protected Void doInBackground(final Noticia... news) {
            newDAO.insertNew(news[0]);
            return null;
        }
    }
}
