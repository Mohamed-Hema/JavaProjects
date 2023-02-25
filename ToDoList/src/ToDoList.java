import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static ArrayList<Boolean> taskStatus = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("Choose an option:");
            System.out.println("1. Add task");
            System.out.println("2. Mark task as completed");
            System.out.println("3. View task list");
            System.out.println("4. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    scanner.nextLine(); // Consume newline left-over
                    String taskDescription = scanner.nextLine();
                    tasks.add(taskDescription);
                    taskStatus.add(false);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    if (taskNumber <= tasks.size() && taskNumber > 0) {
                        taskStatus.set(taskNumber - 1, true);
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    System.out.println("Task List:");
                    for (int i = 0; i < tasks.size(); i++) {
                        String status = taskStatus.get(i) ? "completed" : "not completed";
                        System.out.println((i + 1) + ". " + tasks.get(i) + " - " + status);
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}
