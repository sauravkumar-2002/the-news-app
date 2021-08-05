package com.example.all_news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.all_news.databinding.FragmentSportsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sports#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sports extends Fragment {
    FragmentSportsBinding sportsBinding;
    modelgenersl modelgenersl;
    ArrayList<modelarticles> listew;
    sportsadapter sportsadapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sports() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sports.
     */
    // TODO: Rename and change types and number of parameters
    public static sports newInstance(String param1, String param2) {
        sports fragment = new sports();
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
        sportsBinding=FragmentSportsBinding.inflate(inflater, container, false);
        sportsBinding.sprecv.setLayoutManager(new LinearLayoutManager(getActivity()));

        listew=new ArrayList<>();

        sportsadapter=new sportsadapter(listew,getContext());
        sportsBinding.sprecv.setAdapter(sportsadapter);
        sportsapputility.get2apiinterface().getfn("04a8284df13b4d37878a479e5d57f53b","sports",100,"en").enqueue(new Callback<com.example.all_news.modelgenersl>() {
            @Override
            public void onResponse(Call<com.example.all_news.modelgenersl> call, Response<com.example.all_news.modelgenersl> response) {
                modelgenersl=response.body();
                listew.addAll(modelgenersl.getArticles());
                sportsadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<com.example.all_news.modelgenersl> call, Throwable t) {

            }
        });
        return sportsBinding.getRoot();
    }
}