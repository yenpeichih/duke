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
        ArrayList<String>  toDoList = new ArrayList<>();
        System.out.println("Hello I'm Duke");
        while (terminate == false) {
            Scanner echoObj = new Scanner(System.in);
            String input = echoObj.nextLine();
            if (input.equals("bye")) {
                terminate = true;
            } else if (!input.equals("list")){
                toDoList.add(input);
                System.out.println("added: " + input);
            } else {
                for (String output : toDoList) {
                    System.out.println(output);
                }
            }
        }
    }
}
