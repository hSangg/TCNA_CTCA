
import java.util.Scanner;

class Vehicle {
    public float cargo_amount;
    public float fuel_amount;
    public float route_to_run;
    float l_fuel_per_km;
    float l_fuel_per_kg;

    Vehicle() {
        this.cargo_amount = 0;
        this.fuel_amount = 0;
        this.route_to_run = 0;
    }

    void add_cargo(float cargo_amount) {
        this.cargo_amount += cargo_amount;
    }

    void remove_cargo(float cargo_amount) {
        this.cargo_amount -= cargo_amount;
    }

    void refill_fuel(float fuel_amount) {
        this.fuel_amount += fuel_amount;
    }

    void drive_distance(float route_to_run) {

        this.route_to_run = route_to_run;
    }

    boolean check_fuel() {
        this.fuel_amount = determine_remainning_fuel();

        if (this.fuel_amount <= 0) {
            System.out.println("run out of fuel");
            return false;
        } else {
            System.out.println("still have fuel");
            return true;
        }
    }

    float determine_remainning_fuel() {
        if (this.fuel_amount - this.caculate_fuel() <= 0)
            return 0;

        return this.fuel_amount - this.caculate_fuel();
    }

    float caculate_fuel() {
        float fuel_to_run = this.route_to_run * this.l_fuel_per_km + this.cargo_amount * this.l_fuel_per_kg;
        return fuel_to_run;
    }

    void printVehicle() {
        System.out.println("this.cargo_amount: " + this.cargo_amount);
        System.out.println("this.fuel_amount: " + this.fuel_amount);
    }

}

class Motobike extends Vehicle {
    Motobike() {
        this.l_fuel_per_km = 2f / 100f;
        this.l_fuel_per_kg = 1f / 100f;
    }
}

class Truck extends Vehicle {
    Truck() {
        this.l_fuel_per_km = (float) 20 / 100;
        this.l_fuel_per_kg = (float) 1 / 100;
    }
}

public class cau_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println("1. Xe May | 2. Xe tai | 3. Thoat");
            choose = scanner.nextInt();
            scanner.nextLine();

            if (choose == 3)
                break;

            switch (choose) {
                case 1:
                    Motobike motobike = new Motobike();
                    System.out.println("1. add cargo");
                    float input = scanner.nextFloat();
                    motobike.add_cargo(input);

                    System.out.println("2. remove cargo");
                    input = scanner.nextFloat();
                    motobike.remove_cargo(input);

                    System.out.println("3. refill fuel");
                    input = scanner.nextFloat();
                    motobike.refill_fuel(input);

                    System.out.println("4. drive distance");
                    input = scanner.nextFloat();
                    motobike.drive_distance(input);

                    System.out.println("5. check fuel");
                    motobike.check_fuel();

                    System.out.println("6. determine remaining fuel");
                    System.out.println(motobike.determine_remainning_fuel());

                    break;

                case 2:
                    Truck truck = new Truck();
                    System.out.println("1. add cargo");
                    float input_ = scanner.nextFloat();
                    truck.add_cargo(input_);

                    System.out.println("2. remove cargo");
                    input_ = scanner.nextFloat();
                    truck.remove_cargo(input_);

                    System.out.println("3. refill fuel");
                    input_ = scanner.nextFloat();
                    truck.refill_fuel(input_);

                    System.out.println("4. drive distance");
                    input_ = scanner.nextFloat();
                    truck.drive_distance(input_);

                    System.out.println("5. check fuel");
                    truck.check_fuel();

                    System.out.println("6. determine remaining fuel");
                    System.out.println(truck.determine_remainning_fuel());
                    break;

                default:
                    break;
            }
        }
    }
}
