import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (choice != 3){

            System.out.println("Task Manager");

            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add new task selected.");
                    break;
                case 2:
                    System.out.println("View tasks selected.");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println();
        }

        scanner.close();
    }
}