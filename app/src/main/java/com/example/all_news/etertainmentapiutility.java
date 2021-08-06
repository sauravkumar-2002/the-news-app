package com.example.all_news;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class etertainmentapiutility {
    public static Retrofit retrofit = null;

    public static entertainmentapiinterface get2apiinterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(entertainmentapiinterface.url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(entertainmentapiinterface.class);
    }
}

