package com.example.all_news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface businessapiinterface {
    String url="https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<modelgenersl> getfn(@Query("apiKey")String apikey, @Query("category")String category, @Query("pageSize")int pageSize, @Query("language")String language);
}
