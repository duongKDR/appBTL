package com.example.appbtl.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appbtl.ui.thunhap.KhoanThuNhapFragment;
import com.example.appbtl.ui.thunhap.LoaiThuNhapFragment;

public class ThuPageAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;

    public ThuPageAdapter(@NonNull FragmentActivity fragmentActivity) {

            super(fragmentActivity);
        }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return KhoanThuNhapFragment.newInstance();
        } else {
            return LoaiThuNhapFragment.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
