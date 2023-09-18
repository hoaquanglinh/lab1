package com.example.baitap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class manhinhchinh extends AppCompatActivity {
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
//                manhinhchinh.this, drawerLayout, toolbar,
//                R.string.open,
//                R.string.close);
//        drawerToggle.setDrawerIndicatorEnabled(true);
//        drawerToggle.syncState();
//        drawerLayout.addDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.quanlyphieumuon){
                    fragment = new frm_quanlyphieumuon();
                }else if(item.getItemId() == R.id.quantlyloaisach){
                    fragment = new frm_quanlyloaisach();
                }else if(item.getItemId() == R.id.quanlysach){
                    fragment = new frm_quanlysach();
                }else if(item.getItemId() == R.id.quanlythanhvien){
                    fragment = new frm_quanlythanhvien();
                }else if(item.getItemId() == R.id.top10){
                    fragment = new frm_top10();
                }else if(item.getItemId() == R.id.doanhthu){
                    fragment = new frm_doanhthu();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragment)
                        .commit();
                drawerLayout.close();
                return true;
            }
        });
    }
}