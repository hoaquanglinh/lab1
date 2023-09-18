package com.example.baitap.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

public class ViewHolderPM extends RecyclerView.ViewHolder{
    TextView maphieu, thanhvien, tensach, tienthue, trangthai, ngaythue, tenloai;
    Button sua, xoa;
    public ViewHolderPM(@NonNull View itemView) {
        super(itemView);
        maphieu = itemView.findViewById(R.id.maphieu);
        thanhvien = itemView.findViewById(R.id.thanhvien);
        tensach = itemView.findViewById(R.id.masach);
        tienthue = itemView.findViewById(R.id.tienthue);
        trangthai = itemView.findViewById(R.id.trangthai);
        ngaythue = itemView.findViewById(R.id.ngaythue);
        tenloai = itemView.findViewById(R.id.maloai);
        sua = itemView.findViewById(R.id.suaPhieuMuon);
        xoa = itemView.findViewById(R.id.xoaPhieuMuon);
    }
}
