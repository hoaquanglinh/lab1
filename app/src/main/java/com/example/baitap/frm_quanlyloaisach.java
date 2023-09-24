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

import com.example.baitap.adapter.adapterLoaiSach;
import com.example.baitap.dao.DAO;
import com.example.baitap.database.DBHelperSP;
import com.example.baitap.model.loaisach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class frm_quanlyloaisach extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fac;
    loaisach ls;
    DAO dao;
    adapterLoaiSach adapter;
    ArrayList<loaisach> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View converView = inflater.inflate(R.layout.fragment_frm_quanlyloaisach, container, false);

        recyclerView = converView.findViewById(R.id.recyclerView);
        fac = converView.findViewById(R.id.fac);

        dao = new DAO(getActivity(), new DBHelperSP(getActivity()));
        list = dao.danhsach();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new adapterLoaiSach(getContext(), list, dao);
        recyclerView.setAdapter(adapter);

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaisach ls = new loaisach();
                addloaisach(ls);
            }
        });
        return converView;
    }
    public void addloaisach(loaisach ls){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
        View convertView = inflater.inflate(R.layout.item_them_loai_sach, null);

        builder.setView(convertView);
        Dialog dialog = builder.create();
        dialog.show();

        EditText addmaLS = convertView.findViewById(R.id.addmaloai);
        EditText addtenLS = convertView.findViewById(R.id.addtenloai);

        convertView.findViewById(R.id.btnaddLS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mals = Integer.parseInt(addmaLS.getText().toString());
                String tenls = addtenLS.getText().toString();

                loaisach ls = new loaisach(mals, tenls);

                dao.themLS(ls);
                list.clear();
                list.addAll(dao.danhsach());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
    }
}