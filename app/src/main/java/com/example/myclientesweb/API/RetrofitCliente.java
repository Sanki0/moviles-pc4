package com.example.myclientesweb.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {
    private static Retrofit salidaRetrofit;
    public static Retrofit getInstance(){
        if(salidaRetrofit==null){
            salidaRetrofit = new Retrofit.Builder()
                    .baseUrl("https://sesiona.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return salidaRetrofit;
    }
    private RetrofitCliente(){
    }
}
