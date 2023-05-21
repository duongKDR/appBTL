package com.example.appbtl.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appbtl.ui.chi.KhoanChiFragment;
import com.example.appbtl.ui.chi.LoaiChiFragment;

public class ChiPageAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;

    public ChiPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return KhoanChiFragment.newInstance();
        } else {
            return LoaiChiFragment.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
