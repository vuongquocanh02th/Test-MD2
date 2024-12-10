package model;

public abstract class Phone {
    protected int id;
    protected String tenDienThoai;
    protected double giaBan;
    protected int soLuong;
    protected String nhaSanXuat;

    public Phone(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat) {
        this.id = id;
        this.tenDienThoai = tenDienThoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public abstract String toString();
}
