package LAB_2.TAI_LOP.P_2;

import java.util.ArrayList;
import java.util.Scanner;

abstract class ChuyenXe {
    String maSoChuyen;
    String hoTenTaiXe;
    String soXe;
    double khoiLuongHangHoa;
    double doanhThu;

    public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, double doanhThu) {
        this.maSoChuyen = maSoChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.khoiLuongHangHoa = khoiLuongHangHoa;
        this.doanhThu = doanhThu;
    }
}

class ChuyenNoiThanh extends ChuyenXe {
    double quangDuongDi;

    public ChuyenNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa,
            double quangDuongDi, double doanhThu) {
        super(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa, doanhThu);
        this.quangDuongDi = quangDuongDi;
    }
}

class ChuyenNgoaiThanh extends ChuyenXe {
    String noiDen;
    int soNgayVanChuyen;

    public ChuyenNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, String noiDen,
            int soNgayVanChuyen, double doanhThu) {
        super(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa, doanhThu);
        this.noiDen = noiDen;
        this.soNgayVanChuyen = soNgayVanChuyen;
    }
}

public class cau_2 {
    public static void main(String[] args) {
        ArrayList<ChuyenXe> dsChuyenXe = new ArrayList<>();
        double tongDoanhThuNoiThanh = 0;
        double tongDoanhThuNgoaiThanh = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong chuyen xe: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin chuyen xe thu " + (i + 1));
            System.out.print("Nhap 1 neu la chuyen noi thanh, 2 neu la chuyen ngoai thanh: ");
            int loaiChuyen = sc.nextInt();
            sc.nextLine();

            System.out.print("Ma so chuyen: ");
            String maSoChuyen = sc.nextLine();
            System.out.print("Ho ten tai xe: ");
            String hoTenTaiXe = sc.nextLine();
            System.out.print("So xe: ");
            String soXe = sc.nextLine();
            System.out.print("Khoi luong hang hoa: ");
            double khoiLuongHangHoa = sc.nextDouble();
            System.out.print("Doanh thu: ");
            double doanhThu = sc.nextDouble();
            sc.nextLine();

            if (loaiChuyen == 1) {
                System.out.print("Quang duong di: ");
                double quangDuongDi = sc.nextDouble();
                sc.nextLine();
                ChuyenNoiThanh chuyenNoiThanh = new ChuyenNoiThanh(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa,
                        quangDuongDi, doanhThu);
                dsChuyenXe.add(chuyenNoiThanh);
                tongDoanhThuNoiThanh += doanhThu;
            } else {
                System.out.print("Noi den: ");
                String noiDen = sc.nextLine();
                System.out.print("So ngay van chuyen: ");
                int soNgayVanChuyen = sc.nextInt();
                sc.nextLine();
                ChuyenNgoaiThanh chuyenNgoaiThanh = new ChuyenNgoaiThanh(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa,
                        noiDen, soNgayVanChuyen, doanhThu);
                dsChuyenXe.add(chuyenNgoaiThanh);
                tongDoanhThuNgoaiThanh += doanhThu;
            }
        }

        System.out.println("Tong doanh thu chuyen noi thanh: " + tongDoanhThuNoiThanh);
        System.out.println("Tong doanh thu chuyen ngoai thanh: " + tongDoanhThuNgoaiThanh);

        double maxNoiThanh = 0;
        ChuyenNoiThanh chuyenNoiThanhMax = null;
        double maxNgoaiThanh = 0;
        ChuyenNgoaiThanh chuyenNgoaiThanhMax = null;

        for (ChuyenXe chuyenXe : dsChuyenXe) {
            if (chuyenXe instanceof ChuyenNoiThanh) {
                if (chuyenXe.doanhThu > maxNoiThanh) {
                    maxNoiThanh = chuyenXe.doanhThu;
                    chuyenNoiThanhMax = (ChuyenNoiThanh) chuyenXe;
                }
            } else {
                if (chuyenXe.doanhThu > maxNgoaiThanh) {
                    maxNgoaiThanh = chuyenXe.doanhThu;
                    chuyenNgoaiThanhMax = (ChuyenNgoaiThanh) chuyenXe;
                }
            }
        }

        if (chuyenNoiThanhMax != null) {
            System.out.println("Thong tin chuyen xe noi thanh co doanh thu cao nhat: ");
            System.out.println("Ma so chuyen: " + chuyenNoiThanhMax.maSoChuyen);
            System.out.println("Ho ten tai xe: " + chuyenNoiThanhMax.hoTenTaiXe);
            System.out.println("So xe: " + chuyenNoiThanhMax.soXe);
            System.out.println("Khoi luong hang hoa: " + chuyenNoiThanhMax.khoiLuongHangHoa);
            System.out.println("Quang duong di: " + chuyenNoiThanhMax.quangDuongDi);
            System.out.println("Doanh thu: " + chuyenNoiThanhMax.doanhThu);
        }

        if (chuyenNgoaiThanhMax != null) {
            System.out.println("Thong tin chuyen xe ngoai thanh co doanh thu cao nhat: ");
            System.out.println("Ma so chuyen: " + chuyenNgoaiThanhMax.maSoChuyen);
            System.out.println("Ho ten tai xe: " + chuyenNgoaiThanhMax.hoTenTaiXe);
            System.out.println("So xe: " + chuyenNgoaiThanhMax.soXe);
            System.out.println("Khoi luong hang hoa: " + chuyenNgoaiThanhMax.khoiLuongHangHoa);
            System.out.println("Noi den: " + chuyenNgoaiThanhMax.noiDen);
            System.out.println("So ngay van chuyen: " + chuyenNgoaiThanhMax.soNgayVanChuyen);
            System.out.println("Doanh thu: " + chuyenNgoaiThanhMax.doanhThu);
        }

    }

}
