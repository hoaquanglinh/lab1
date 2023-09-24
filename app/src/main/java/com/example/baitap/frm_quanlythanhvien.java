package com.example.baitap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.baitap.adapter.adapterSach;
import com.example.baitap.adapter.adapterTV;
import com.example.baitap.dao.DAO;
import com.example.baitap.database.DBHelperSP;
import com.example.baitap.model.loaisach;
import com.example.baitap.model.sach;
import com.example.baitap.model.thanhvien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class frm_quanlythanhvien extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fac;
    thanhvien ls;
    DAO dao;
    adapterTV adapter;
    ArrayList<thanhvien> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frm_quanlythanhvien, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTV);
        fac = view.findViewById(R.id.facTV);

        dao = new DAO(getActivity(), new DBHelperSP(getActivity()));
        list = dao.danhsachTV();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new adapterTV(getContext(), list, dao);
        recyclerView.setAdapter(adapter);

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    public void addthanhvien(thanhvien tv){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
        View convertView = inflater.inflate(R.layout.item_them_thanh_vien, null);

        builder.setView(convertView);
        Dialog dialog = builder.create();
        dialog.show();

        EditText addmatv = convertView.findViewById(R.id.addmatv);
        EditText addtentv = convertView.findViewById(R.id.addhotentv);
        EditText addnamsinh = convertView.findViewById(R.id.addnamsinhtv);

        convertView.findViewById(R.id.btnaddTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int matv = Integer.parseInt(addmatv.getText().toString());
                String tentv = addtentv.getText().toString();
                int namsinh = Integer.parseInt(addnamsinh.getText().toString());

                thanhvien tv = new thanhvien(matv, tentv, namsinh);

                dao.themTV(tv);
                list.clear();
                list.addAll(dao.danhsachTV());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
    }
}