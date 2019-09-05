package Model_Class;

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

}
