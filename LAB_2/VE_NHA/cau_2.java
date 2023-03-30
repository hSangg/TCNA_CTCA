package LAB_2.VE_NHA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Goods {
    private String id;
    private String name;
    private int quantity;
    private double price;

    public Goods() {
    }

    public Goods(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }

    public void printInfoWithRating() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        evaluateSale();
    }

    public double calculateTotalPrice() {
        double totalPrice = quantity * price;
        if (this instanceof Electronics || this instanceof Appliance) {
            totalPrice *= 1.1;
        } else if (this instanceof Food) {
            totalPrice *= 1.05;
        }
        return totalPrice;
    }

    public void evaluateSale() {
        if (this instanceof Electronics && quantity < 3) {
            System.out.println("Saleability: Easy to sell");
        } else if (this instanceof Food && quantity > 2
                && LocalDate.now().isBefore(((Food) this).getExpirationDate())) {
            System.out.println("Saleability: Hard to sell");
        } else if (this instanceof Appliance && quantity > 10 && LocalDate.now()
                .minusDays(((Appliance) this).getDaysInStock()).isAfter(LocalDate.now().minusDays(20))) {
            System.out.println("Saleability: Slow to sell");
        } else {
            System.out.println("Saleability: Not evaluated");
        }
    }
}

class Food extends Goods {
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private String supplier;

    public Food() {
    }

    public Food(String id, String name, int quantity, double price, LocalDate manufactureDate, LocalDate expirationDate,
            String supplier) {
        super(id, name, quantity, price);
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.supplier = supplier;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Manufacture date: " + manufactureDate);
        System.out.println("Expiration date: " + expirationDate);
        System.out.println("Supplier: " + supplier);
    }
}

class Appliance extends Goods {
    private String manufacturer;
    private LocalDate importDate;
    private String type;

    public Appliance() {
    }

    public Appliance(String id, String name, int quantity, double price, String manufacturer, LocalDate importDate,
            String type) {
        super(id, name, quantity, price);
        this.manufacturer = manufacturer;
        this.importDate = importDate;
        this.type = type;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Import date: " + importDate);
        System.out.println("Type: " + type);
    }

    public int getDaysInStock() {
        return (int) ((int) LocalDate.now().toEpochDay() - importDate.toEpochDay());
    }
}

class Electronics extends Goods {
    private String brand;
    private String type;
    private int warrantyPeriod;

    public Electronics() {
    }

    public Electronics(String id, String name, int quantity, double price, String brand, String type,
            int warrantyPeriod) {
        super(id, name, quantity, price);
        this.brand = brand;
        this.type = type;
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
        System.out.println("Warranty period: " + warrantyPeriod + " months");
    }
}

public class cau_2 {
    public static void InputGoods(ArrayList<Goods> goodsList) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the ID of the goods (or enter blank to finish): ");
            String id = scanner.nextLine();

            if (id.isEmpty()) {
                break;
            }

            boolean exist = false;
            for (Goods goods : goodsList) {
                if (goods.getId().equals(id)) {
                    System.out.println("The goods already exist in the list.");
                    exist = true;
                    break;
                }
            }

            if (exist) {
                continue;
            }

            System.out.print("Enter the name of the goods: ");
            String name = scanner.nextLine();

            System.out.print("Enter the quantity of the goods: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the price of the goods: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter the type of the goods (1 - Electronics, 2 - Appliance, 3 - Food): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            Goods goods;
            switch (type) {
                case 1:
                    System.out.print("Enter the brand of the electronics: ");
                    String brand = scanner.nextLine();

                    System.out.print("Enter the type of the electronics: ");
                    String eType = scanner.nextLine();

                    System.out.print("Enter the warranty period (in months) of the electronics: ");
                    int warrantyPeriod = scanner.nextInt();
                    scanner.nextLine();

                    goods = new Electronics(id, name, quantity, price, brand, eType, warrantyPeriod);
                    break;
                case 2:
                    System.out.print("Enter the manufacturer of the appliance: ");
                    String manufacturer = scanner.nextLine();

                    System.out.print("Enter the import date of the appliance (yyyy-mm-dd): ");
                    String importDateString = scanner.nextLine();
                    LocalDate importDate = LocalDate.parse(importDateString);

                    System.out.print("Enter the type of the appliance: ");
                    String aType = scanner.nextLine();

                    goods = new Appliance(id, name, quantity, price, manufacturer, importDate, aType);
                    break;
                case 3:
                    System.out.print("Enter the manufacture date of the food (yyyy-mm-dd): ");
                    String manufactureDateString = scanner.nextLine();
                    LocalDate manufactureDate = LocalDate.parse(manufactureDateString);

                    System.out.print("Enter the expiration date of the food (yyyy-mm-dd): ");
                    String expirationDateString = scanner.nextLine();
                    LocalDate expirationDate = LocalDate.parse(expirationDateString);
                    System.out.print("Enter the supplier of the food: ");
                    String supplier = scanner.nextLine();

                    goods = new Food(id, name, quantity, price, manufactureDate, expirationDate, supplier);
                    break;
                default:
                    System.out.println("Invalid goods type.");
                    continue;
            }

            goodsList.add(goods);
            System.out.println("The goods has been added to the list.");
        }

        System.out.println("List of goods:");
        for (Goods goods : goodsList) {
            goods.printInfo();
        }
        scanner.close();

    }

    static void PrintRatingGood(ArrayList<Goods> goodsList) {
        for (Goods good : goodsList) {
            good.printInfoWithRating();
        }
    }

    static void ElectronicEasyToSale(ArrayList<Goods> goodsList) {
        for (Goods good : goodsList) {
            if (good instanceof Electronics && good.getQuantity() < 3) {
                Electronics goodElectronics = (Electronics) good;
                System.out.println("name: " + goodElectronics.getBrand());
                System.out.println("name: " + goodElectronics.getName());
                System.out.println("name: " + goodElectronics.getType());
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Goods> goodsList = new ArrayList<>();
        InputGoods(goodsList);
        PrintRatingGood(goodsList);
        ElectronicEasyToSale(goodsList);
    }
}
