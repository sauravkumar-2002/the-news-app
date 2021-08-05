package com.example.all_news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class generalapputility {
    public static Retrofit retrofit=null;
    public  static generalapiinteface geapiinterface(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(generalapiinteface.url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(generalapiinteface.class);
    }
}
