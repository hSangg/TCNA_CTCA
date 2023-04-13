package LAB_2.VE_NHA;

import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
import javax.swing.InputMap;

abstract class khachHang {
    String MaKH;
    String TenKH;
    String NgHD;
    int SL;
    double donGia;
    double total;
    int type;
    int dm;

    public void calc() {
    };

    public void info() {
        System.out.println("Ma kH: " + MaKH + "\nTen KH: " + TenKH + "\nNgay hoa don: " + NgHD + "\nSo luong dien: "
                + SL + "\nDon gia: " + donGia + "\nThanh tien: " + total);
    }

}

class sh extends khachHang {
    sh() {
    };

    public void calc() {
        if (SL < dm) {
            this.total = SL * donGia;
        } else
            this.total = SL * donGia * dm + (SL - dm) * donGia * 2;
    }

    sh(String ma, String ten, String Ng, int sl, double Dg, int dm) {
        this.MaKH = ma;
        this.TenKH = ten;
        this.NgHD = Ng;
        this.SL = sl;
        this.donGia = Dg;
        this.dm = dm;
        calc();
    }

    public void info() {
        super.info();
        System.out.println("Dinh muc: " + dm);
    }
}

class kd extends khachHang {
    kd() {
    };

    public void calc() {
        if (SL > 400) {
            total = 400 * donGia + (400 - SL) * donGia * SL * 0.05;
        } else
            total = 400 * donGia;
    }

    kd(String ma, String ten, String Ng, int sl, double Dg) {
        this.MaKH = ma;
        this.TenKH = ten;
        this.NgHD = Ng;
        this.SL = sl;
        this.donGia = Dg;
        calc();
    }

    public void info() {
        super.info();
    }
}

class sx extends khachHang {
    sx() {
    };

    public void calc() {
        if (type == 2) {
            if (SL > 200) {
                total = 200 * donGia + (200 - SL) * donGia * 0.98;
            } else
                total = SL * donGia;
        } else if (type == 3) {
            if (SL > 150) {
                total = 150 * donGia + (150 - SL) * donGia * 0.97;
            } else
                total = SL * donGia;
        }

    }

    sx(String ma, String ten, String Ng, int sl, double Dg, int type) {
        this.MaKH = ma;
        this.TenKH = ten;
        this.NgHD = Ng;
        this.SL = sl;
        this.donGia = Dg;
        this.type = type;
        calc();
    }
}

public class cau_1 {
    public static void input(ArrayList<khachHang> KHS) {
        String MaKH;
        String TenKH;
        String NgHD;
        int SL;
        double donGia;
        int dm = 0;
        int type = 0;
        int count = 0;
        int x;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "Nhap loai khach hang: \n1. Neu la khach hang sinh hoat\n2. Neu la khach hang kinh doanh.\n3. Neu la khach hang san xuat.\nVui long nhap lua chon: ");
            x = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhap ma khach hang: ");
            MaKH = sc.nextLine();
            if (MaKH == "")
                break;
            else {
                System.out.print("Nhap ten khach hang: ");
                TenKH = sc.nextLine();
                System.out.print("Nhap ngay hoa don: ");
                NgHD = sc.nextLine();

                System.out.print("Nhap so luong dien: ");
                SL = sc.nextInt();
                System.out.print("nhap don Gia: ");
                donGia = sc.nextDouble();
                if (x == 1) {
                    System.out.print("nhap dinh muc: ");
                    dm = sc.nextInt();
                } else if (x == 3) {
                    System.out.print("Nhap loai dien(2,3): ");
                    type = sc.nextInt();
                }
                sc.nextLine();
                count++;
                if (count == 1) {
                    if (x == 1) {
                        sh a = new sh(MaKH, TenKH, NgHD, SL, donGia, dm);
                        KHS.add(a);
                    } else if (x == 2) {
                        kd a = new kd(MaKH, TenKH, NgHD, SL, donGia);
                        KHS.add(a);
                    } else {
                        sx a = new sx(MaKH, TenKH, NgHD, SL, donGia, type);
                        KHS.add(a);
                    }
                }
                for (int i = 0; i < count - 1; i++) {
                    if (KHS.get(i).MaKH.equals(MaKH) && KHS.get(i).TenKH.equals(TenKH)) {
                        if (x == 3 && KHS.get(i).type == type) {
                            System.out.println(
                                    "Loai dien vua nhap khong khop voi loai dien cua khach hang, he thong da chinh sua lai cho dung voi loai dien khach hang dang dung.");
                            type = KHS.get(i).type;
                        }
                        while (true) {
                            if (KHS.get(i).NgHD.equals(NgHD)) {
                                System.out.print(
                                        "Ngay hoa don moi khong duoc trung voi ngay hoa don cu, vui long nhap lai ngay hoa don: ");
                                NgHD = sc.nextLine();
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (count != 1) {
                    if (x == 1) {
                        sh a = new sh(MaKH, TenKH, NgHD, SL, donGia, dm);
                        KHS.add(a);
                    } else if (x == 2) {
                        kd a = new kd(MaKH, TenKH, NgHD, SL, donGia);
                        KHS.add(a);
                    } else {
                        sx a = new sx(MaKH, TenKH, NgHD, SL, donGia, type);
                        KHS.add(a);
                    }
                }
            }
        }
    }

    public static void bill(int m, int y, ArrayList<khachHang> KHS) {
        String month, year;
        int Mon, Yer;
        for (int i = 0; i < KHS.size(); i++) {
            month = KHS.get(i).NgHD.substring(3, 5);
            year = KHS.get(i).NgHD.substring(6);
            Mon = Integer.parseInt(month);
            Yer = Integer.parseInt(year);
            if (Mon == m && Yer == y) {
                System.out.println("Ma khach hang: " + KHS.get(i).MaKH + "\nTen Khach hang: " + KHS.get(i).TenKH
                        + "\nSo luong dien: " + KHS.get(i).SL + "\nThanh tien: " + KHS.get(i).total);
            }
        }
    }

    public static void main(String args[]) {
        ArrayList<khachHang> KHS = new ArrayList<>();
        input(KHS);
        Scanner sc = new Scanner(System.in);
        int Month, Year;
        System.out.print("Nhap thang va nam: ");
        Month = sc.nextInt();
        Year = sc.nextInt();
        bill(Month, Year, KHS);
    }
}