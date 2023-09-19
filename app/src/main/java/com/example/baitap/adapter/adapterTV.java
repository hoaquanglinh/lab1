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
import com.example.baitap.model.sach;
import com.example.baitap.model.thanhvien;

import java.util.ArrayList;

public class adapterTV extends RecyclerView.Adapter<ViewHolderTV>{
    private Context context;
    private ArrayList<thanhvien> list;
    DAO dao;

    public adapterTV(Context context, ArrayList<thanhvien> list, DAO dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }

    @NonNull
    @Override
    public ViewHolderTV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_thanhvien, null);
        return new ViewHolderTV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTV holder, int position) {
        holder.matv.setText(String.valueOf(list.get(position).getMatv()));
        holder.hotentv.setText(list.get(position).getHoTen());
        holder.namsinhtv.setText(String.valueOf(list.get(position).getNamSinh()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
