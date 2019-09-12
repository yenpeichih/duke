package Model_Class;

/**
 * This class prints out general user-interface messages when the user interacts with the program.
 */
public class Ui {

    /**
     * Method to print out a greeting message.
     */
    public void getGreet() {
        System.out.println("Hello, I'm Duke!" + "\n" + "How may I help you today?");
    }

    /**
     * Method to print out a goodbye message.
     */
    public void getBye() {
        System.out.println("Thank you and have a nice day, goodbye!");
    }

    /**
     * Method to print out an error message when given an empty to-do description.
     */
    public void getWrongTodo() {
        System.out.println("Sorry, the description of a todo cannot be empty!");
    }

    /**
     * Method to print out an error message when given an empty deadline description.
     */
    public void getWrongDeadline() {
        System.out.println("Sorry, the description of a deadline cannot be empty!");
    }

    /**
     * Method to print out an error message when given an empty event description.
     */
    public void getWrongEvent() {
        System.out.println("Sorry, the description of an event cannot be empty!");
    }

    /**
     * Method to print out an error message when command is not recognisable.
     */
    public void doNotUnderstand() {
        System.out.println("Sorry, I do not know what that means.");
    }


}
