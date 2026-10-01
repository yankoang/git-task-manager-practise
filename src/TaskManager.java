import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = TaskStorage.loadTasks();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);

        TaskStorage.saveTasks(tasks);
    }

    public boolean completeTask(int taskNumber) {
        int taskIndex = taskNumber - 1;

        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            return false;
        }

        Task selectedTask = tasks.get(taskIndex);

        if (selectedTask.isCompleted()) {
            return false;
        }

        selectedTask.markCompleted();
        TaskStorage.saveTasks(tasks);

        return true;
    }

    public Task deleteTask(int taskNumber) {
        int taskIndex = taskNumber - 1;

        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            return null;
        }

        Task deletedTask = tasks.remove(taskIndex);
        TaskStorage.saveTasks(tasks);

        return deletedTask;
    }

    public boolean editTask(int taskNumber, String newDescription) {
        int taskIndex = taskNumber - 1;

        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            return false;
        }

        Task selectedTask = tasks.get(taskIndex);
        selectedTask.updateDescription(newDescription);

        TaskStorage.saveTasks(tasks);

        return true;
    }
}