import Model_Class.Task;
import Model_Class.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(" ");
        boolean terminate = false;
        ArrayList<Task>  toDoList = new ArrayList<>();
        System.out.println("Hello I'm Duke");
        while (terminate == false) {
            Scanner echoObj = new Scanner(System.in);
            String input = echoObj.next().toLowerCase();
            if (input.equals("bye")) {
                terminate = true;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (Task output : toDoList) {
                    System.out.println(output.getStatusIcon() + output.getDescription());
                }
            } else if (input.contains("done")) {
                String[] splitDoneTask = input.split("\\s+");
                int doneTask = Integer.parseInt(splitDoneTask[1]) - 1;
                toDoList.get(doneTask).setDone();
                System.out.println("Nice, I have marked this task as done:");
                System.out.println(toDoList.get(doneTask).getStatusIcon() + toDoList.get(doneTask).getDescription());
            } else {
                if (input.contains("todo")) {
                    String tempToDo = echoObj.nextLine();
                    Todo newToDo = new Todo(tempToDo);
                    toDoList.add(newToDo);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newToDo.toString());
                    System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
                } else if (input.contains("deadline")) {
                    String[] splitDeadline = input.split("/");

                }
            }
        }
    }
}
