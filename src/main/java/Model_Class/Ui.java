package Model_Class;

import javax.print.DocFlavor;

public class Ui {

    public void getGreet() {
        System.out.println("Hello, I'm Duke!" + "\n" + "How may I help you today?");
    }

    public void getBye() {
        System.out.println("Thank you and have a nice day, goodbye!");
    }

    public void getWrongTodo() {
        System.out.println("Sorry, the description of a todo cannot be empty!");
    }

    public void getWrongDeadline() {
        System.out.println("Sorry, the description of a deadline cannot be empty!");
    }

    public void getWrongEvent() {
        System.out.println("Sorry, the description of an event cannot be empty!");
    }

    public void getWrongDateFormat() {
        System.out.println("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.");
    }

    public void doNotUnderstand() {
        System.out.println("Sorry, I do not know what that means.");
    }


}
