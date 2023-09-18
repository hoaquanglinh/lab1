package com.example.baitap.dao;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.baitap.database.DBHelperSP;
import com.example.baitap.model.loaisach;
import com.example.baitap.model.phieumuon;
import com.example.baitap.model.sach;

import java.util.ArrayList;

public class DAO {
    Context context;
    DBHelperSP dbHelperSP;

    public DAO(Context context, DBHelperSP dbHelperSP) {
        this.context = context;
        this.dbHelperSP = dbHelperSP;
    }

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
}