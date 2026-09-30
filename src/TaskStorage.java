import java.io.*;
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

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2);

                if (parts.length == 2) {
                    boolean completed = Boolean.parseBoolean(parts[0]);
                    String description = parts[1];

                    Task task = new Task(description);

                    if (completed) {
                        task.markCompleted();
                    }

                    tasks.add(task);
                }
            }

        } catch (IOException e) {
            System.out.println("Could not load tasks.");
        }

        return tasks;
    }
}
