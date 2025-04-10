import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private String category;

    public Task(String name, Priority priority, String category) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - Priority: " + priority + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, Priority priority, String category) {
        tasks.add(new Task(name, priority, category));
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // MISSING FEATURES:

    // 1. Remove a task by name
    public void removeTask(String name) {
        // TODO: Implement removal logic
    }

    // 2. Find all completed tasks
    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    // 3. List tasks sorted by name
    public void sortTasksByName() {
        // TODO: Implement sorting logic
    }

    // 4. Sort tasks by priority
    public void sortTasksByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
    }


    // 5. Filter tasks by category
    public List<Task> filterByCategory(String category) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }


    // 6. Find the highest-priority unfinished task
    public List<Task> getMostUrgentTasks() {
        // TODO: Implement logic to find most urgent tasks
        return new ArrayList<>();
    }

    // 7. Count tasks per category
    public Map<String, Integer> countTasksPerCategory() {
        Map<String, Integer> categoryCount = new HashMap<>();
        for (Task task : tasks) {
            categoryCount.put(task.getCategory(),
            categoryCount.getOrDefault(task.getCategory(), 0) + 1);
        }
        return categoryCount;
    }


    // 8. Mark a task as completed by name
    public void markTaskCompleted(String name) {
        // TODO: Implement completion logic
    }

    // 9. Mark all tasks in a category as completed
    public void markCategoryCompleted(String category) {
        // TODO: Implement bulk completion logic
    }
}

public class SI2025Lab1Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("Write report", Priority.HIGH, "Work");
        manager.addTask("Submit assignment", Priority.MEDIUM, "School");
        manager.addTask("Buy groceries", Priority.LOW, "Personal");
        manager.addTask("Prepare slides", Priority.HIGH, "Work");


        System.out.println("\n--- Count Tasks Per Category ---");
        System.out.println(manager.countTasksPerCategory());
      
        System.out.println("\n--- Tasks Sorted by Priority ---");
        manager.sortTasksByPriority();
        manager.printTasks();
      
        System.out.println("\n--- Completed Tasks ---");
        manager.markTaskCompleted("Buy groceries");
        System.out.println(manager.getCompletedTasks());

        System.out.println("\n--- Filtered Tasks (Work) ---");
        System.out.println(manager.filterByCategory("Work"));



        System.out.println("\n--- Filtered Tasks (Work) ---");
        System.out.println(manager.filterByCategory("Work"));
        manager.printTasks();
    }
}