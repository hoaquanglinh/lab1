package com.example.baitap.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView maloai, tenls;
    Button suals, xoals;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        maloai = itemView.findViewById(R.id.maloai);
        tenls = itemView.findViewById(R.id.tenloaisach);
        suals = itemView.findViewById(R.id.sualoaisach);
        xoals = itemView.findViewById(R.id.xoaloaisach);
    }
}
