package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ManHinhDangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);

        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhDangNhap.this, manhinhchinh.class);
            startActivity(intent);
        });
    }
}