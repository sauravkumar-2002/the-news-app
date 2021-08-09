package com.example.all_news.covid;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface covidapiinterface {
    String url="https://disease.sh/v3/covid-19/";
    @GET("all")
    Call<modelcovid>getfn();
    @PUT("countries/{country}")
    Call<modelcovid>getcountry(@Path("country") String country);

}
