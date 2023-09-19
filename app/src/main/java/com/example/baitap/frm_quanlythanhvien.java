package com.example.baitap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baitap.adapter.adapterSach;
import com.example.baitap.adapter.adapterTV;
import com.example.baitap.dao.DAO;
import com.example.baitap.database.DBHelperSP;
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
}