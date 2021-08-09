package com.example.all_news.covid;

import android.net.DnsResolver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.all_news.R;
import com.example.all_news.databinding.FragmentUpdatesBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class updates extends Fragment {
    FragmentUpdatesBinding binding;
    modelcovid modelcovid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.v("asdf","ffffff");
        binding=FragmentUpdatesBinding.inflate(inflater,container,false);


          covidapiutility.getapicovidinterface().getfn().enqueue(new Callback<com.example.all_news.covid.modelcovid>() {
              @Override
              public void onResponse(Call<com.example.all_news.covid.modelcovid> call, Response<com.example.all_news.covid.modelcovid> response) {
                  Log.v("asdf",String.valueOf(response.body().getCases()));
                  binding.totalcases.setText(response.body().getCases());
                  binding.death.setText(response.body().getDeaths());
                  binding.todaydeath.setText(response.body().getTodayDeaths());
                  binding.todayrecoverd.setText(response.body().getTodayRecovered());
                  binding.recoverd.setText(response.body().getRecovered());
              }

              @Override
              public void onFailure(Call<com.example.all_news.covid.modelcovid> call, Throwable t) {

              }
          });


        return binding.getRoot();
    }
}