import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = TaskStorage.loadTasks();

        int choice = 0;

        while (choice != 6){

            System.out.println("Task Manager");

            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Edit task");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String description = scanner.nextLine();

                    Task task = new Task(description);
                    tasks.add(task);
                    TaskStorage.saveTasks(tasks);
                    System.out.println("Task added.");
                    break;
                case 2:

                    if(tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    }
                    else{
                        TaskPrinter.printTasks(tasks);
                    }

                    break;
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        TaskPrinter.printTasks(tasks);

                        System.out.print("Enter task number to complete: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();

                        int taskIndex = taskNumber - 1;

                        if (taskIndex >= 0 && taskIndex < tasks.size()) {
                            Task selectedTask = tasks.get(taskIndex);

                            if (selectedTask.isCompleted()) {
                                System.out.println("Task is already completed.");
                            } else {
                                selectedTask.markCompleted();
                                TaskStorage.saveTasks(tasks);
                                System.out.println("Task completed.");
                            }
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        TaskPrinter.printTasks(tasks);

                        System.out.print("Enter task number to delete: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();

                        int taskIndex = taskNumber - 1;

                        if (taskIndex >= 0 && taskIndex < tasks.size()) {
                            Task deletedTask = tasks.remove(taskIndex);

                            TaskStorage.saveTasks(tasks);

                            System.out.println(
                                    "Task deleted: " + deletedTask.getDescription()
                            );
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 5:

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        TaskPrinter.printTasks(tasks);

                        System.out.print("Enter task number to edit: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();

                        int taskIndex = taskNumber - 1;

                        if (taskIndex >= 0 && taskIndex < tasks.size()) {
                            Task selectedTask = tasks.get(taskIndex);

                            System.out.print("Enter new description: ");
                            String newDescription = scanner.nextLine();

                            selectedTask.updateDescription(newDescription);
                            TaskStorage.saveTasks(tasks);

                            System.out.println("Task updated.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }

                    break;
                case 6:
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