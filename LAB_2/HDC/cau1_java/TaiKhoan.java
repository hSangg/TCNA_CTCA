package cau1_java;

public class TaiKhoan {
    private long soTK;
    private String tenTK;
    private double soTien;
    TaiKhoan(){};
    TaiKhoan(long soTK, String tenTK, double soTien){
        this.soTK=soTK;
        this.tenTK=tenTK;
        this.soTien=soTien;
    }
    double getSotien(){
        return this.soTien;
    }
    void setSotien(double st){
        this.soTien=st;
    }
    void inTaikhoan(){
        System.out.printf("So tai khoan: %d\n",this.soTK);
        System.out.printf("Ten tai khoan: %s\n",this.tenTK);
        System.out.printf("So tien: %-15.2f\n",this.soTien);
    };
    boolean napTien(double st){
        this.soTien+=st;
        return true;
    }
    boolean chuyenKhoan(TaiKhoan a,double st){
        this.soTien-=st;
        a.setSotien(a.getSotien()+st);
        return true;
    }
}