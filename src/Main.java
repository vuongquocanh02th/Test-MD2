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
                    break;
                case 2:
                    // Gọi hàm xóa
                    break;
                case 3:
                    // Gọi hàm hiển thị danh sách
                    break;
                case 4:
                    // Gọi hàm tìm kiếm
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
