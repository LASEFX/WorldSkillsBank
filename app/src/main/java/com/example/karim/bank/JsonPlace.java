package com.example.karim.bank;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlace {


        @GET("bankomats")
        Call<List<Get>> getPosts();

        @GET("valute")
        Call<List<Get1>> getPops();
}
