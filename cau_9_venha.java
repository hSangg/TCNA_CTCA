import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cau_9_venha {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Remove non-alphanumeric characters
            String cleanLine = line.replaceAll("[^A-Za-z0-9]", "");

            // Reverse the string
            String reverseLine = new StringBuilder(cleanLine).reverse().toString();

            // Check if the original and reversed lines are equal
            if (cleanLine.equalsIgnoreCase(reverseLine)) {
                System.out.println(line + " is a palindrome.");
            } else {
                System.out.println(line + " is not a palindrome.");
            }
        }

        scanner.close();
    }
}
