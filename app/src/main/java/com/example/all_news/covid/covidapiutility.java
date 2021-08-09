package com.example.all_news.covid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class covidapiutility {
    public static Retrofit retrofit=null;
    public static covidapiinterface getapicovidinterface(){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(covidapiinterface.url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(covidapiinterface.class);
    }
}
