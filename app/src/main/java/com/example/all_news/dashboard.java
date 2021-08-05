package com.example.all_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.all_news.databinding.ActivityDashboardBinding;
import com.example.all_news.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class dashboard extends AppCompatActivity {
ActivityDashboardBinding binding;
fragmentadapter fragmentadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        View v=binding.getRoot();
        setContentView(v);
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentadapter=new fragmentadapter(fragmentManager,getLifecycle());
        binding.vp2.setAdapter(fragmentadapter);
        binding.tblayout.addTab(binding.tblayout.newTab().setText("general"));
        binding.tblayout.addTab(binding.tblayout.newTab().setText("business"));
        binding.tblayout.addTab(binding.tblayout.newTab().setText("sports"));
        binding.tblayout.addTab(binding.tblayout.newTab().setText("entertainment"));
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



   }



}