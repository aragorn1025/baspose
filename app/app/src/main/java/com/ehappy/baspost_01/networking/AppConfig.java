package com.ehappy.baspost_01.networking;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppConfig {

    //domain name , ip address
    //public static String BASE_URL = "http://127.0.0.1:8888/";
    public static String BASE_URL = "http://192.168.0.135:8888/";

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
