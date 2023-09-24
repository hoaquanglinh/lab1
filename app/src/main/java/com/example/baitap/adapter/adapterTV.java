package com.example.baitap.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;
import com.example.baitap.dao.DAO;
import com.example.baitap.model.loaisach;
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

        holder.xoatv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có chắc chắn muốn xóa không?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = list.get(holder.getAdapterPosition()).getMatv();
                        dao.xoaTV(id);
                        list.clear();
                        list.addAll(dao.danhsachTV());
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        holder.suatv.setOnClickListener(v -> {
            thanhvien tv = list.get(holder.getAdapterPosition());
            updatetv(tv);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updatetv(thanhvien tv) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View convertView = inflater.inflate(R.layout.item_update_thanh_vien, null);
        builder.setView(convertView);
        Dialog dialog = builder.create();
        dialog.show();

        EditText udhotentv = convertView.findViewById(R.id.udtentv);
        EditText udnamsinhtv = convertView.findViewById(R.id.udnamsinhtv);

        udhotentv.setText(tv.getHoTen());
        udnamsinhtv.setText(String.valueOf(tv.getNamSinh()));

        convertView.findViewById(R.id.btnupdateTV).setOnClickListener(v -> {
            String hotentv = udhotentv.getText().toString();
            int namsinhtv = Integer.parseInt(udnamsinhtv.getText().toString());

            thanhvien tv1 = new thanhvien(tv.getMatv(), hotentv, namsinhtv);

            dao.suaTV(tv1);
            list.clear();
            list.addAll(dao.danhsachTV());
            notifyDataSetChanged();
            dialog.dismiss();
        });
    }
}
