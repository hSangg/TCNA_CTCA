import java.util.Arrays;
import java.util.Scanner;

class cau_9_lop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so phan tu mang: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            arr[i] = a;
        }
        // 1
        System.out.println(Arrays.toString(arr));
        // 2
        int max_element = Arrays.stream(arr).max().getAsInt();
        System.out.println("phan tu lon nhat la: " + max_element);
        // 2
        int min_element = Arrays.stream(arr).min().getAsInt();
        System.out.println("phan tu nho naht la: " + min_element);

        // 3
        System.out.print("Nhap gia tri can kiem tra: ");
        int x = input.nextInt();
        int index = Arrays.binarySearch(arr, x);

        if (index >= 0) {
            System.out.println("x nằm tại vị trí: " + index);
        } else {
            System.out.println("x không nằm trong mảng.");
        }
        // 4
        System.out.print("Nhap gia tri can dem: ");
        int x__ = input.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x__)
                count++;
        }
        System.out.println("so phan tu co gia tri bang " + x__ + " trong mang la: " + count);

    }
}