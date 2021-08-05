package com.example.all_news;

import android.os.Bundle;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link general#newInstance} factory method to
 * create an instance of this fragment.
 */
public class general extends Fragment {
    modelgenersl modelgenersl;
ArrayList<modelarticles> article;
    FragmentGeneralBinding binding;
    generaladapter generaladapter;
    ArrayList<modelarticles>listrecv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public general() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment general.
     */
    // TODO: Rename and change types and number of parameters
    public static general newInstance(String param1, String param2) {
        general fragment = new general();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentGeneralBinding.inflate(inflater, container, false);
     article=new ArrayList<>();
     listrecv=new ArrayList<>();
        binding.generalrecv.setLayoutManager(new LinearLayoutManager(getContext()));
        generaladapter=new generaladapter(article,getContext());
       binding.generalrecv.setAdapter(generaladapter);

        generalapputility generalapputility=new generalapputility();
        generalapputility.geapiinterface().getfn("04a8284df13b4d37878a479e5d57f53b","general",100,"en").enqueue(new Callback<com.example.all_news.modelgenersl>() {
            @Override
            public void onResponse(Call<com.example.all_news.modelgenersl> call, Response<com.example.all_news.modelgenersl> response) {
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