package cau1_java;

public class Main {
    public static void main(String[] args) {
        TaiKhoan t =new TaiKhoan(1,"2",3);
        TaiKhoan t1=new TaiKhoan(4,"5",6);

        t.chuyenKhoan(t1,2);
        t.inTaikhoan();
        t1.inTaikhoan();
    }
}
