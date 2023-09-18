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

import java.util.ArrayList;

public class adapterLoaiSach extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<loaisach> list;
    DAO dao;

    public adapterLoaiSach(Context context, ArrayList<loaisach> list, DAO dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_loaisach, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tenls.setText(list.get(position).getTenloai());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
