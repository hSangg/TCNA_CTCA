abstract class Person {
    private String name;
    private int age;
    Person(){};
    // Hàm khởi tạo của lớp Person
   Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Phương thức truy cập thuộc tính name
    public String getName() {
        return name;
    }

    // Phương thức thiết lập thuộc tính name
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức truy cập thuộc tính age
    public int getAge() {
        return age;
    }

    // Phương thức thiết lập thuộc tính age
    public void setAge(int age) {
        this.age = age;
    }

    // Phương thức trừu tượng show()
    abstract void show();
}

// Định nghĩa lớp Employee, kế thừa từ lớp Person
class Employee extends Person {
    private float salary;

    // Hàm khởi tạo của lớp Employee
    Employee(){};
     Employee(String name, int age, float salary) {
        super(name, age);
        this.salary = salary;
    }

    // Phương thức truy cập thuộc tính salary
    public float getSalary() {
        return salary;
    }

    // Phương thức thiết lập thuộc tính salary
    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Phương thức show() được ghi đè từ lớp cha
    @Override
    public void show() {
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Salary: " + salary);
    }

    // Phương thức tăng lương theo tỉ lệ mặc định 10%
    public void addSalary() {
        float increase = salary * 0.1f;
        salary += increase;
    }

    // Phương thức tăng lương theo giá trị cụ thể đưa vào
    public void addSalary(float increaseAmount) {
        salary += increaseAmount;
    }
}
public class cau_1 {
    public static void main(String[] args){
        Employee a=new Employee("bang",12, 3.12F);
        a.show();
        a.addSalary();
        a.show();
        a.addSalary(2);
        a.show();
    }
}
