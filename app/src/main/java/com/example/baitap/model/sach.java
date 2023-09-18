package com.example.baitap.model;

public class sach {
    int masach;
    String tensach;
    Double giaThue;
    int maloai;

    public sach() {
    }

    public sach(String tensach, Double giaThue, int maloai) {
        this.tensach = tensach;
        this.giaThue = giaThue;
        this.maloai = maloai;
    }

    public sach(int masach, String tensach, Double giaThue, int maloai) {
        this.masach = masach;
        this.tensach = tensach;
        this.giaThue = giaThue;
        this.maloai = maloai;
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public Double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(Double giaThue) {
        this.giaThue = giaThue;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }
}
