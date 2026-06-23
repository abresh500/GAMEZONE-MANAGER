import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public static void generateReport(int totalSessions, double revenue) {
        try (FileWriter writer = new FileWriter("report.txt")) {

            writer.write("=== DAILY REPORT ===\n");
            writer.write("Total Sessions: " + totalSessions + "\n");
            writer.write("Total Revenue: " + revenue + " birr\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}