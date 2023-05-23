
package com.example.appbtl.ui.thunhap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbtl.R;
import com.example.appbtl.adapter.LoaiThuNhapRVAdapter;
import com.example.appbtl.enity.LoaiThu;

import java.util.List;

public class LoaiThuNhapFragment extends Fragment {
    private RecyclerView recyclerView;
    private LoaiThuNhapRVAdapter mAdapter;
    private LoaiThuNhapViewModel mViewModel;

    public static LoaiThuNhapFragment newInstance() {
        return new LoaiThuNhapFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loai_thu_nhap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = new LoaiThuNhapRVAdapter(getActivity());
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiThuNhapViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getAllLoaiThu().observe(getActivity(), new Observer<List<LoaiThu>>() {
            @Override
            public void onChanged(List<LoaiThu> loaiThus) {
                mAdapter.SetList(loaiThus);
            }
        });

    }

}