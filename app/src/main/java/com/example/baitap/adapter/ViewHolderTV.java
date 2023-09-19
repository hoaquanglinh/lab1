package com.example.baitap.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

public class ViewHolderTV extends RecyclerView.ViewHolder{
    TextView hotentv, matv, namsinhtv;
    Button suatv, xoatv;
    public ViewHolderTV(@NonNull View itemView) {
        super(itemView);
        matv = itemView.findViewById(R.id.matv);
        hotentv = itemView.findViewById(R.id.hotentv);
        namsinhtv = itemView.findViewById(R.id.namsinhtv);
        suatv = itemView.findViewById(R.id.suaTV);
        xoatv = itemView.findViewById(R.id.xoaTV);
    }
}
