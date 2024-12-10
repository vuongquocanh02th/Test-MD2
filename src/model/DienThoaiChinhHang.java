package model;

public class DienThoaiChinhHang extends DienThoai {
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Tên: %s, Giá: %.2f, Số lượng: %d, NSX: %s, Bảo hành: %d ngày, Phạm vi: %s",
                id, tenDienThoai, giaBan, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);
    }
}
