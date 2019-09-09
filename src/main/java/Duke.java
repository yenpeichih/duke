import Model_Class.*;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\n");
        boolean terminate = false;
        File listsFile = new File("C:\\Users\\yenpe\\OneDrive\\Desktop\\School sem 3\\CS2113T\\duke\\DukeList.txt");
        Storage storage = new Storage(listsFile);
        // array list to store list as task class
        ArrayList<Task> toDoList = storage.loadFile();
        Ui ui = new Ui();
        ui.getGreet();
        while (!terminate) {
            Scanner echoObj = new Scanner(System.in);
            String input = echoObj.next().toLowerCase();
            String tempCheckString = echoObj.nextLine();
            TaskList taskList = new TaskList(toDoList, tempCheckString);
            if (input.equals("bye")) {
                storage.saveFile();
                ui.getBye();
                terminate = true;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (Task output : toDoList) {
                    System.out.println(output.toString());
                }
            } else if (input.contains("done")) {
                taskList.setAsDone();
            } else if (input.contains("delete")) {
                taskList.removeTask();
            } else if (input.contains("find")) {
                System.out.println("Here are the matching tasks in the list");
                for (Task findTask : toDoList) {
                    if (findTask.toString().contains(tempCheckString)) {
                        System.out.println(findTask.toString());
                    }
                }
            } else {
                if (input.contains("todo")) {
                    if (tempCheckString.equals("")) {
                        ui.getWrongTodo();
                    } else {
                        taskList.addTodo();
                   }
                } else if (input.contains("deadline")) {
                    if (tempCheckString.equals("")) {
                        ui.getWrongDeadline();
                    } else {
                        taskList.addDeadline();
                    }
                } else if (input.contains("event")) {
                    if (tempCheckString.equals("")) {
                        ui.getWrongEvent();
                    } else {
                        taskList.addEvent();
                    }
                } else {
                    ui.doNotUnderstand();
                }
            }
        }
    }
}
