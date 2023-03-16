import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class cau_8 {
    public static void main(String[] args) {
        String file1 = "input8.1.txt";
        String file2 = "input8.2.txt";
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        int lineNumber = 0;
        try {
            reader1 = new BufferedReader(new FileReader(file1));
            reader2 = new BufferedReader(new FileReader(file2));
            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            while (line1 != null || line2 != null) {
                lineNumber++;
                if (line1 == null || !line1.equalsIgnoreCase(line2)) {
                    System.out.println(lineNumber + " // " + (line1 == null ? "" : line1));
                } else if (line2 == null || !line2.equalsIgnoreCase(line1)) {
                    System.out.println(lineNumber + " \\\\ " + (line2 == null ? "" : line2));
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader1 != null)
                    reader1.close();
                if (reader2 != null)
                    reader2.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
