import java.util.Scanner;

public class cau_4 {
    public static void main(String[] args) {

        // Yêu cầu 1
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi x: ");
        String x = sc.nextLine();
        int lengthX = x.length();
        System.out.println("Tong chieu dai cua chuoi x = " + lengthX);

        // Yêu cầu 2
        String firstThreeCharsOfX = x.substring(0, 3);
        System.out.println("Ba ki tu dau tien cua chuoi x = " + firstThreeCharsOfX);

        // Yêu cầu 3
        String lastThreeCharsOfX = x.substring(lengthX - 3);
        System.out.println("Ba ki tu cuoi chuoi x = " + lastThreeCharsOfX);

        // Yêu cầu 4
        char charSixOfX = x.charAt(5);
        System.out.println("ki tu thu 6 cua chuoi x = " + charSixOfX);

        // Yêu cầu 5
        System.out.print("nhap chuoi y: ");
        String y = sc.nextLine();
        String lastThreeCharsOfY = y.substring(lengthX - 3);
        String newString = firstThreeCharsOfX + lastThreeCharsOfY;
        System.out.println("chuoi moi = " + newString);

        // Yêu cầu 6
        boolean isEqual = x.equals(y);
        System.out.println("x == y? " + isEqual);

        // Yêu cầu 7
        boolean isEqualsIgnoreCase = x.equalsIgnoreCase(y);
        System.out.println("x == y (khong phan biet hoa/thuong)? " + isEqualsIgnoreCase);

        // Yêu cầu 8
        boolean isYInX = x.contains(y);
        if (isYInX) {
            int indexOfY = x.indexOf(y);
            System.out.println("y xuat hien trong x tai vi tri " + indexOfY);
        } else {
            System.out.println("y khong xuat hien trong x");
        }

        // Yêu cầu 9
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = x.indexOf(y, lastIndex);
            if (lastIndex != -1) {
                System.out.println("y xuat hien trong x tai vi tri " + lastIndex);
                lastIndex += y.length();
            }
        }
    }
}
