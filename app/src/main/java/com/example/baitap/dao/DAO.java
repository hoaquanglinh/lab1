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

import java.sql.ClientInfoStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAO {
    Context context;
    DBHelperSP dbHelperSP;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DAO(Context context, DBHelperSP dbHelperSP) {
        this.context = context;
        this.dbHelperSP = dbHelperSP;
    }

    // ///////////////////////////////////////// Loại sách  //////////////////////////////////////////////// //

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

        values.put("tenloai", ls.getTenloai());

        long check = db.insert("loaisach", null, values);

        if (check > 0) {
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Thêm thất bại",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void suaLS(loaisach ls){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

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

    // ///////////////////////////////////////// THỦ THƯ  //////////////////////////////////////////////// //

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

    public void themThuThu(thuthu tt){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("matt", tt.getMaTT());
        values.put("hotentt", tt.getHoTenTT());
        values.put("matkhau", tt.getMatKhau());

        long check = db.insert("thuthu", null, values);

        if (check > 0)
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void suaThuThu(thuthu tt){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("matt", tt.getMaTT());
        values.put("hotentt", tt.getHoTenTT());
        values.put("matkhau", tt.getMatKhau());

        long check = db.update("thuthu", values, "matt =?", new String[]{String.valueOf(tt.getMaTT())});

        if (check > 0)
            Toast.makeText(context, "Sửa thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Sửa thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void xoaThuThu(int matt){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        long check = db.delete("thuthu", "matt = ?", new String[]{String.valueOf(matt)});

        if (check > 0){
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    // ///////////////////////////////////////// SÁCH  //////////////////////////////////////////////// //

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

    public void themSach(sach sach){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("masach", sach.getMasach());
        values.put("tensach", sach.getTensach());
        values.put("giathue", sach.getGiaThue());
        values.put("maloai", sach.getMaloai());

        long check = db.insert("sach", null, values);

        if (check > 0)
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void suaSach(sach sach){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("tensach", sach.getTensach());
        values.put("giathue", sach.getGiaThue());
        values.put("maloai", sach.getMaloai());

        long check = db.update("sach", values, "masach =?", new String[]{String.valueOf(sach.getMaloai())});

        if (check > 0)
            Toast.makeText(context, "Sửa thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Sửa thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void xoaSach(int masach){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        long check = db.delete("sach", "masach = ?", new String[]{String.valueOf(masach)});

        if (check > 0){
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }


    // ///////////////////////////////////////// PHIẾU MƯỢN //////////////////////////////////////////////// //

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

    public void themPM(phieumuon pm){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("matt", pm.getTentt());
        values.put("matv", pm.getThanhvien());
        values.put("masach", pm.getTensach());
        values.put("tienthue", pm.getTienthue());
        values.put("trasach", pm.getTrangThai());
        values.put("ngay", sdf.format(pm.getNgaythue()));

        long check = db.insert("phieumuon", null, values);

        if (check > 0) {
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Thêm thất bại",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void suaPM(phieumuon pm){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("matt", pm.getTentt());
        values.put("matv", pm.getThanhvien());
        values.put("masach", pm.getTensach());
        values.put("tienthue", pm.getTienthue());
        values.put("trasach", pm.getTrangThai());
        values.put("ngay", sdf.format(pm.getNgaythue()));

        long check = db.update("phieumuon", values, "mapm =?", new String[]{String.valueOf(pm.getId())});

        if (check > 0) {
            Toast.makeText(context, "Sửa thành công",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Sửa thất bại",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void xoaPM(int mapm){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        long check = db.delete("phieumuon", "mapm = ?", new String[]{String.valueOf(mapm)});

        if (check > 0){
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    // ///////////////////////////////////////// THÀNH VIÊN  //////////////////////////////////////////////// //
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

    public void themTV(thanhvien tv){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("matv", tv.getMatv());
        values.put("hotentv", tv.getHoTen());
        values.put("namsinh", tv.getNamSinh());

        long check = db.insert("thanhvien", null, values);

        if (check > 0)
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void suaTV(thanhvien tv){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("hotentv", tv.getHoTen());
        values.put("namsinh", tv.getNamSinh());

        long check = db.update("thanhvien", values, "matv =?", new String[]{String.valueOf(tv.getMatv())});

        if (check > 0)
            Toast.makeText(context, "Sửa thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Sửa thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void xoaTV(int matv){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        long check = db.delete("thanhvien", "matv = ?", new String[]{String.valueOf(matv)});

        if (check > 0){
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }

}
