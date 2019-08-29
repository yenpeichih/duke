import Model_Class.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
//        System.out.println(" ");
        boolean terminate = false;
        ArrayList<Task>  toDoList = new ArrayList<>();
        System.out.println("Hello I'm Duke");
        while (terminate == false) {
            Scanner echoObj = new Scanner(System.in);
            Scanner markDone = new Scanner(System.in);
            String input = echoObj.nextLine();
            if (input.equals("bye")) {
                terminate = true;
            } else if (input.equals("list")) {
                for (Task output : toDoList) {
                    System.out.println(output.getStatusIcon() + output.getDescription());
                }
            } else if (input.contains("done")) {
                String[] test = input.split("\\s+");
                int doneTask = Integer.parseInt(test[1]) - 1;
                toDoList.get(doneTask).setDone();
                System.out.println("Nice I have marked this task as done:");
                System.out.println(toDoList.get(doneTask).getStatusIcon() + toDoList.get(doneTask).getDescription());
            } else {
                Task toAdd = new Task(input);
                toDoList.add(toAdd);
                System.out.println("added: " + input);
            }
        }
    }
}
