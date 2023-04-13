
class sach {
    long maSach;
    String tenSach;
    double donGia;
    int soLuong;
    String nxb;

    public sach() {
    };

    public sach(long maSach, String tenSach, double donGia, int soLuong, String nxb) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nxb = nxb;
    }

    public void thongtinSach() {
        System.out.println("ma: " + maSach + "\nten: " + tenSach + "\nDon gia: " + donGia + "\nSo luong: " + soLuong
                + "\nNha xuat ban: " + nxb);
    }

    public double thanhTien() {
        return soLuong * donGia;
    }
}

class SachTieuThuyet extends sach {
    boolean tinhTrang;

    SachTieuThuyet() {
    };

    SachTieuThuyet(long ma, String ten,
            double dG, int sL, String nxb, boolean tTrang) {
        this.maSach = ma;
        this.tenSach = ten;
        this.donGia = dG;
        this.soLuong = sL;
        this.nxb = nxb;
        this.tinhTrang = tTrang;
    }

    public void thongtinSach() {
        super.thongtinSach();
        if (tinhTrang == false)
            System.out.println("Da het");
        else
            System.out.println("Con hang");

    }

    public double thanhTien() {
        return donGia * soLuong;
    }
}

class SachTrinhTham extends sach {
    float thue;

    SachTrinhTham() {
    };

    SachTrinhTham(long ma, String ten, double dG, int sL, String nxb, float th) {
        this.maSach = ma;
        this.tenSach = ten;
        this.donGia = dG;
        this.soLuong = sL;
        this.nxb = nxb;
        this.thue = th;
    }

    public void thongtinSach() {
        super.thongtinSach();
        System.out.println("thue: " + thue);
    }

    public double thanhTien() {
        return donGia * soLuong + thue;
    }
}

public class cau_2 {
    public static void main(String args[]) {
        SachTieuThuyet b = new SachTieuThuyet(2, "Blue", 222.22, 2, "Wingsbook", false);
        b.thongtinSach();
        System.out.println(b.thanhTien());
        SachTrinhTham a = new SachTrinhTham(1, "Red", 323.23, 3, "Kim", 33);
        a.thongtinSach();
        System.out.println(a.thanhTien());
    }
}