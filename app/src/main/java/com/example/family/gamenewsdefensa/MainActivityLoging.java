package com.example.family.gamenewsdefensa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.family.gamenewsdefensa.PlainOldJavaObjects.Token;
import com.example.family.gamenewsdefensa.TodoLoDeLaAPI.ApiEndPoint;
import com.example.family.gamenewsdefensa.TodoLoDeLaAPI.NoticiasJuegosAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityLoging extends AppCompatActivity {

    Button BotonSignIn;
    EditText EditTextPassword,EditTextUser;
    NoticiasJuegosAPI api;
    Token post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loging);

        post = new Token();
        api = ApiEndPoint.getGameNewsAPI();
        EditTextPassword = findViewById(R.id.EditTextPassword);
        EditTextUser = findViewById(R.id.EditTextUser);
        BotonSignIn = (Button) findViewById(R.id.BotonSignIn);

        BotonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = EditTextUser.getText().toString().trim();
                String Password = EditTextPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(User) && !TextUtils.isEmpty(Password)) {
                    MandarToken(User, Password);

                    //Se me olvidó comentariar esto, hacía pruebas
                    //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    //startActivity(intent);
                }
            }
        });
    }

    public void MandarToken(final String User, final String Password){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        api.savePost(User,Password).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()){
                    showResponse(response.body().toString());
                    if(response.body().toString() != null){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else {
                        //Jamás entro al if anterior, solo aca
                        Toast.makeText(getApplicationContext(),"Usuario no registrado", Toast.LENGTH_SHORT).show();
                    }
                    Log.i("NoEntendíx3","El token se mando a la api"+ response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("NoEntendíx2","No se pudo mandar el token a la Api");
            }
        });
    }

    public void showResponse(String response) {
        Log.d("NoEntendi", "es null: "+(response==null));
    }
}