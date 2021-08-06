package com.example.all_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        setSupportActionBar(binding.toolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchtoolbar,menu);
        MenuItem menuItem=menu.findItem(R.id.actiosearch);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("Type here to Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}