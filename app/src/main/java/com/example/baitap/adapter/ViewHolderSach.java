package com.example.baitap.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

public class ViewHolderSach extends RecyclerView.ViewHolder{
    TextView tens, giathue, maloaifksach;
    Button suas, xoas;
    public ViewHolderSach(@NonNull View itemView) {
        super(itemView);
        tens = itemView.findViewById(R.id.tensach);
        giathue = itemView.findViewById(R.id.giathue);
        maloaifksach = itemView.findViewById(R.id.maloaifksach);
        suas = itemView.findViewById(R.id.suasach);
        xoas = itemView.findViewById(R.id.xoasach);
    }
}
