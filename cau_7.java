import java.util.Scanner;

public class cau_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        boolean flag = true;
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0)
                flag = false;
        }

        if (flag) {
            System.out.println(x + " la so nguyen to");
        } else {
            System.out.println(x + " khong la so nguyen to");

        }

    }
}
