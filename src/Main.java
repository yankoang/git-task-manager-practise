import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        int choice = 0;

        while (choice != 6){

            System.out.println("Task Manager");

            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Edit task");
            System.out.println("6. Exit");

            Integer input = InputReader.readInt(scanner, "Choose an option: ");

            if(input == null) {
                continue;
            }

            choice = input;

            switch (choice) {
                case 1: //Add tasks
                    System.out.print("Enter task: ");
                    String description = scanner.nextLine();

                    taskManager.addTask(description);
                    System.out.println("Task added.");
                    break;
                case 2: //View tasks

                    if(taskManager.getTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    }
                    else{
                        TaskPrinter.printTasks(taskManager.getTasks());
                    }

                    break;
                case 3: //Complete task
                    if (taskManager.getTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        TaskPrinter.printTasks(taskManager.getTasks());

                        System.out.print("Enter task number to complete: ");

                        Integer taskNumber = InputReader.readInt(
                                scanner,
                                "Enter task number to complete: "
                        );

                        if (taskNumber == null) {
                            continue;
                        }

                        boolean completed = taskManager.completeTask(taskNumber);

                        if (completed) {
                            System.out.println("Task completed.");
                        } else {
                            System.out.println("Invalid task number or task is already completed.");
                        }
                    }
                    break;
                case 4: //Delete task
                    if (taskManager.getTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        TaskPrinter.printTasks(taskManager.getTasks());

                        System.out.print("Enter task number to delete: ");

                        Integer taskNumber = InputReader.readInt(
                                scanner,
                                "Enter task number to delete: "
                        );

                        if (taskNumber == null) {
                            continue;
                        }

                        Task deletedTask = taskManager.deleteTask(taskNumber);

                        if (deletedTask != null) {
                            System.out.println(
                                    "Task deleted: " + deletedTask.getDescription()
                            );
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 5: //Edit task
                    if (taskManager.getTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        TaskPrinter.printTasks(taskManager.getTasks());

                        System.out.print("Enter task number to edit: ");

                        Integer taskNumber = InputReader.readInt(
                                scanner,
                                "Enter task number to edit: "
                        );

                        if (taskNumber == null) {
                            continue;
                        }

                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();

                        boolean updated = taskManager.editTask(taskNumber, newDescription);

                        if (updated) {
                            System.out.println("Task updated.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }

                    break;
                case 6: //Exit
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