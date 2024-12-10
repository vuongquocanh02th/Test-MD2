package model;

public class GenuinePhone extends Phone {
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public GenuinePhone(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f, %d, %s, %d ngày, %s",
                id, tenDienThoai, giaBan, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);
    }
}
