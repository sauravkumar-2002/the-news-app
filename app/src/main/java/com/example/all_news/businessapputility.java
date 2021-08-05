package com.example.all_news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class businessapputility {
    public static Retrofit retrofit = null;

    public static businessapiinterface getapiinterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(businessapiinterface.url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(businessapiinterface.class);
    }
}