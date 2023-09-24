package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitap.database.DBHelperSP;
import com.example.baitap.model.thuthu;

public class ManHinhDangNhap extends AppCompatActivity {
    DBHelperSP dbHelperSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);

        EditText username = findViewById(R.id.edtUserName);
        EditText password = findViewById(R.id.edtPassword);

        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            String taikhoan = username.getText().toString();
            String matkhau = password.getText().toString();

            dbHelperSP = new DBHelperSP(ManHinhDangNhap.this);
            thuthu user = dbHelperSP.getUser(taikhoan, matkhau);

            if (user != null) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ManHinhDangNhap.this, manhinhchinh.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}