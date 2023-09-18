package com.example.baitap.model;

public class loaisach {
    int id;
    String tenloai;

    public loaisach() {
    }

    public loaisach(String tenloai) {
        this.tenloai = tenloai;
    }

    public loaisach(int id, String tenloai) {
        this.id = id;
        this.tenloai = tenloai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
}
