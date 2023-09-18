package com.example.baitap.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperSP extends SQLiteOpenHelper {
    public DBHelperSP(Context context){
        super(context, "PNLIB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table loaisach(maloai Integer primary key autoincrement, tenloai text not null)");
        db.execSQL("insert into loaisach values(1, 'CNTT'), (2, 'TKDH')");

        db.execSQL("create table sach(masach Integer primary key autoincrement, tensach text not null, giathue real not null, maloai Integer, foreign key(maloai) references loaisach(maloai))");
        db.execSQL("insert into sach values(1, 'Java', 10000, 1), (2, 'Vẽ', 3000, 1)");

        db.execSQL("create table thuthu(matt Integer primary key autoincrement, hoten text not null, matkhau text not null)");
        db.execSQL("insert into thuthu values(1, 'Linh', '123')");

        db.execSQL("create table thanhvien(matv Integer primary key autoincrement, hoten text not null, namsinh Integer not null)");
        db.execSQL("insert into thanhvien values(1, 'Chiến', 2004)");

        db.execSQL("create table phieumuon(mapm Integer primary key autoincrement, tienthue real not null, ngay text not null, trasach text not null, matt Integer, matv Integer, masach Integer, foreign key(matt) references thuthu(matt), foreign key(matv) references thanhvien(matv), foreign key(masach) references sach(masach))");
        db.execSQL("insert into phieumuon values(1, 20000, '10/10/2022', 'Chưa trả', 1, 1, 2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý việc nâng cấp cơ sở dữ liệu khi phiên bản đã thay đổi
    }
}