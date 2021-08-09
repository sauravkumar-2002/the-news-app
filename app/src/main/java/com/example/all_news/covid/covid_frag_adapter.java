package com.example.all_news.covid;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.all_news.business;
import com.example.all_news.entertainment;
import com.example.all_news.general;
import com.example.all_news.sports;

public class covid_frag_adapter extends FragmentStateAdapter {
    public covid_frag_adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new vaccine();
        }

        return new updates();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
