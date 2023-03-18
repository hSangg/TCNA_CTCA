import java.util.Scanner;

class cau_4 {
    public static void main(String[] args) {
        int x;
        Scanner scanin = new Scanner(System.in);
        x = scanin.nextInt();
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                System.out.printf(i + " ");
            }
        }
    }
}