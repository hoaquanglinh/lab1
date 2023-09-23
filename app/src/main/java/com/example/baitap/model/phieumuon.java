package com.example.baitap.model;

import java.util.Date;

public class phieumuon {
    int id;
    String tentt;
    int thanhvien;
    int tensach;
    Double tienthue;
    String trangThai;
    String ngaythue;

    public phieumuon() {
    }

    public phieumuon(String tentt, int thanhvien, int tensach, Double tienthue, String trangThai, String ngaythue) {
        this.tentt = tentt;
        this.thanhvien = thanhvien;
        this.tensach = tensach;
        this.tienthue = tienthue;
        this.trangThai = trangThai;
        this.ngaythue = ngaythue;
    }

    public phieumuon(int id, String tentt, int thanhvien, int tensach, Double tienthue, String trangThai, String ngaythue) {
        this.id = id;
        this.tentt = tentt;
        this.thanhvien = thanhvien;
        this.tensach = tensach;
        this.tienthue = tienthue;
        this.trangThai = trangThai;
        this.ngaythue = ngaythue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTentt() {
        return tentt;
    }

    public void setTentt(String tentt) {
        this.tentt = tentt;
    }

    public int getThanhvien() {
        return thanhvien;
    }

    public void setThanhvien(int thanhvien) {
        this.thanhvien = thanhvien;
    }

    public int getTensach() {
        return tensach;
    }

    public void setTensach(int tensach) {
        this.tensach = tensach;
    }

    public Double getTienthue() {
        return tienthue;
    }

    public void setTienthue(Double tienthue) {
        this.tienthue = tienthue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(String ngaythue) {
        this.ngaythue = ngaythue;
    }
}
