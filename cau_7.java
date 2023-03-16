import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class cau_7 {
    public static void main(String[] args) throws FileNotFoundException {
        // Đọc dữ liệu từ file input
        File inputFile = new File("input7.txt");
        Scanner scanner = new Scanner(inputFile);

        int numDays = scanner.nextInt(); // Số ngày được lấy dữ liệu

        double overallTotal = 0; // Tổng nhiệt độ của toàn bộ các ngày
        double overallMax = Double.MIN_VALUE; // Nhiệt độ cao nhất của tất cả các ngày
        double overallMin = Double.MAX_VALUE; // Nhiệt độ thấp nhất của tất cả các ngày

        PrintWriter writer = new PrintWriter("output.txt");

        // Vòng lặp qua từng ngày
        for (int i = 0; i < numDays; i++) {
            double dayTotal = 0; // Tổng nhiệt độ của ngày hiện tại
            double dayMax = Double.MIN_VALUE; // Nhiệt độ cao nhất của ngày hiện tại
            double dayMin = Double.MAX_VALUE; // Nhiệt độ thấp nhất của ngày hiện tại

            // Vòng lặp qua từng giờ trong ngày
            for (int j = 0; j < 12; j++) {
                double temperature = scanner.nextDouble();
                System.out.println("temperature: " + temperature);
                dayTotal += temperature;
                overallTotal += temperature;

                if (temperature > dayMax) {
                    dayMax = temperature;
                }

                if (temperature < dayMin) {
                    dayMin = temperature;
                }

                if (temperature > overallMax) {
                    overallMax = temperature;
                }

                if (temperature < overallMin) {
                    overallMin = temperature;
                }
            }

            double dayAverage = dayTotal / 12; // Nhiệt độ trung bình của ngày hiện tại
            writer.printf("Day %d: Avg=%.1f, High=%.1f, Low=%.1f%n", i + 1, dayAverage, dayMax, dayMin);
        }

        double overallAverage = overallTotal / (numDays * 12); // Nhiệt độ trung bình của toàn bộ các ngày
        writer.printf("Overall Avg=%.1f, Overall High=%.1f, Overall Low=%.1f", overallAverage, overallMax, overallMin);
        writer.close();
    }
}
