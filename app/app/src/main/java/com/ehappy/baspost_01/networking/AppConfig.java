package com.ehappy.baspost_01.networking;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppConfig {

    //domain name , ip address
    //public static String BASE_URL = "http://127.0.0.1:8888/";
    //public static String BASE_URL = "http://192.168.1.162:8888/";

    //define the base url of our API.
    public static String BASE_URL = "http://140.115.51.184:40130/";

    public static Retrofit getRetrofit() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
