import java.util.Scanner;

 class SinhVien {
    private int maSV;
    private String hoTen;
    private float diemLT;
    private float diemTH;

    // Constructor mặc định
    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }

    // Constructor nhận đầy đủ thông tin
    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    // Getter và setter cho các thuộc tính
    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        this.diemLT = diemLT;
    }

    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        this.diemTH = diemTH;
    }

    // Phương thức tính điểm trung bình
    public float tinhDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    // Phương thức toString để hiển thị thông tin đối tượng ở dạng chuỗi
    @Override
    public String toString() {
        return "Mã SV: " + maSV + ", Họ tên: " + hoTen + ", Điểm LT: " + diemLT + ", Điểm TH: " + diemTH + ", Điểm TB: " + tinhDiemTB();
    }
}


public class cau_3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo 3 đối tượng SinhVien
        SinhVien sv1 = new SinhVien();
        SinhVien sv2 = new SinhVien();
        SinhVien sv3 = new SinhVien();

        // Nhập thông tin cho 3 đối tượng SinhVien
        System.out.println("Nhập thông tin sinh viên thứ nhất:");
        System.out.print("Mã sinh viên: ");
        sv1.setMaSV(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Họ tên: ");
        sv1.setHoTen(scanner.nextLine());
        System.out.print("Điểm LT: ");
        sv1.setDiemLT(scanner.nextFloat());
        System.out.print("Điểm TH: ");
        sv1.setDiemTH(scanner.nextFloat());

        System.out.println("Nhập thông tin sinh viên thứ hai:");
        System.out.print("Mã sinh viên: ");
        sv2.setMaSV(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Họ tên: ");
        sv2.setHoTen(scanner.nextLine());
        System.out.print("Điểm LT: ");
        sv2.setDiemLT(scanner.nextFloat());
        System.out.print("Điểm TH: ");
        sv2.setDiemTH(scanner.nextFloat());

        System.out.println("Nhập thông tin sinh viên thứ ba:");
        System.out.print("Mã sinh viên: ");
        sv3.setMaSV(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Họ tên: ");
        sv3.setHoTen(scanner.nextLine());
        System.out.print("Điểm LT: ");
        sv3.setDiemLT(scanner.nextFloat());
        System.out.print("Điểm TH: ");
        sv3.setDiemTH(scanner.nextFloat());

        // In danh sách sinh viên
        System.out.printf("%-15s%-20s%-10s%-10s%-10s\n", "Mã SV", "Họ Tên", "Điểm LT", "Điểm TH", "Điểm TB");
        System.out.printf("%-15d%-20s%-10.2f%-10.2f%-10.2f\n", sv1.getMaSV(), sv1.getHoTen(), sv1.getDiemLT(), sv1.getDiemTH(), sv1.tinhDiemTB());
        System.out.printf("%-15d%-20s%-10.2f%-10.2f%-10.2f\n", sv2.getMaSV(), sv2.getHoTen(), sv2.getDiemLT(), sv2.getDiemTH(), sv2.tinhDiemTB());
        System.out.printf("%-15d%-20s%-10.2f%-10.2f%-10.2f\n", sv3.getMaSV(), sv3.getHoTen(), sv3.getDiemLT(), sv3.getDiemTH(), sv3.tinhDiemTB());
    }
}