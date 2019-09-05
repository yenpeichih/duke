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
                int doneTask = Integer.parseInt(tempCheckString.strip()) - 1;
                toDoList.get(doneTask).setDone();
                System.out.println("Nice, I have marked this task as done:");
                System.out.println(toDoList.get(doneTask).getStatusIcon() + toDoList.get(doneTask).getDescription());
            } else if (input.contains("delete")) {
                int deleteTask = Integer.parseInt(tempCheckString.strip()) - 1;
                System.out.println("Okay, I have removed this task from your list: ");
                System.out.println(toDoList.get(deleteTask).getStatusIcon() + toDoList.get(deleteTask).getDescription());
                toDoList.remove(deleteTask);
                System.out.println("You now have " + toDoList.size() + " tasks(s) in the list." );
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
                    String pattern = "yyyy-MM-dd HHmm";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    if (tempCheckString.equals("")) {
                        ui.getWrongDeadline();
                    } else {
                        String[] splitDeadline = tempCheckString.split("/");
                        try {
                            Date date = dateFormat.parse(splitDeadline[1]);
                            String dateString = date.toString();
                            Deadline newDeadline = new Deadline(splitDeadline[0], dateString);
                            System.out.println("Got it. I've added this task:");
                            System.out.println(newDeadline.toString());
                            System.out.println("Now you have " + toDoList.size() + " tasks(s) in the list.");
                        } catch (ParseException p) {
                            ui.getWrongDateFormat();
                        }
                    }
                } else if (input.contains("event")) {
                    String pattern = "yyyy-MM-dd HHmm";
                    SimpleDateFormat dateFormat = new SimpleDateFormat((pattern));
                    String tempEvent = echoObj.nextLine();
                    if (tempEvent.equals("")) {
                        ui.getWrongEvent();
                    } else {
                        String[] splitEvent = tempEvent.split("/");
                        try {
                            Date date = dateFormat.parse(splitEvent[1]);
                            String dateString = date.toString();
                            Event newEvent = new Event(splitEvent[0], dateString);
                            toDoList.add(newEvent);
                            System.out.println("Got it. I've added this task:");
                            System.out.println(newEvent.toString());
                            System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
                        } catch (ParseException p) {
                            ui.getWrongDateFormat();
                        }
                    }
                } else {
                    ui.doNotUnderstand();
                }
            }
        }
    }
}
