package com.example.appbtl.ui.thunhap;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appbtl.R;

public class KhoanThuNhapFragment extends Fragment {

    private KhoanThuNhapViewModel mViewModel;

    public static KhoanThuNhapFragment newInstance() {
        return new KhoanThuNhapFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_khoan_thu_nhap, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanThuNhapViewModel.class);
        // TODO: Use the ViewModel
    }

}