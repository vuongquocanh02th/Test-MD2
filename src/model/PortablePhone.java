package model;

public class PortablePhone extends Phone {
    private String quocGiaXachTay;
    private String trangThai;

    public PortablePhone(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, String quocGiaXachTay, String trangThai) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return String.format(" %d, %s, %.2f, %d, %s, %s, %s",
                id, tenDienThoai, giaBan, soLuong, nhaSanXuat, quocGiaXachTay, trangThai);
    }
}

