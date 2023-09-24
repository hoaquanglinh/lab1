package com.example.baitap.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperSP extends SQLiteOpenHelper {
    public DBHelperSP(Context context){
        super(context, "pn29", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table loaisach(maloai Integer primary key autoincrement, tenloai text not null)");
        db.execSQL("insert into loaisach values(1, 'CNTT'), (2, 'TKDH')");

        db.execSQL("create table sach(masach Integer primary key autoincrement, tensach text not null, giathue real not null, maloai Integer, foreign key(maloai) references loaisach(maloai))");
        db.execSQL("insert into sach values(1, 'Java', 10000, 1), (2, 'Vẽ', 3000, 1)");

        db.execSQL("create table thuthu(matt text primary key, hotentt text not null, matkhau text not null)");
        db.execSQL("insert into thuthu values('PH43159', 'Linh', '123')");

        db.execSQL("create table thanhvien(matv Integer primary key autoincrement, hotentv text not null, namsinh Integer not null)");
        db.execSQL("insert into thanhvien values(1, 'Chiến', 2004), (2, 'Phúc', 2004)");

        db.execSQL("CREATE TABLE phieumuon (" +
                "mapm INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "matt INTEGER REFERENCES thuthu(matt), " +
                "matv INTEGER REFERENCES thanhvien(matv), " +
                "masach INTEGER REFERENCES sach(masach), " +
                "tienthue REAL, " +
                "trasach TEXT NOT NULL, " +
                "ngay date)");

        db.execSQL("insert into phieumuon values(1, 'PH43159', 2, 1, 10000, 'đã trả', '10/10/2023')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ (nếu cần)
        db.execSQL("DROP TABLE IF EXISTS phieumuon");
        db.execSQL("DROP TABLE IF EXISTS loaisach");
        db.execSQL("DROP TABLE IF EXISTS sach");
        db.execSQL("DROP TABLE IF EXISTS thuthu");
        db.execSQL("DROP TABLE IF EXISTS thanhvien");

        // Tạo lại các bảng đã sửa đổi
        onCreate(db);
    }
}