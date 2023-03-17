import java.util.Scanner;

public class cau_3 {
    static int gcd(int x, int y) {
        int result = 0;
        if (x == 0 || y == 0)
            result = x + y;
        else {
            while (x != y) {
                if (x > y)
                    x -= y;
                else
                    y -= x;
            }
            result = x;
        }
        return result;
    }

    public static void main(String[] args) {
        int tu, mau;
        Scanner scanin = new Scanner(System.in);
        tu = scanin.nextInt();
        mau = scanin.nextInt();
        if (tu < 0 || mau < 0) {
            tu *= -1;
            mau *= -1;
        }
        int GCD = gcd(Math.abs(tu), Math.abs(mau));
        mau /= GCD;
        tu /= GCD;
        if (mau == 1)
            System.out.print(tu);
        else
            System.out.printf(tu + "/" + mau);
    }
}
