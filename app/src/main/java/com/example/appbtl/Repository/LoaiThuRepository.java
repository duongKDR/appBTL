package com.example.appbtl.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.appbtl.associative.AppDatabase;
import com.example.appbtl.associative.LoaiThuAsso;
import com.example.appbtl.enity.LoaiThu;

import java.util.List;

public class LoaiThuRepository {
    private LoaiThuAsso mLoaiThuDao;
    private LiveData<List<LoaiThu>> mLoaiThu;

    public LoaiThuRepository(Application application) {
        AppDatabase db = AppDatabase.getData(application);
        mLoaiThuDao = db.loaiThuAsso();
        mLoaiThu = mLoaiThuDao.findAll();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mLoaiThu;
    }

    public void insert(LoaiThu loaiThu) {
        new InsertAsyncTask(mLoaiThuDao).execute(loaiThu);
    }

    private static class InsertAsyncTask extends AsyncTask<LoaiThu, Void, Void> {
        private LoaiThuAsso mLoaiThuDao;

        public InsertAsyncTask(LoaiThuAsso loaiThuDao) {
            this.mLoaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
}
