package Model_Class;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * This class handles the manipulation of the task list, whether it is to add/remove tasks, set tasks as done or
 * finding an item in the list.
 */
public class TaskList {

    public ArrayList<Task> toDoList;
    public String checkString;

    /**
     * The constructor for this class.
     *
     * @param toDoList The to-do list
     * @param checkString The string following the command string
     */
    public TaskList(ArrayList<Task> toDoList, String checkString) {
        this.toDoList = toDoList;
        this.checkString = checkString;
    }

    /**
     * The method to add tasks of To-do class into the list.
     */
    public void addTodo() {
        Todo newToDo = new Todo(checkString);
        toDoList.add(newToDo);
        System.out.println("Got it. I've added this task:");
        System.out.println(newToDo.toString());
        System.out.println("Now you have " + toDoList.size() + " task(s) in the list.");
    }

    /**
     * The method to add tasks of Deadline class into the list.
     */
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

    /**
     * The method to add tasks of Event class into the list.
     */
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

    /**
     * The method to mark tasks as done.
     */
    public void setAsDone() {
        int doneTask = Integer.parseInt(checkString.strip()) - 1;
        toDoList.get(doneTask).setDone();
        System.out.println("Nice, I have marked this task as done:");
        System.out.println(toDoList.get(doneTask).getStatusIcon() + toDoList.get(doneTask).getDescription());
    }

    /**
     * The method to remove tasks from the list.
     */
    public void removeTask() {
        int deleteTask = Integer.parseInt(checkString.strip()) - 1;
        System.out.println("Okay, I have removed this task from your list: ");
        System.out.println(toDoList.get(deleteTask).getStatusIcon() + toDoList.get(deleteTask).getDescription());
        toDoList.remove(deleteTask);
        System.out.println("You now have " + toDoList.size() + " tasks(s) in the list." );
    }

    /**
     * The method to find tasks.
     */
    public void findTask() {
        System.out.println("Here are the matching tasks in the list");
        for (Task findingTask : toDoList) {
            if (findingTask.toString().contains(checkString)) {
                System.out.println(findingTask.toString());
            }
        }
    }

    /**
     * The method to display the current to-do list.
     */
    public void listTask() {
        System.out.println("Here are the tasks in your list:");
        for (Task output : toDoList) {
            System.out.println(output.toString());
        }
    }

}
