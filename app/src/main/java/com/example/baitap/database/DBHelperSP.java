package com.example.baitap.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperSP extends SQLiteOpenHelper {
    public DBHelperSP(Context context){
        super(context, "PNLib", null, 3);
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

        db.execSQL("CREATE TABLE phieumuon (" +
                "mapm INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "matv INTEGER REFERENCES thanhvien(matv), " +
                "masach INTEGER REFERENCES sach(masach), " +
                "maloai INTEGER REFERENCES loaisach(maloai), " +
                "tienthue REAL, " +
                "trasach TEXT NOT NULL, " +
                "ngay TEXT NOT NULL)");

        db.execSQL("insert into phieumuon values(1, 1, 2, 2, 10000, 'chưa trả', '10/10/2023')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý việc nâng cấp cơ sở dữ liệu khi phiên bản đã thay đổi
    }
}