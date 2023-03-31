import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
abstract class robot{
    int M;
    int S;
    public void stat(){
        System.out.println("Weight: "+M);
    }
    public double Energy(){
        return 0;
    }
}

class Pedion extends robot{
    int F;
    Pedion(){
        Random random= new Random();
        this.M=20;
        this.S=10;
        F = random.nextInt(1,6);
    }
    public void stat(){
        super.stat();
        System.out.println("Flexibility: "+F);
    }
    public double Energy(){
        return M*S+(F+1)*S/2;
    }
}

class Zattacker extends robot{
    int P;
    Zattacker(){
        Random random= new Random();
        this.M=50;
        this.S=10;
        P = random.nextInt(20,31);
    }
    public void stat(){
        super.stat();
        System.out.println("Power: "+P);
    }
    public double Energy(){
        return M*S+P*P*S;
    }
}

class Carrier extends robot{
    int E;
    Carrier(){
        Random random= new Random();
        this.M=30;
        this.S=10;
        E = random.nextInt(50,101);
    }
    public void stat(){
        super.stat();
        System.out.println("Energy: "+E);
    }
    public double Energy(){
        return M*S+4*E*S;
    }
}

public class cau_3{
    public static void main(String args[]){
        ArrayList<robot> robots= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong robot: ");
        int n= sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Nhap loai robot thu "+(i+1)+": \n1. neu la Pedion\n2. neu la Zattacker\n3. neu la Carrier\nNhap lua chon: ");
            int type=sc.nextInt();
            sc.nextLine();
            if(type==1){
                Pedion a = new Pedion();
                robots.add(a);
            }
            else if(type==2){
                Zattacker a = new Zattacker();
                robots.add(a);
            }
            else if(type==3){
                Carrier a = new Carrier();
                robots.add(a);
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("Thong tin robot thu: "+(i+1));
            robots.get(i).stat();
            System.out.println("Nang luong da su dung: "+robots.get(i).Energy());
        }
    }
}