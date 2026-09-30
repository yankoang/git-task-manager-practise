import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        int choice = 0;

        while (choice != 4){

            System.out.println("Task Manager");

            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String description = scanner.nextLine();

                    Task task = new Task(description);
                    tasks.add(task);
                    System.out.println("Task added.");
                    break;
                case 2:

                    if(tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    }
                    else{
                        System.out.println("Tasks: ");

                        for (int i = 0; i < tasks.size(); i++){
                            System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
                        }
                    }

                    break;
                case 3:

                    // TODO: Implement task completion

                    break;
                case 4:
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