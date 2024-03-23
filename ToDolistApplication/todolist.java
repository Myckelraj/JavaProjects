package ToDolist;

import java.util.ArrayList;
import java.util.Scanner;

public class todolist
{
    public static void main(String[] args) {
        
    ArrayList<String> tasks=new ArrayList<>();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {

                System.out.println("To-Do List Menu:");
                System.out.println("1.Add a task");
                System.out.println("2.View Tasks");
                System.out.println("3.Mark task as done");
                System.out.println("4.Exit");
                System.out.println("Enter Your Choice");
                int choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a task: ");
                        String task = in.nextLine();
                        tasks.add(task);
                        System.out.println("Your are Added: " + task);
                    }
                    case 2 -> {
                        System.out.println("Tasks in your To-do list:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + "." + tasks.get(i));
                        }
                    }
                    case 3 -> {
                        if (tasks.isEmpty()) {
                            System.out.println("Your to-do-list is Empty");

                        } else {
                            System.out.println("Enter the task number to mark as a done");
                            int taskNumber = in.nextInt();
                            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                                String removeTask = tasks.remove(taskNumber - 1);
                                System.out.println("Marked task as done " + removeTask);
                            } else {
                                System.out.println("Invalid Task Number.");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("GoodBye");
                        System.exit(0);
                    }
                    default -> {
                    }
                }
            }
        }
    }
    
}
