package LAB_3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Random;;

class Customer implements Comparable<Customer> {
    String name;
    int sales;

    public Customer(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }
    public int compareTo(Customer other) {
        return Integer.compare(other.sales, sales);
    }
}

class Congty{
    ArrayList<String> Nhanvien = new ArrayList<>();
    HashSet<String> SP = new HashSet<>();
    HashMap<String,Integer> SLTenNV = new HashMap<>();
    Congty(){};
    public void AddNV(String name){
        Nhanvien.add(name);
    }
    public String RandomNV(){
        Random random = new Random();
        int i = random.nextInt(Nhanvien.size());
        return Nhanvien.get(i);
    }
    public void AddSP(){
        for(String x: Nhanvien){
            SP.add(x);
        }
    }
    public void DSSP(){
        for(String x: SP){
            System.out.println("Ten SP: "+x);
        }
    }

    public String FindPop(){
        for(String x: Nhanvien){
            if(SLTenNV.containsKey(x)){
                int cnt=SLTenNV.get(x);
                SLTenNV.put(x,cnt+1);
            }
            else{
                SLTenNV.put(x,1);
            }
        }
        String nvPhobien = null;
        int mc=0;
        for(String name: SLTenNV.keySet()){
            int c=SLTenNV.get(name);
            if(c>mc){
                nvPhobien=name;
                mc=c;
            }
        }
        return nvPhobien;
    }
    PriorityQueue<String> tripQueue= new PriorityQueue<>(20);
    public void addnvdulich(String name){
        if(tripQueue.size()<20){
            tripQueue.offer(name);
        }
        else{
            System.out.println("Da du 20 nv");
        }
    }

    TreeSet<Customer> customers= new TreeSet<>();
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
class cau_3 {
    public static void main(String args[]){
        Congty ABC = new Congty();
        ABC.AddNV("Van");
        ABC.AddNV("Sieu");
        ABC.AddNV("Toan");
        ABC.AddNV("Duc");
        ABC.AddNV("Vy");
        ABC.AddNV("Vy");
        String random= ABC.RandomNV();
        System.out.println("Nhan vien duoc nhan qua tang: "+random);
        ABC.AddSP();
        ABC.DSSP();
        String NVphobien=ABC.FindPop();
        System.out.println("Ten San Pham moi: "+NVphobien);
        
    }
}
