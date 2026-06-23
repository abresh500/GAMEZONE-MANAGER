import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();

        DatabaseHelper.createTables();

        while (true) {
            try {
                System.out.println("\n1. Start Session");
                System.out.println("2. End Session");
                System.out.println("3. Generate Report");
                System.out.println("4. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter station ID: ");
                        int stationId = sc.nextInt();

                        manager.startSession(name, stationId);
                        break;

                    case 2:
                        System.out.print("Enter station ID: ");
                        int endId = sc.nextInt();
                        manager.endSession(endId);
                        break;

                    case 3:
                        manager.generateReport();
                        System.out.println("Report generated.");
                        break;

                    case 4:
                        System.exit(0);

                    default:
                        throw new InvalidInputException("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}