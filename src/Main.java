import controller.DienThoaiManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Quản lý điện thoại ===");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Gọi hàm thêm mới
                    DienThoaiManager.themMoiDienThoai();
                    break;
                case 2:
                    // Gọi hàm xóa
                    System.out.print("Chọn loại điện thoại cần xóa (1: Chính hãng, 2: Xách tay): ");
                    int loaiXoa = scanner.nextInt();
                    scanner.nextLine();
                    String fileXoa = loaiXoa == 1 ? "chinhhang.csv" : "xachtay.csv";
                    DienThoaiManager.xoaDienThoai(fileXoa);
                    break;
                case 3:
                    // Gọi hàm hiển thị danh sách
                    System.out.print("Chọn loại điện thoại muốn xem (1: Chính hãng, 2: Xách tay): ");
                    int loaiHienThi = scanner.nextInt();
                    scanner.nextLine();
                    String fileHienThi = loaiHienThi == 1 ? "chinhhang.csv" : "xachtay.csv";
                    DienThoaiManager.hienThiDanhSach(fileHienThi);
                    break;
                case 4:
                    // Gọi hàm tìm kiếm
                    System.out.print("Nhập từ khóa tìm kiếm: ");
                    String keyword = scanner.nextLine();
                    System.out.print("Tìm trong (1: Chính hãng, 2: Xách tay): ");
                    int loaiTimKiem = scanner.nextInt();
                    scanner.nextLine();
                    String fileTimKiem = loaiTimKiem == 1 ? "chinhhang.csv" : "xachtay.csv";
                    DienThoaiManager.timKiem(fileTimKiem, keyword);
                    break;
                case 5:
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
        scanner.close();
    }
}
