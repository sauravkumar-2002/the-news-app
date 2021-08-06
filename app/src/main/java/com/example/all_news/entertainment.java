package com.example.all_news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.all_news.databinding.FragmentEntertainmentBinding;
import com.example.all_news.databinding.FragmentSportsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link entertainment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class entertainment extends Fragment {
    FragmentEntertainmentBinding entertainmentBinding;
    modelgenersl modelgenersl;
    ArrayList<modelarticles> listew;
    entertainmentadapter entertainmentadapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public entertainment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment entertainment.
     */
    // TODO: Rename and change types and number of parameters
    public static entertainment newInstance(String param1, String param2) {
        entertainment fragment = new entertainment();
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
        entertainmentBinding= FragmentEntertainmentBinding.inflate(inflater, container, false);
        entertainmentBinding.entrcv.setLayoutManager(new LinearLayoutManager(getContext()));
        listew=new ArrayList<>();
        entertainmentadapter=new entertainmentadapter(listew,getContext());
        entertainmentBinding.entrcv.setAdapter(entertainmentadapter);
        etertainmentapiutility.get2apiinterface().getfn("04a8284df13b4d37878a479e5d57f53b","entertainment",100,"en").enqueue(new Callback<com.example.all_news.modelgenersl>() {
            @Override
            public void onResponse(Call<com.example.all_news.modelgenersl> call, Response<com.example.all_news.modelgenersl> response) {
                modelgenersl=response.body();
                listew.addAll(modelgenersl.getArticles());
                entertainmentadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<com.example.all_news.modelgenersl> call, Throwable t) {

            }
        });
        return entertainmentBinding.getRoot();
    }
}