package com.example.family.gamenewsdefensa.PlainOldJavaObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("Token")
    @Expose
    private String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        this.Token = Token;
    }

    @Override
    public String toString() {
        return "Token {" + Token;
    }
}
