package com.example.all_news.covid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.all_news.R;
import com.example.all_news.databinding.FragmentCovidHomeBinding;
import com.example.all_news.databinding.FragmentHomeBinding;
import com.example.all_news.fragmentadapter;
import com.google.android.material.tabs.TabLayout;


public class covid_home extends Fragment {
    FragmentCovidHomeBinding binding;
    covid_frag_adapter covidFragAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentCovidHomeBinding.inflate(inflater,container,false);
        covidFragAdapter=new covid_frag_adapter(getChildFragmentManager(),getLifecycle());
        binding.vp2.setAdapter(covidFragAdapter);
        binding.tblayout.addTab(binding.tblayout.newTab().setText(" covid updates"));
        binding.tblayout.addTab(binding.tblayout.newTab().setText("vaccination updates"));
        binding.tblayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.vp2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tblayout.selectTab(binding.tblayout.getTabAt(position));
            }


        });

        return binding.getRoot();
    }
}