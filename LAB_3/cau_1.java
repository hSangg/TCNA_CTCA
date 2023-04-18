import java.util.InputMismatchException;
import java.util.Scanner;

class SinhVien{
    private long Masv;
    private String Tensv;
    private double Diem;
    SinhVien(){};
    SinhVien(long Masv, String Tensv,double Diem){
        this.Masv=Masv;
        this.Tensv=Tensv;
        this.Diem=Diem;
    }
    public long getMasv() {
        return Masv;
    }

    public void setMasv(long masv) {
        this.Masv = masv;
    }

    public String getTensv() {
        return Tensv;
    }

    public void setTensv(String tensv) {
        this.Tensv = tensv;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double diem) {
        this.Diem = diem;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
                "masv=" + Masv +
                ", tensv='" + Tensv + '\'' +
                ", diem=" + Diem +
                '}';
    }


}
public class cau_1 {


    public static boolean hasNumber(String str) {
        return str.matches(".*\\d+.*");
    }
    public static boolean hasCharacter(long num) {
        String str = Long.toString(num);
        return !str.matches("\\d+");
    }
    public static void check(double m) throws InputMismatchException{
           if(m<0.0 || m>10.0){
               System.out.println("Diem so phai lon hon 0 nho hon 10");
               throw new InputMismatchException("Sai diem");
           }
    }

    public static void main(String[] args)  {
            Scanner sc =new Scanner(System.in);
            try {
                long masv=0;
                System.out.print("Nhập mã số sinh viên: ");
                try {
                    masv = sc.nextLong();
                }catch (InputMismatchException e){
                    System.out.println("Ma sinh vien khon duoc chua ki tu");
                }
                sc.nextLine();
                System.out.print("Nhập tên sinh viên: ");
                String tensv = sc.nextLine();
                System.out.print("Nhập điểm sinh viên: ");
                double diem = sc.nextDouble();
                check(diem);
                SinhVien sv = new SinhVien(masv, tensv, diem);
                System.out.printf("Thông tin sinh viên vừa nhập: %d,%s,%f", masv,tensv,diem);
            }
            catch (InputMismatchException e){
                System.out.println("loi");
            }
        }
    }
