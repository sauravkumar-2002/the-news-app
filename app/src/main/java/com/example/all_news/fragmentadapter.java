package com.example.all_news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class fragmentadapter extends FragmentStateAdapter {

    public fragmentadapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new business();
            case 2:
                return new sports();

            case 3:
                return new entertainment();
        }

        return new general();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
