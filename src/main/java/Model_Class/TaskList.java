package Model_Class;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> toDoList;
    public String checkString;
    public Ui ui;

    public TaskList(ArrayList<Task> toDoList, String checkString) {
        this.toDoList = toDoList;
        this.checkString = checkString;
    }

    public void addTodo() {
        Todo newToDo = new Todo(checkString);
        toDoList.add(newToDo);
        System.out.println("Got it. I've added this task:");
        System.out.println(newToDo.toString());
        System.out.println("Now you have " + toDoList.size() + " task(s) in the list.");
    }

    public void addDeadline() {
        String pattern = "yyyy-MM-dd HHmm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String[] splitDeadline = checkString.split("/");
        Parsing parseDeadline = new Parsing(dateFormat, splitDeadline[1]);
        if (parseDeadline.parseDate().equals("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.")) {
            System.out.println(parseDeadline.parseDate());
        } else {
            Deadline newDeadline = new Deadline(splitDeadline[0], parseDeadline.parseDate());
            toDoList.add(newDeadline);
            System.out.println("Got it. I've added this task:");
            System.out.println(newDeadline.toString());
            System.out.println("Now you have " + toDoList.size() + " task(s) in the list.");
        }
    }

    public void addEvent() {
        String pattern = "yyyy-MM-dd HHmm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String[] splitEvent = checkString.split("/");
        Parsing parseEvent = new Parsing(dateFormat, splitEvent[1]);
        if (parseEvent.parseDate().equals("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.")) {
            System.out.println(parseEvent.parseDate());
        } else {
            Event newEvent = new Event(splitEvent[0], parseEvent.parseDate());
            toDoList.add(newEvent);
            System.out.println("Got it. I've added this task:");
            System.out.println(newEvent.toString());
            System.out.println("Now you have " + toDoList.size() + " task(s) in the list.");
        }
    }

    public void setAsDone() {
        int doneTask = Integer.parseInt(checkString.strip()) - 1;
        toDoList.get(doneTask).setDone();
        System.out.println("Nice, I have marked this task as done:");
        System.out.println(toDoList.get(doneTask).getStatusIcon() + toDoList.get(doneTask).getDescription());
    }

    public void removeTask() {
        int deleteTask = Integer.parseInt(checkString.strip()) - 1;
        System.out.println("Okay, I have removed this task from your list: ");
        System.out.println(toDoList.get(deleteTask).getStatusIcon() + toDoList.get(deleteTask).getDescription());
        toDoList.remove(deleteTask);
        System.out.println("You now have " + toDoList.size() + " tasks(s) in the list." );
    }

}
