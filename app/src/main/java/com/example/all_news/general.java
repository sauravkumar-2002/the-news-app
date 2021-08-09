package com.example.all_news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.all_news.databinding.FragmentGeneralBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class general extends Fragment {
    modelgenersl modelgenersl;
ArrayList<modelarticles> article;
    FragmentGeneralBinding binding;
    generaladapter generaladapter;
    ArrayList<modelarticles>listrecv;
    String languageselected="en",countryselected="in";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentGeneralBinding.inflate(inflater, container, false);
        binding.pleasewait.setVisibility(View.VISIBLE);
     article=new ArrayList<>();
     listrecv=new ArrayList<>();
        binding.generalrecv.setLayoutManager(new LinearLayoutManager(getContext()));
        generaladapter=new generaladapter(article,getContext());
       binding.generalrecv.setAdapter(generaladapter);
        dashboard dashboard=(dashboard)getActivity();
        languageselected=dashboard.getMydata();
        Log.v("saurav","fg   activityoncreateview");
      //  Toast.makeText(getContext(),languageselected,Toast.LENGTH_SHORT).show();
        generalapputility generalapputility=new generalapputility();
        generalapputility.geapiinterface().getfn("04a8284df13b4d37878a479e5d57f53b","general",100,languageselected).enqueue(new Callback<com.example.all_news.modelgenersl>() {
            @Override
            public void onResponse(Call<com.example.all_news.modelgenersl> call, Response<com.example.all_news.modelgenersl> response) {
                binding.pleasewait.setVisibility(View.GONE);
                modelgenersl=response.body();
                article.addAll(modelgenersl.getArticles());
                String s=article.get(1).getSource().get("name");
               // String x=article.get(2).getAuthor();
              //  Log.v("fgh",x);
                generaladapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<com.example.all_news.modelgenersl> call, Throwable t) {

            }
        });
return binding.getRoot();
    }

}