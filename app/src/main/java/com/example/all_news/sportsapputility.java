package com.example.all_news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class sportsapputility {
    public static Retrofit retrofit = null;

    public static sportsapiinterface get2apiinterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(sportsapiinterface.url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(sportsapiinterface.class);
    }
}
