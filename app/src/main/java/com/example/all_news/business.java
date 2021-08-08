package com.example.all_news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.all_news.databinding.FragmentBusinessBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link business#newInstance} factory method to
 * create an instance of this fragment.
 */
public class business extends Fragment {
    modelgenersl modelgenersl;
FragmentBusinessBinding businessBinding;
ArrayList<modelarticles> listew;
businessadapter businessadapter;
String languageselected,countryselected="in";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public business() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment business.
     */
    // TODO: Rename and change types and number of parameters
    public static business newInstance(String param1, String param2) {
        business fragment = new business();
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
        businessBinding=FragmentBusinessBinding.inflate(inflater, container, false);
        businessBinding.recvbusiness.setLayoutManager(new LinearLayoutManager(getActivity()));
        businessBinding.pleasewait.setVisibility(View.VISIBLE);
        listew=new ArrayList<>();
        dashboard dashboard=(dashboard)getActivity();
        languageselected=dashboard.getMydata();
        Toast.makeText(getContext(),languageselected,Toast.LENGTH_SHORT).show();
        businessadapter=new businessadapter(listew,getContext());
        businessBinding.recvbusiness.setAdapter(businessadapter);
        businessapputility businessapputility=new businessapputility();
        businessapputility.getapiinterface().getfn("04a8284df13b4d37878a479e5d57f53b","business",100,languageselected).enqueue(new Callback<modelgenersl>() {
            @Override
            public void onResponse(Call<modelgenersl> call, Response<modelgenersl> response) {
                businessBinding.pleasewait.setVisibility(View.GONE);
                modelgenersl=response.body();
                listew.addAll(modelgenersl.getArticles());
               businessadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<modelgenersl> call, Throwable t) {

            }
        });





        return businessBinding.getRoot();
    }
}