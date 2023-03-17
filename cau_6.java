
import java.util.Scanner;

public class cau_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int m = scanner.nextInt();

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                a[i][j] = scanner.nextInt();
            }
        }

        int max = 0;
        int[] maxIndexes = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    maxIndexes[0] = i;
                    maxIndexes[1] = j;
                }
            }
        }

        System.out.println("Số lớn nhất mảng là " + max + " ở vị trí [" + maxIndexes[0] + "][" + maxIndexes[1] + "].");

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 1; i++) {
                for (int k = i + 1; k < n; k++) {
                    if (a[k][j] < a[i][j]) {
                        int tmp = a[i][j];
                        a[i][j] = a[k][j];
                        a[k][j] = tmp;
                    }
                }
            }
        }
        System.out.println("\nMảng A sau khi sắp xếp các cột theo thứ tự tăng dần:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Các số nguyên tố có trong mảng lá:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPrime(a[i][j])) {
                    System.out.print(a[i][j] + " ");
                } else {
                    a[i][j] = 0;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}