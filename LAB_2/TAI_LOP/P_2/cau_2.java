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
        System.out.print("Nhập số lượng chuyến xe: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin chuyến xe thứ " + (i + 1));
            System.out.print("Nhập 1 nếu là chuyến nội thành, 2 nếu là chuyến ngoại thành: ");
            int loaiChuyen = sc.nextInt();
            sc.nextLine();

            System.out.print("Mã số chuyến: ");
            String maSoChuyen = sc.nextLine();
            System.out.print("Họ tên tài xế: ");
            String hoTenTaiXe = sc.nextLine();
            System.out.print("Số xe: ");
            String soXe = sc.nextLine();
            System.out.print("Khối lượng hàng hóa: ");
            double khoiLuongHangHoa = sc.nextDouble();
            System.out.print("Doanh thu: ");
            double doanhThu = sc.nextDouble();
            sc.nextLine();

            if (loaiChuyen == 1) {
                System.out.print("Quãng đường đi: ");
                double quangDuongDi = sc.nextDouble();
                sc.nextLine();
                ChuyenNoiThanh chuyenNoiThanh = new ChuyenNoiThanh(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa,
                        quangDuongDi, doanhThu);
                dsChuyenXe.add(chuyenNoiThanh);
                tongDoanhThuNoiThanh += doanhThu;
            } else {
                System.out.print("Nơi đến: ");
                String noiDen = sc.nextLine();
                System.out.print("Số ngày vận chuyển: ");
                int soNgayVanChuyen = sc.nextInt();
                sc.nextLine();
                ChuyenNgoaiThanh chuyenNgoaiThanh = new ChuyenNgoaiThanh(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa,
                        noiDen, soNgayVanChuyen, doanhThu);
                dsChuyenXe.add(chuyenNgoaiThanh);
                tongDoanhThuNgoaiThanh += doanhThu;
            }
        }

        System.out.println("Tổng doanh thu chuyến nội thành: " + tongDoanhThuNoiThanh);
        System.out.println("Tổng doanh thu chuyến ngoại thành: " + tongDoanhThuNgoaiThanh);

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
            System.out.println("Thông tin chuyến xe nội thành có doanh thu cao nhất: ");
            System.out.println("Mã số chuyến: " + chuyenNoiThanhMax.maSoChuyen);
            System.out.println("Họ tên tài xế: " + chuyenNoiThanhMax.hoTenTaiXe);
            System.out.println("Số xe: " + chuyenNoiThanhMax.soXe);
            System.out.println("Khối lượng hàng hóa: " + chuyenNoiThanhMax.khoiLuongHangHoa);
            System.out.println("Quãng đường đi: " + chuyenNoiThanhMax.quangDuongDi);
            System.out.println("Doanh thu: " + chuyenNoiThanhMax.doanhThu);
        }

        if (chuyenNgoaiThanhMax != null) {
            System.out.println("Thông tin chuyến xe ngoại thành có doanh thu cao nhất: ");
            System.out.println("Mã số chuyến: " + chuyenNgoaiThanhMax.maSoChuyen);
            System.out.println("Họ tên tài xế: " + chuyenNgoaiThanhMax.hoTenTaiXe);
            System.out.println("Số xe: " + chuyenNgoaiThanhMax.soXe);
            System.out.println("Khối lượng hàng hóa: " + chuyenNgoaiThanhMax.khoiLuongHangHoa);
            System.out.println("Nơi đến: " + chuyenNgoaiThanhMax.noiDen);
            System.out.println("Số ngày vận chuyển: " + chuyenNgoaiThanhMax.soNgayVanChuyen);
            System.out.println("Doanh thu: " + chuyenNgoaiThanhMax.doanhThu);
        }
    }

}
