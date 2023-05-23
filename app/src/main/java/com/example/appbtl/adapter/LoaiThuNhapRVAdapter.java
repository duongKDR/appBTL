package com.example.appbtl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbtl.R;
import com.example.appbtl.enity.LoaiThu;

import java.util.List;

public class LoaiThuNhapRVAdapter extends RecyclerView.Adapter<LoaiThuNhapRVAdapter.LoaiThuNhapViewHolder> {
    private List<LoaiThu> mList;
    private LayoutInflater mLayoutInflater;

    public LoaiThuNhapRVAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LoaiThuNhapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = mLayoutInflater.inflate(R.layout.recylerview_loai_thu_item,parent, false);
      return new LoaiThuNhapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuNhapViewHolder holder, int position) {
        if(mList != null){
            holder.tvName.setText(mList.get(position).ten);
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    public void SetList(List<LoaiThu> mList) {
        this.mList = mList;
        notifyDataSetChanged();

    }

    public static class LoaiThuNhapViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivEdit,ivView;
        public CardView cv;
        public LoaiThuNhapViewHolder(@NonNull View itemView) {
            super(itemView);
            // Khởi tạo các thành phần giao diện trong ViewHolder tại đây
            tvName = itemView.findViewById(R.id.tvName);
            ivView = itemView.findViewById(R.id.ivView);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            cv = (CardView) itemView;
        }

        public void bindData(LoaiThu loaiThu) {
            // Gán dữ liệu vào các thành phần giao diện trong ViewHolder tại đây
        }

    }
}
