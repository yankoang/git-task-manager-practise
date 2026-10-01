import java.util.ArrayList;

public class TaskPrinter {

    public static void printTasks(ArrayList<Task> tasks) {
        System.out.println("Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            String status = currentTask.isCompleted() ? "[X]" : "[ ]";

            System.out.println(
                    (i + 1) + ". " + status + " " + currentTask.getDescription()
            );
        }
    }
}
