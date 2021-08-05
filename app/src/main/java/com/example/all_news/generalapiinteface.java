package com.example.all_news;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface generalapiinteface {

    String url="https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<modelgenersl> getfn(@Query("apiKey")String apikey,@Query("category")String category,@Query("pageSize")int pageSize,@Query("language")String language);
}
