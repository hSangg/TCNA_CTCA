import java.util.*;

public class Fraction {
    private double Tu;
    private double Mau;
    Fraction(){};
    Fraction(double Tu,double Mau){
            this.Tu = Tu;
            this.Mau = Mau;
    }
    public void Nhap(){
        double a;
        double b;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap tu so: ");
        a=scanner.nextInt();
        System.out.print("Nhap mau so: ");
        b=scanner.nextInt();
        this.Tu=a;
        this.Mau=b;
    }
    public double getTu(){
        return this.Tu;
    }
    public double getMau(){
        return this.Mau;
    }
    public void setTu(double t){
        this.Tu=t;
    }
    public void setMau(double m){
        this.Mau=m;
    }

    public Fraction add(Fraction ps2) {
        double ts = Tu * ps2.Mau + ps2.Tu * Mau;
        double ms = Mau * ps2.Mau;
        return new Fraction(ts, ms);
    }
    public Fraction sub(Fraction ps2) {
        double ts = Tu * ps2.Mau - ps2.Tu * Mau;
        double ms = Mau * ps2.Mau;
        return new Fraction(ts, ms);
    }


    public Fraction mul(Fraction ps2) {
        double ts = Tu * ps2.Tu;
        double ms = Mau * ps2.Mau;
        return new Fraction(ts, ms);
    }
    public Fraction div(Fraction ps2) {

        double tg = ps2.Tu;
        ps2.Tu = ps2.Mau;
        ps2.Mau = tg;


       double ts = Tu * ps2.Tu;
       double ms = Mau * ps2.Mau;
        return new Fraction(ts, ms);
    }
    public void display() {
        if (Tu * Mau < 0) {
            System.out.println("-" + Math.abs(Tu) + "/" + Math.abs(Mau));
        } else {
            System.out.println(Math.abs(Tu) + "/" + Math.abs(Mau));
        }
    }
    public static void main(String[] args){
       Fraction p =new Fraction();
       Fraction p1=new Fraction();
       p.Nhap();
       p1.Nhap();
       System.out.println("Tong: ");
       p.add(p1).display();
        System.out.println("Hieu: ");
        p.sub(p1).display();
        System.out.println("Tich: ");
        p.mul(p1).display();
        System.out.println("Thuong: ");
        p.div(p1).display();

    }
}
