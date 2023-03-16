import java.util.*;
public class cau5 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,m;
        System.out.println("Nhap so phan tu mang dau tien: ");
        n=scanner.nextInt();
        System.out.println("Nhap so phan tu mang thu hai: ");
        m=scanner.nextInt();
        int[] a=new int[n];
        System.out.println("Nhap phan tu cua mang a");
        for(int i=0;i<n;i++){
            System.out.println("Nhap phan tu: ");
            int c=scanner.nextInt();
            a[i]=c;
        }
        System.out.println("Nhap phan tu cua mang b");
        int[] b=new int[m];
        for(int i=0;i<m;i++){
            int min=0;
            int max=50;
            int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
            b[i]=random_int;
        }
        for(int i=0;i<m;i++){
            System.out.println(b[i]);
        }
        int[] c= Arrays.copyOf(a,n);
        System.arraycopy(b, m-3, c, 1, 3);
        Arrays.sort(c); // sắp xếp mảng C tăng dần

        System.out.println("\nCác phần tử của mảng C:");
        for (int i = 0; i < n; i++) { // vòng lặp để xuất các giá trị của mảng C ra màn hình
            System.out.print(c[i] + " ");
        }
    }
}
