package com.example.baitap.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

public class ViewHolderPM extends RecyclerView.ViewHolder{
    TextView maphieu, mathanhvienfkpm, masachfkpm, tienthue, trangthai, ngaythue, maloaifkpm;
    Button sua, xoa;
    public ViewHolderPM(@NonNull View itemView) {
        super(itemView);
        maphieu = itemView.findViewById(R.id.maphieu);
        mathanhvienfkpm = itemView.findViewById(R.id.mathanhvienfkpm);
        masachfkpm = itemView.findViewById(R.id.masachfkpm);
        tienthue = itemView.findViewById(R.id.tienthue);
        trangthai = itemView.findViewById(R.id.trangthai);
        ngaythue = itemView.findViewById(R.id.ngaythue);
        maloaifkpm = itemView.findViewById(R.id.maloaifkpm);
        sua = itemView.findViewById(R.id.suaPhieuMuon);
        xoa = itemView.findViewById(R.id.xoaPhieuMuon);
    }
}
