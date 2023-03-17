import java.util.Scanner;

public class cau_1_cau_2 {

    static int cau1(int x, int y) {
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
        System.out.printf("Uoc so chung lon nhat cua 2 so vua nhap la: " + result);
        return result;
    }

    public static void main(String[] args) {
        int x, y;
        Scanner scanin = new Scanner(System.in);
        x = scanin.nextInt();
        y = scanin.nextInt();
        int result2 = 0;
        result2 = x * y / cau1(x, y);
        System.out.printf("\nBoi so chung nho nhat cua 2 so vua nhap la: " + result2);
    }
}
