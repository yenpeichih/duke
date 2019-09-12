import Model_Class.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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
                taskList.listTask();
            } else if (input.contains("done")) {
                taskList.setAsDone();
                storage.saveFile();
            } else if (input.contains("delete")) {
                taskList.removeTask();
                storage.saveFile();
            } else if (input.contains("find")) {
                taskList.findTask();
            } else {
                if (input.contains("todo")) {
                    if (tempCheckString.equals("")) {
                        ui.getWrongTodo();
                    } else {
                        taskList.addTodo();
                        storage.saveFile();
                   }
                } else if (input.contains("deadline")) {
                    if (tempCheckString.equals("")) {
                        ui.getWrongDeadline();
                    } else {
                        taskList.addDeadline();
                        storage.saveFile();
                    }
                } else if (input.contains("event")) {
                    if (tempCheckString.equals("")) {
                        ui.getWrongEvent();
                    } else {
                        taskList.addEvent();
                        storage.saveFile();
                    }
                } else {
                    ui.doNotUnderstand();
                }
            }
        }
    }
}
