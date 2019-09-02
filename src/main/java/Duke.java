import Model_Class.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
        System.out.println("Hello from\n" + logo);
        System.out.println(" ");
        boolean terminate = false;
        File listsFile = new File("C:\\Users\\yenpe\\OneDrive\\Desktop\\School sem 3\\CS2113T\\duke\\DukeList.txt");
        ArrayList<String> toDoString = new ArrayList<>();  // the list to store input file as string
        ArrayList<Task> toDoList = new ArrayList<>();  // array list to store list as task class
        try {
            Scanner readFile = new Scanner(listsFile);
            while (readFile.hasNextLine()) {
                String tempLine = readFile.nextLine();
                try {
                    toDoString.add(tempLine);
                } catch (NullPointerException a) {
                    System.out.println("bug?");
                }
            }
            if (!toDoString.isEmpty()) {
                for (String iterate : toDoString) {
                    // split each to do line here according to [ and determine class
                    String[] splitFileString = iterate.split("\\[");
                    String[] splitFileStringTwo = splitFileString[2].split("]");
                    if (splitFileString[1].equals("T]")) {
                        Todo fileTodo = new Todo(splitFileStringTwo[1]);
                        if (splitFileStringTwo[0].equals("\u2713")) {
                            fileTodo.setDone();
                            toDoList.add(fileTodo);
                        } else {
                            toDoList.add(fileTodo);
                        }
                    } else if (splitFileString[1].equals("E]")) {
                        Event fileEvent = new Event(splitFileStringTwo[1].stripTrailing(), splitFileString[3].strip().replaceAll("at: ", "").replaceAll("\\)", ""));
                        if (splitFileStringTwo[0].equals("\u2713")) {
                            fileEvent.setDone();
                            toDoList.add(fileEvent);
                        } else {
                            toDoList.add(fileEvent);
                        }
                    } else {
                        Deadline fileDeadline = new Deadline(splitFileStringTwo[1].stripTrailing(), splitFileString[3].strip().replaceAll("by: ", "").replaceAll("\\)", ""));
                        if (splitFileStringTwo[0].equals("\u2713")) {
                            fileDeadline.setDone();
                            toDoList.add(fileDeadline);
                        } else {
                            toDoList.add(fileDeadline);
                        }
                    }
                }
            }
        } catch (IOException e) {
            // ignore
        }
        System.out.println("Hello, I'm Duke");
        System.out.println("How may I help you today?");
        while (!terminate) {
            Scanner echoObj = new Scanner(System.in);
            String input = echoObj.next().toLowerCase();
            if (input.equals("bye")) {

                // to save file upon exit
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter("DukeList.txt");
                } catch (FileNotFoundException fileNotFound) {
                    fileNotFound.printStackTrace();
                }
                for (Task fileList : toDoList) {
                    String checkTaskType = fileList.toString();
                    if (checkTaskType.charAt(1) == 'T') {
                        printWriter.println(checkTaskType);
                    } else if (checkTaskType.charAt(1) == 'E') {
                        char[] convertToChar = checkTaskType.toCharArray();
                        for (int i = 0; i < checkTaskType.length(); i += 1) {
                            if (convertToChar[i] == '(') {
                                convertToChar[i] = '[';
                            }
                        }
                        String newString = new String(convertToChar);
                        printWriter.println(newString);
                    } else {
                        char[] convertToChar = checkTaskType.toCharArray();
                        for (int i = 0; i < checkTaskType.length(); i += 1) {
                            if (convertToChar[i] == '(') {
                                convertToChar[i] = '[';
                            }
                        }
                        String newString = new String(convertToChar);
                        printWriter.println(newString);
                    }
                }
                printWriter.close();
                System.out.println("Thank you and have a nice day, goodbye!");
                terminate = true;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (Task output : toDoList) {
                    System.out.println(output.toString());
                }
            } else if (input.contains("done")) {
                String tempDoneTask = echoObj.nextLine();
                int doneTask = Integer.parseInt(tempDoneTask.strip()) - 1;
                toDoList.get(doneTask).setDone();
                System.out.println("Nice, I have marked this task as done:");
                System.out.println(toDoList.get(doneTask).getStatusIcon() + toDoList.get(doneTask).getDescription());
            } else {
                if (input.contains("todo")) {
                    String tempCheckTodo = echoObj.nextLine();
                    if (tempCheckTodo.equals("")) {
                        System.out.println("Sorry, the description of a todo cannot be empty!");
                    } else {
                        Todo newToDo = new Todo(tempCheckTodo);
                        toDoList.add(newToDo);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(newToDo.toString());
                        System.out.println("Now you have " + toDoList.size() + " task(s) in the list.");
                   }
                } else if (input.contains("deadline")) {
                    String pattern = "yyyy-MM-dd HHmm";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    String tempDeadline = echoObj.nextLine();
                    if (tempDeadline.equals("")) {
                        System.out.println("Sorry, the description of a deadline cannot be empty!");
                    } else {
                        String[] splitDeadline = tempDeadline.split("/");
                        try {
                            Date date = dateFormat.parse(splitDeadline[1]);
                            String dateString = date.toString();
                            Deadline newDeadline = new Deadline(splitDeadline[0], dateString);
                            toDoList.add(newDeadline);
                            System.out.println("Got it. I've added this task:");
                            System.out.println(newDeadline.toString());
                            System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
                        } catch (ParseException p) {
                            System.out.println("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.");
                        }
                    }
                } else if (input.contains("event")) {
                    String pattern = "yyyy-MM-dd HHmm";
                    SimpleDateFormat dateFormat = new SimpleDateFormat((pattern));
                    String tempEvent = echoObj.nextLine();
                    if (tempEvent.equals("")) {
                        System.out.println("Sorry, the description of an event cannot be empty!");
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
                            System.out.println("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.");
                        }
                    }
                } else {
                    System.out.println("Sorry, I do not know what that means.");
                }
            }
        }
    }
}
