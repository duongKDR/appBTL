package com.example.appbtl.enity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class LoaiThu {
    @PrimaryKey
    public int lid;
    @ColumnInfo(name = "ten")
    public String ten;

}
