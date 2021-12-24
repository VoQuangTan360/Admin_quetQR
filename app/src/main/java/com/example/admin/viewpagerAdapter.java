package com.example.admin;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.admin.door.doorFragment;
import com.example.admin.list.listFragment;


public class viewpagerAdapter extends FragmentStateAdapter {


    public viewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new dkFragment();
            case 1:
                return new listFragment();
            case 2:
                return new doorFragment();

            default:
                return new dkFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
