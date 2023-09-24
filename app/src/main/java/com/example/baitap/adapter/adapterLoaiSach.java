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
import android.widget.inline.InlineContentView;

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
        holder.maloai.setText(String.valueOf(list.get(position).getId()));
        holder.tenls.setText(list.get(position).getTenloai());

        holder.xoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có chắc chắn muốn xóa không?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = list.get(holder.getAdapterPosition()).getId();
                        dao.xoaLS(id);
                        list.clear();
                        list.addAll(dao.danhsach());
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

        holder.suals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaisach ls = list.get(holder.getAdapterPosition());
                update(ls);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(loaisach ls){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View convertView = inflater.inflate(R.layout.item_update_loai_sach, null);
        builder.setView(convertView);
        Dialog dialog = builder.create();
        dialog.show();

        EditText udtenloai = convertView.findViewById(R.id.udtenloai);

        udtenloai.setText(ls.getTenloai());

        convertView.findViewById(R.id.btnupdateLS).setOnClickListener(v -> {
            String tenloai = udtenloai.getText().toString();

            loaisach sp1 = new loaisach(ls.getId(), tenloai);

            dao.suaLS(sp1);
            list.clear();
            list.addAll(dao.danhsach());
            notifyDataSetChanged();
            dialog.dismiss();
        });
    }
}
