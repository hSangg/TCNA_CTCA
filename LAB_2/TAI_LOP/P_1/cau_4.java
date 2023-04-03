import java.util.Scanner;
import java.util.*;
 class Xe {
    private String tenChuXe;
    private String loaiXe;
    private double triGiaXe;
    private double dungTichXYLanh;

    public Xe() {
        tenChuXe = "";
        loaiXe = "";
        triGiaXe = 0;
        dungTichXYLanh = 0;
    }

    public Xe(String tenChuXe, String loaiXe, double triGiaXe, double dungTichXYLanh) {
        this.tenChuXe = tenChuXe;
        this.loaiXe = loaiXe;
        this.triGiaXe = triGiaXe;
        this.dungTichXYLanh = dungTichXYLanh;
    }

    public String getTenChuXe() {
        return tenChuXe;
    }

    public void setTenChuXe(String tenChuXe) {
        this.tenChuXe = tenChuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public double getTriGiaXe() {
        return triGiaXe;
    }

    public void setTriGiaXe(double triGiaXe) {
        this.triGiaXe = triGiaXe;
    }

    public double getDungTichXYLanh() {
        return dungTichXYLanh;
    }

    public void setDungTichXYLanh(double dungTichXYLanh) {
        this.dungTichXYLanh = dungTichXYLanh;
    }

    public double tinhThue() {
        double thue;
        if (dungTichXYLanh < 100) {
            thue = triGiaXe * 0.01;
        } else if (dungTichXYLanh >= 100 && dungTichXYLanh <= 175) {
            thue = triGiaXe * 0.03;
        } else {
            thue = triGiaXe * 0.05;
        }
        return thue;
    }

    public Vector<Xe> Nhapdanhsachxe() {
        Scanner scanner = new Scanner(System.in);

        Vector<Xe> ds=new Vector<Xe>();

        // Nhập danh sách xe
        while (true) {
            System.out.print("Nhap ten chu xe: \n");
            String tenChuXe = scanner.nextLine();
            if (tenChuXe.isEmpty()) {
                break;
            }
            System.out.print("Nhap loai xe: \n");
            String loaiXe = scanner.nextLine();
            System.out.print("Nhap tri gia xe: \n");
            double triGiaXe = scanner.nextDouble();
            System.out.print("Nhap dung tich xylanh: \n");
            double dungtich=scanner.nextDouble();

            Xe x=new Xe(tenChuXe,loaiXe,triGiaXe,dungtich);
            ds.add(x);
            scanner.nextLine();
        }
        return ds;
    }
    public void Xuatbanke(Vector<Xe> ds) {
        for (int i = 0; i < ds.size(); i++) {
            System.out.printf("Xe thu: %d\n\n",i);
            System.out.printf("Ten chu xe: %s\n", ds.get(i).tenChuXe);
            System.out.printf("Loai xe: %s\n", ds.get(i).loaiXe);
            System.out.printf("Tri gia xe: %-15.3f\n", ds.get(i).triGiaXe);
            System.out.printf("Dung tich xylanh: %-15.3f\n",ds.get(i).dungTichXYLanh);
            System.out.printf("Thue phai dong: %-15.3f\n",ds.get(i).tinhThue());
        }
    }
    public double findTax(String Tenchuxe,String loaixe,Vector<Xe> ds){
        for(int i=0;i<ds.size();i++){
            if(ds.get(i).getTenChuXe()==Tenchuxe && ds.get(i).getLoaiXe()==loaixe){
                return ds.get(i).tinhThue();
            }
        }
        return 0;
    }
}


public class cau_4 {
    public static void main(String[] args){
        Xe x=new Xe();
        Vector<Xe> ds=new Vector<>();
        ds=x.Nhapdanhsachxe();
        x.Xuatbanke(ds);
    }
}
