import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskStorage {

    private static final String FILE_NAME = "tasks.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Task task : tasks) {
                writer.write(
                        task.isCompleted() + "|" + task.getDescription()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Could not save tasks.");
        }
    }
}
