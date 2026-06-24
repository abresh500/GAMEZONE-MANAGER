import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();

        DatabaseHelper.createTables();//

        while (true) {
            try {
                System.out.println("\n1 start session");
                System.out.println("2 end ");
                System.out.println("3 report to manager ");
                System.out.println("4 finsishh");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("ur name: ");
                        String name = sc.nextLine();

                        System.out.print("which station : ");
                        int stationId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("customer typer if u are regular 1 and if u on discounted list 2: ");
                        int type = sc.nextInt();
                        sc.nextLine();

                        manager.startSession(name, stationId, type);
                        break;

                    case 2:
                        System.out.print("which station : ");
                        int endId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("how many games u played ");
                        int games = sc.nextInt();
                        sc.nextLine();

                        manager.endSession(endId, games);
                        break;

                    case 3:
                        manager.generateReport();
                        System.out.println("Report generated.");
                        break;

                    case 4:
                        System.exit(0);

                    default:
                        throw new InvalidInputException("invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}