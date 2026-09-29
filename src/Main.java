import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Task Manager");

        System.out.println("1. Add task");
        System.out.println("2. View tasks");
        System.out.println("3. Exit");

        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        System.out.println("You chose: " + choice);

        scanner.close();
    }
}