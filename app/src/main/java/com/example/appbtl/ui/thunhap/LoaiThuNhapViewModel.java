package com.example.appbtl.ui.thunhap;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.appbtl.Repository.LoaiThuRepository;
import com.example.appbtl.enity.LoaiThu;

import java.util.List;

public class LoaiThuNhapViewModel extends AndroidViewModel {
    private LoaiThuRepository loaiThuRepository;


    private LiveData<List<LoaiThu>> mLoaiThu;
    public LoaiThuNhapViewModel(@NonNull Application application) {
        super(application);
        loaiThuRepository = new LoaiThuRepository(application);
        mLoaiThu = loaiThuRepository.getAllLoaiThu();
    }


    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mLoaiThu;
    }

  public void insert(LoaiThu loaiThu){
      loaiThuRepository.insert(loaiThu);
  }
}