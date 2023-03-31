import java.util.Scanner;
class HinhChuNhat{
    private double dai;
    private double rong;
    HinhChuNhat(){};
    HinhChuNhat(double x,double y){
        this.dai=x;
        this.rong=y;
    }
    public double getdai(){
        return dai;
    }
    public double getrong(){
        return rong;
    }
    public void setdai(double x){
        this.dai=x;
    }
    public void setrong(double x){
        this.rong=x;
    }
    public double dientich(){
        return dai*rong;
    }
    public double chuvi(){
        return 2*(dai+rong);
    }
    public String toString(){
        return "dai: "+dai+"\nrong: "+rong+"\ndien tich: "+dientich()+"\nchu vi: "+chuvi();
    }
}
public class cau_2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x,y;
        x=sc.nextInt();
        y=sc.nextInt();
        HinhChuNhat a= new HinhChuNhat(x,y);
        System.out.println(a);
    }
}