package com.example.baitap.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;
import com.example.baitap.dao.DAO;
import com.example.baitap.model.loaisach;
import com.example.baitap.model.sach;

import java.util.ArrayList;

public class adapterSach extends RecyclerView.Adapter<ViewHolderSach>{
    private Context context;
    private ArrayList<sach> list;
    DAO dao;

    public adapterSach(Context context, ArrayList<sach> list, DAO dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }

    @NonNull
    @Override
    public ViewHolderSach onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_sach, null);
        return new ViewHolderSach(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSach holder, int position) {
        if (position < list.size()) {
            holder.tens.setText(list.get(position).getTensach());
            holder.giathue.setText(String.valueOf(list.get(position).getGiaThue()));

            int maLoai = list.get(position).getMaloai();
            loaisach loaiSach = findLoaiSachByMaLoai(maLoai);

            if (loaiSach != null) {
                holder.maloai.setText(loaiSach.getTenloai());
            } else {
                holder.maloai.setText("");
            }
        }
    }

    // Hàm tìm kiếm loại sách bằng mã loại
    private loaisach findLoaiSachByMaLoai(int maLoai) {
        for (loaisach loaiSach : dao.danhsach()) {
            if (loaiSach.getId() == maLoai) {
                return loaiSach;
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
