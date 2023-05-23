package com.example.appbtl.associative;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.appbtl.enity.LoaiThu;

@Database( entities = {LoaiThu.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LoaiThuAsso loaiThuAsso();
    public static AppDatabase INSTANCE;
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onOpen(db);
        new PolulateData((LoaiThuAsso) INSTANCE).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PolulateData((LoaiThuAsso)INSTANCE).execute();
        }
    };

    public static class PolulateData extends AsyncTask<Void, Void, Void> {
        private LoaiThuAsso loaiThuDao;

        public PolulateData(LoaiThuAsso loaiThuDao) {
            this.loaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaiThus = new String[]{"Luong", "Co phieu", "Lam Them", "Thuong"};
            for (String it : loaiThus) {
                LoaiThu lt = new LoaiThu();
                lt.ten = it;
                loaiThuDao.insert(lt);
            }
            return null;
        }


    }

    public static AppDatabase getData(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "personal_db")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }
}