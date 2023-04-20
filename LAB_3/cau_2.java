package LAB_3;

import java.util.HashSet;
import java.util.Scanner;

class danhba {
    String sdt;
    String DiaChi;

    danhba() {
    };

    danhba(String x, String y) {
        sdt = x;
        DiaChi = y;
    }

    public void out() {
        System.out.println("SDT: " + sdt + "\nDia chi: " + DiaChi);
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sdt = sc.nextLine();
        DiaChi = sc.nextLine();
    }
}

public class cau_2 {
    public static void main(String argsp[]) {
        HashSet<danhba> DB = new HashSet<danhba>();
        System.out.print("Nhap so luong so dien thoai muon nhap vao he thong: ");
        int x;
        String sdt, DiaChi;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < x; i++) {
            System.out.print("Nhap sdt: ");
            sdt = sc.nextLine();
            System.out.print("Nhap Dia chi: ");
            DiaChi = sc.nextLine();
            danhba a = new danhba(sdt, DiaChi);
            DB.add(a);
        }
        System.out.print("Nhap sdt can tim thong tin: ");
        String find;
        find = sc.nextLine();

        for (danhba x_ : DB) {
            if (x_.sdt.equals(find)) {
                x_.out();
            }
        }
        System.out.print("Nhap dia chi can tim thong tin: ");
        String dc;
        dc=sc.nextLine();
        for(danhba x_:DB){
            if(x_.DiaChi.equals(dc)){
                x_.out();
            }
        }
    }
}