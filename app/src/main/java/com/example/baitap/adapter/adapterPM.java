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
import com.example.baitap.model.phieumuon;
import com.example.baitap.model.sach;
import com.example.baitap.model.thanhvien;

import java.util.ArrayList;

public class adapterPM extends RecyclerView.Adapter<ViewHolderPM>{
    private Context context;
    private ArrayList<phieumuon> list;
    DAO dao;

    public adapterPM(Context context, ArrayList<phieumuon> list, DAO dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }
    @NonNull
    @Override
    public ViewHolderPM onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_phieumuon, parent, false);
        return new ViewHolderPM(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPM holder, int position) {
        if (position < list.size()) {
            holder.maphieu.setText(String.valueOf(list.get(position).getId()));
            holder.ngaythue.setText(list.get(position).getNgaythue());
            holder.trangthai.setText(list.get(position).getTrangThai());
            holder.tienthue.setText(String.valueOf(list.get(position).getTienthue()));

            int maLoai = list.get(position).getTenloai();
            loaisach loaiSach = this.findLoaiSachByMaLoai(maLoai);

            if (loaiSach != null) {
                holder.maloaifkpm.setText(loaiSach.getTenloai());
            } else {
                holder.maloaifkpm.setText("");
            }

            int maSach = list.get(position).getTensach();
            sach sach = this.findSachByMaSach(maSach);

            if (sach != null) {
                holder.masachfkpm.setText(sach.getTensach());
            } else {
                holder.masachfkpm.setText("");
            }

            int maTV = list.get(position).getThanhvien();
            thanhvien tv = this.findTenBYMaTV(maTV);

            if (tv != null) {
                holder.mathanhvienfkpm.setText(tv.getHoTen());
            } else {
                holder.mathanhvienfkpm.setText("");
            }
        }
    }

    private loaisach findLoaiSachByMaLoai(int maLoai) {
        for (loaisach loaiSach : dao.danhsach()) {
            if (loaiSach.getId() == maLoai) {
                return loaiSach;
            }
        }
        return null;
    }

    private sach findSachByMaSach(int maSach){
        for (sach x : dao.danhsachSach()){
            if (x.getMasach() == maSach){
                return x;
            }
        }
        return null;
    }

    private thanhvien findTenBYMaTV(int maTV){
        for (thanhvien tv : dao.danhsachTV()){
            if (tv.getMatv() == maTV){
                return tv;
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
