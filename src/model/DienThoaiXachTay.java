package model;

public class DienThoaiXachTay extends DienThoai {
    private String quocGiaXachTay;
    private String trangThai;

    public DienThoaiXachTay(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, String quocGiaXachTay, String trangThai) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Tên: %s, Giá: %.2f, Số lượng: %d, NSX: %s, Quốc gia: %s, Trạng thái: %s",
                id, tenDienThoai, giaBan, soLuong, nhaSanXuat, quocGiaXachTay, trangThai);
    }
}

