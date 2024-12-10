package controller;

import model.GenuinePhone;
import model.PortablePhone;

import java.io.*;
import java.util.Scanner;

public class PhoneManager {
    private static int currentId = 1;

    public static void themMoiDienThoai() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chọn loại điện thoại muốn thêm:");
        System.out.println("1. Điện thoại chính hãng");
        System.out.println("2. Điện thoại xách tay");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (choice == 1) {
                System.out.print("Tên điện thoại: ");
                String tenDienThoai = scanner.nextLine();

                System.out.print("Giá bán: ");
                double giaBan = Double.parseDouble(scanner.nextLine());

                System.out.print("Số lượng: ");
                int soLuong = Integer.parseInt(scanner.nextLine());

                System.out.print("Nhà sản xuất: ");
                String nhaSanXuat = scanner.nextLine();

                System.out.print("Thời gian bảo hành (ngày, tối đa 730): ");
                int thoiGianBaoHanh = Integer.parseInt(scanner.nextLine());

                System.out.print("Phạm vi bảo hành (Toan Quoc / Quoc Te): ");
                String phamViBaoHanh = scanner.nextLine();

                if (giaBan <= 0 || soLuong <= 0 || thoiGianBaoHanh <= 0 || thoiGianBaoHanh > 730 ||
                        (!phamViBaoHanh.equals("Toan Quoc") && !phamViBaoHanh.equals("Quoc Te"))) {
                    System.out.println("Dữ liệu nhập không hợp lệ.");
                    return;
                }

                GenuinePhone chinhHang = new GenuinePhone(currentId++, tenDienThoai, giaBan, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);
                ghiVaoFile("chinhhang.csv", chinhHang.toString());
            } else if (choice == 2) {
                System.out.print("Tên điện thoại: ");
                String tenDienThoai = scanner.nextLine();

                System.out.print("Giá bán: ");
                double giaBan = Double.parseDouble(scanner.nextLine());

                System.out.print("Số lượng: ");
                int soLuong = Integer.parseInt(scanner.nextLine());

                System.out.print("Nhà sản xuất: ");
                String nhaSanXuat = scanner.nextLine();

                System.out.print("Quốc gia xách tay (không được là Viet Nam): ");
                String quocGiaXachTay = scanner.nextLine();

                System.out.print("Trạng thái (Da sua chua / Chua sua chua): ");
                String trangThai = scanner.nextLine();

                if (giaBan <= 0 || soLuong <= 0 || quocGiaXachTay.equalsIgnoreCase("Viet Nam") ||
                        (!trangThai.equals("Da sua chua") && !trangThai.equals("Chua sua chua"))) {
                    System.out.println("Dữ liệu nhập không hợp lệ.");
                    return;
                }

                PortablePhone xachTay = new PortablePhone(currentId++, tenDienThoai, giaBan, soLuong, nhaSanXuat, quocGiaXachTay, trangThai);
                ghiVaoFile("xachtay.csv", xachTay.toString());
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi nhập liệu: " + e.getMessage());
        }
    }

    private static void ghiVaoFile(String fileName, String data) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data + "\n");
            System.out.println("Thêm mới thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public static void xoaDienThoai(String fileName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID điện thoại cần xóa: ");
        int idXoa = scanner.nextInt();
        scanner.nextLine();

        File inputFile = new File(fileName);
        File tempFile = new File("temp.csv");

        boolean timThay = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Tách lấy ID từ chuỗi
                String[] fields = line.split(",");
                String idField = fields[0].replaceAll("[^0-9]", "");
                int id = Integer.parseInt(idField);

                if (id == idXoa) {
                    timThay = true;
                    System.out.println("Đã tìm thấy điện thoại có ID " + idXoa + ". Xóa thành công.");
                } else {
                    writer.write(line + "\n");
                }
            }

            if (timThay) {
                try {
                    reader.close();
                    writer.close();

                    if (inputFile.delete()) {
                        System.out.println("File gốc đã được xóa thành công.");

                        if (tempFile.renameTo(inputFile)) {
                            System.out.println("File tạm đã được thay thế thành file gốc.");
                        } else {
                            System.out.println("Lỗi khi đổi tên file tạm.");
                        }
                    } else {
                        System.out.println("Không thể xóa file gốc. Kiểm tra quyền truy cập.");
                    }
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng file: " + e.getMessage());
                }
            } else {
                System.out.println("ID không tồn tại. Không có thay đổi nào được thực hiện.");

                tempFile.delete();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi xóa: " + e.getMessage());
        }


        if (timThay && tempFile.renameTo(inputFile)) {
            System.out.println("Cập nhật danh sách thành công!");
        }
    }
    public static void hienThiDanhSach(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
    public static void timKiem(String fileName, String keyword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi tìm kiếm: " + e.getMessage());
        }
    }

}

