import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class cau_7 {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("input7.txt");
        Scanner scanner = new Scanner(inputFile);

        int numDays = scanner.nextInt();

        double overallTotal = 0;
        double overallMax = Double.MIN_VALUE;
        double overallMin = Double.MAX_VALUE;

        PrintWriter writer = new PrintWriter("output7.txt");

        for (int i = 0; i < numDays; i++) {
            double dayTotal = 0;
            double dayMax = Double.MIN_VALUE;
            double dayMin = Double.MAX_VALUE;

            for (int j = 0; j < 12; j++) {
                double temperature = scanner.nextDouble();

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

            double dayAverage = dayTotal / 12;
            writer.printf("Day %d: Avg=%.1f, High=%.1f, Low=%.1f%n", i + 1, dayAverage, dayMax, dayMin);
        }

        double overallAverage = overallTotal / (numDays * 12);
        writer.printf("Overall Avg=%.1f, Overall High=%.1f, Overall Low=%.1f", overallAverage, overallMax, overallMin);
        writer.close();
    }
}
