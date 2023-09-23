package com.example.baitap.dao;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.baitap.database.DBHelperSP;
import com.example.baitap.model.loaisach;
import com.example.baitap.model.phieumuon;
import com.example.baitap.model.sach;
import com.example.baitap.model.thanhvien;
import com.example.baitap.model.thuthu;

import java.util.ArrayList;

public class DAO {
    Context context;
    DBHelperSP dbHelperSP;

    public DAO(Context context, DBHelperSP dbHelperSP) {
        this.context = context;
        this.dbHelperSP = dbHelperSP;
    }

    // Loại sách

    public ArrayList<loaisach> danhsach(){
        ArrayList<loaisach> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from loaisach", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new loaisach(
                            cursor.getInt(0),
                            cursor.getString(1)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }

    public void themLS(loaisach ls){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maloai", ls.getId());
        values.put("tenloai", ls.getTenloai());

        long check = db.insert("loaisach", null, values);

        if (check > 0)
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void suaLS(loaisach ls){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maloai", ls.getId());
        values.put("tenloai", ls.getTenloai());

        long check = db.update("loaisach", values, "maloai =?", new String[]{String.valueOf(ls.getId())});

        if (check > 0)
            Toast.makeText(context, "Sửa thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Sửa thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void xoaLS(int maloai){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        long check = db.delete("loaisach", "maloai = ?", new String[]{String.valueOf(maloai)});

        if (check > 0){
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<thuthu> danhsachTT(){
        ArrayList<thuthu> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from thuthu", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new thuthu(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }

    public ArrayList<sach> danhsachSach(){
        ArrayList<sach> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from sach", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new sach(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getDouble(2),
                            cursor.getInt(3)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }

    public ArrayList<phieumuon> danhsachPhieuMuon(){
        ArrayList<phieumuon> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from phieumuon", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new phieumuon(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getInt(3),
                            cursor.getDouble(4),
                            cursor.getString(5),
                            cursor.getString(6)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }

    public ArrayList<thanhvien> danhsachTV(){
        ArrayList<thanhvien> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from thanhvien", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new thanhvien(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getInt(2)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }
}
